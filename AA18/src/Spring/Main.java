package Spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




public class Main 
{	

	static ArrayList<Double> ListaPIB = new ArrayList<>();
	
	public static void multiplicar (double Habitantes, double Salario, multiplicacion formato)
	{
		
		double resultado = formato.ejecutar(Habitantes,  Salario);
		ListaPIB.add(resultado);	
	}
	public static void main(String [] arg) 
	{
		
		File documento = new File("C:\\Users\\sga_1\\Carpeta Trabajo Inicial\\AA18\\INFO_PAISES.txt");
		String lineas;
		String[] items;
		String[] items2;
		ArrayList<String> ListaDatos = new ArrayList<String>();
		ArrayList<InfoPaises> ListaPaises = new ArrayList<>();
		ArrayList<Double> NumeroHabitantes = new ArrayList<>();
		ArrayList<Double> ListaSalario = new ArrayList<>();
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class))
		{
			///////////////// LECTURA ARCHIVO ///////////////////////////////////
			Scanner sc = new Scanner(documento);
			while (sc.hasNextLine()) 
				{
				lineas = sc.nextLine();
				items = lineas.split("\\:+\\t");
				items2 = items[1].split("\\t");
				ListaDatos.add(items2[0]);
				}
			sc.close();
			
			InfoPaises[] Pais = new InfoPaises[ListaDatos.size()];
			for (int i=0;i<4;i++)
			{
				for (int j=6*i; j<6*i+1;j++)
				{
					
					Pais[j] = new InfoPaises(ListaDatos.get(j), ListaDatos.get(j+1), ListaDatos.get(j+2), ListaDatos.get(j+3), ListaDatos.get(j+4), ListaDatos.get(j+5));
					ListaPaises.add(Pais[j]);
					
				}
			}
			//////////////////////PARSEO DE SALARIOS /////////////////////////////////////
			for (int k=0;k<ListaPaises.size();k++)
			{
				NumeroHabitantes.add(Double.parseDouble(ListaPaises.get(k).getNumero_Habitantes()));
				ListaSalario.add(Double.parseDouble(ListaPaises.get(k).getSalario_Mínimo()));
					
			}
			
			
			/////////////// FUNCION LAMBDA PARA EL PIB DE CADA PAÍS ///////////////////////

				multiplicacion multiplicacion_lambda = (double t1, double t2) -> t1*t2;
				
				{
					double t1;
					double t2;
					for (int t = 0; t<ListaPaises.size();t++)
							{
							t1 = NumeroHabitantes.get(t);
							t2 = ListaSalario.get(t);
							multiplicar(t1, t2, multiplicacion_lambda);
							
							}
					
				}
			//////////////////////// AOP //////////////////////////////////////
			//////////////////IMPRESIÓN ARCHIVOS ///////////////////////////////
			String TextoTXT;
			String NombreArchivo;
			for (int k=0;k<ListaPaises.size();k++)
			{
			
			TextoTXT = (ListaPaises.get(k) + "\n" + "PIB: "+ListaPIB.get(k)+"€"+"\n"+"\n");
			NombreArchivo = ("Salida_"+ListaPaises.get(k).getNombre_Pais()+".txt");
			Path file = Paths.get(NombreArchivo);				
			List<String> lineas2 = Arrays.asList(TextoTXT);
			Files.write(file, lineas2, StandardCharsets.UTF_8);
			}
			Servicio servicio = ctx.getBean(Servicio.class);
			servicio.generartxt();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public interface multiplicacion
	{
			double ejecutar (double Habitantes, double Salario);
	}

}




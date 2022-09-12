package Spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main extends Usuario implements TotalRecaudado
{
	int IngresoPorReproduccion;

	public int getIngresoPorReproduccion() {
		return IngresoPorReproduccion;
	}

	public void setIngresoPorReproduccion(int ingresoPorReproduccion) {
		IngresoPorReproduccion = ingresoPorReproduccion;
	}
	

	public Main(int ingresoPorReproduccion) {
		super();
		IngresoPorReproduccion = ingresoPorReproduccion;
	}

	String nombreArchivo;
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Main(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}
	
	public static void main(String [] arg) throws BeansException
	{
		
		Main obj = new Main(2);
		Main obj2 = new Main("Salida_Canciones_y_Artistas_"+LocalDate.now()+".txt");
		File Canciones_2020 = new File("C:\\Users\\sga_1\\Carpeta Trabajo Inicial\\AA16\\Canciones 2020.txt");
		File Canciones_2021 = new File("C:\\Users\\sga_1\\Carpeta Trabajo Inicial\\AA16\\Canciones 2021.txt");
		File Artistas_2020 = new File("C:\\Users\\sga_1\\Carpeta Trabajo Inicial\\AA16\\Artistas 2020.txt");
		File Artista_2021 = new File("C:\\Users\\sga_1\\Carpeta Trabajo Inicial\\AA16\\Artistas 2021.txt");
		ArrayList<String> Canciones2020 = new ArrayList<String>();
		ArrayList<String> Reproducciones2020 = new ArrayList<String>();
		ArrayList<String> Canciones2021 = new ArrayList<String>();
		ArrayList<String> Reproducciones2021 = new ArrayList<String>();
		ArrayList<String> Artistas2020 = new ArrayList<String>();
		ArrayList<String> Artistas2021 = new ArrayList<String>();


		ArrayList<Integer> ReproduccionesInt2020 = new ArrayList<Integer>();
		ArrayList<Integer> ReproduccionesInt2021 = new ArrayList<Integer>();
		String[] items1;
		String lineas1;
		String[] items2;
		String lineas2;
		String[] items3;
		String lineas3;
		String[] items4;
		String lineas4;

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class))
		{
			Scanner sc1 = new Scanner(Canciones_2020);
			Scanner sc2 = new Scanner(Canciones_2021);
			Scanner sc3 = new Scanner(Artistas_2020);
			Scanner sc4 = new Scanner(Artista_2021);
			
				while (sc1.hasNextLine()) 
				{
					lineas1 = sc1.nextLine();
					items1 = lineas1.split("\\t");
					Canciones2020.add(items1[0]);
					Reproducciones2020.add(items1[1]);
					
				}
				sc1.close();
				
				while (sc2.hasNextLine()) 
				{
					lineas2 = sc2.nextLine();
					items2 = lineas2.split("\\t");
					Canciones2021.add(items2[0]);
					Reproducciones2021.add(items2[1]);
					
					
				}
				
				sc2.close();
				
				while (sc3.hasNextLine()) 
				{
					lineas3 = sc3.nextLine();
					items3 = lineas3.split("\\t");
					Artistas2020.add(items3[0]);
					
				}
				sc3.close();
				while (sc4.hasNextLine()) 
				{
					lineas4 = sc4.nextLine();
					items4 = lineas4.split("\\t");
					Artistas2021.add(items4[0]);
					
				}
				sc4.close();

				for (int i=0;i<(Canciones2020.size());i++)
				{
					ReproduccionesInt2020.add(Integer.parseInt(Reproducciones2020.get(i)));
	
				}
				for (int i=0;i<(Canciones2021.size());i++)
				{
					ReproduccionesInt2021.add(Integer.parseInt(Reproducciones2021.get(i)));
	
				}
				
				
				Canciones [] C2020  = new Canciones[Canciones2020.size()];
				Canciones [] C2021  = new Canciones[Canciones2021.size()];
				Artistas [] A2020  = new Artistas[Artistas2020.size()];
				Artistas [] A2021  = new Artistas[Artistas2021.size()];
				
				
				ArrayList<Canciones> ListaCanciones2020 = new ArrayList<>();
				for (int i=0;i<Canciones2020.size();i++)
				{
				    C2020[i] = new Canciones(Canciones2020.get(i), ReproduccionesInt2020.get(i), (obj.IngresoPorReproduccion*ReproduccionesInt2020.get(i)));
				    ListaCanciones2020.add(C2020[i]);
				}
				
				ArrayList<Canciones> ListaCanciones2021 = new ArrayList<>();
				ArrayList<Artistas> ListaArtistas2020 = new ArrayList<>();
				ArrayList<Artistas> ListaArtistas2021 = new ArrayList<>();
				for (int j=0;j<Canciones2021.size();j++)
				{
					 C2021[j] = new Canciones(Canciones2021.get(j), ReproduccionesInt2021.get(j), (obj.IngresoPorReproduccion*ReproduccionesInt2021.get(j)));
					 ListaCanciones2021.add(C2021[j]);
					 
					 A2020[j] = new Artistas(Artistas2020.get(j));
					 ListaArtistas2020.add(A2020[j]);
					 
					 A2021[j] = new Artistas(Artistas2021.get(j));
					 ListaArtistas2021.add(A2021[j]);
				}

				
				
				
				
				
				
				String TextoTXT = ("------------ TOP CANCIONES 2020 ------------ " + "\n" + ListaCanciones2020.toString() + "\n" + "\n" +
								   "------------ TOP CANCIONES 2021 ------------ " + "\n" + ListaCanciones2021.toString() + "\n" + "\n" +
								   "------------ TOP ARTISTAS 2020 ------------ " + "\n" + ListaArtistas2020.toString() + "\n" + "\n" +
								   "------------ TOP ARTISTAS 2021 ------------ " + "\n" + ListaArtistas2021.toString() + "\n" + "\n");
				Path file = Paths.get(obj2.nombreArchivo);				
				List<String> lineas = Arrays.asList(TextoTXT);
				Files.write(file, lineas, StandardCharsets.UTF_8);

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
}
interface TotalRecaudado
{	
	
}
class Usuario
{
	int IDusuario = 1234;
	String NombreUsuario = "Sergio González Acosta";
	

}

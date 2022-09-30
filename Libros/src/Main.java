import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.json.*;
import java.time.LocalDate;
public class Main implements Archivos//implementamos la interface
{
	
	public Path Salida(String nombreArchivo, String Texto) throws IOException
	{
		Path file1 = Paths.get(nombreArchivo);				
		List<String> lineas1 = Arrays.asList(Texto);
		return Files.write(file1, lineas1, StandardCharsets.UTF_8);
	}
	
	static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	public static void main(String[] args) 
	{
		/*
		 * 	inicio variable contador; para poder controlar el número de veces que se va a ejecutar el
			bucle utilizamos una variable. Esta variable puede estar declarada anteriormente o
			podemos declararla en el bucle. Con iniciar nos referimos a dar un valor inicial a la variable.
			• condición; el bucle se ejecutará mientras se cumpla la condición.
			• modificación; cada vez que se ejecute el bucle procedemos a modificar la variable
			contador. Lo más común suele ser incrementar o decrementar su valor.
			• cuerpo del bucle; se denomina de esta forma al conjunto de instrucción que se ejecutan
			de forma repetitiva. 
		 */
		 //definimos la dimensión del Array del objetp U de la clase tipo Uusuario (Obligatoriamente)
		ArrayList<Usuario> U = new ArrayList<>();
		for (int i=0/*Inicio de la variable*/;i<3/*condición*/;i++/*modificación*/)
		{
			/*cuerpo del bucle*/
			U.add(new Usuario("Sergio", i));
		}
		
		

		try
		{
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/28");
			HttpURLConnection conexión = (HttpURLConnection) url.openConnection();
			conexión.connect();
			StringBuilder información = new StringBuilder();
			Scanner sc = new Scanner(url.openStream());
			int tiempoderespuesta = conexión.getResponseCode();
			
			if(tiempoderespuesta != 200)
			{
				throw new RuntimeException("HttpResponse" + tiempoderespuesta);
			}
			else
			{

				while(sc.hasNext())
				{
					información.append(sc.nextLine());
					
				}
				sc.close();
			}
			String datos = información.toString();
			ArrayList<Tiempo> listaTiempo = new ArrayList<>();
			JSONObject datosjson = new JSONObject(datos);
			JSONArray datosCiudades = new JSONArray(datosjson.getJSONArray("ciudades"));
			
			for (Object iter: datosCiudades) //bucle FOR-EACH cuya variable es de tipo Object (para colecciones claves)
			{
				
				listaTiempo.add(new Tiempo(((JSONObject) iter).getString("name"), ((JSONObject) iter).getJSONObject("stateSky").getString("description"), Integer.parseInt(((JSONObject) iter).getJSONObject("temperatures").getString("max")), Integer.parseInt(((JSONObject) iter).getJSONObject("temperatures").getString("min"))));
				// sobre cada elemento del JSONArray, estamos creando un JSONObject -> ((JSONObject) iter) <-
			}
			ArrayList<String> texto1 = new ArrayList<>();
			Main obj = new Main(); //creamos un objeto de la clase donde hayamos implementado la interface
			for (Tiempo iter2:listaTiempo)
			{
				
				if(iter2.getTemperatura_max() >= 24)
				{
					texto1.add(iter2+"Gradiente: "+(iter2.getTemperatura_max()-iter2.getTemperatura_min())+"\n"+"En "+iter2.getNombre()+" hace "+"Calor" +"\n");
				}
				else
				{
					texto1.add(iter2+"Gradiente: "+(iter2.getTemperatura_max()-iter2.getTemperatura_min())+"\n"+"En "+iter2.getNombre()+" hace "+"Frío"+"\n");
				}
					for (int i=0;i<texto1.size();i++)
					{
						obj.Salida("Salida_"+iter2.getNombre()+"_"+LocalDate.now()+".txt", texto1.get(i));
					}
				
			}
			
			
			
		}
		
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}

interface Archivos
{
	public Path Salida(String nombreArchivo, String Texto) throws IOException;
}


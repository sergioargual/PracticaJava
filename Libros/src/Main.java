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
public class Main implements Archivos, API
{
	
	public Path Salida(String nombreArchivo, String Texto) throws IOException
	{
		Path file = Paths.get(nombreArchivo);				
		List<String> lineas = Arrays.asList(Texto);
		return Files.write(file, lineas, StandardCharsets.UTF_8); //el return es de tipo path, ya que Files es de tipo Path, por tanto el método ha de ser de tipo Path
	}
	public String Conexion(String url) throws Exception
	{
		URL url1 = new URL(url);
		HttpURLConnection conexión = (HttpURLConnection) url1.openConnection();
		conexión.connect();
		StringBuilder información = new StringBuilder();
		Scanner sc = new Scanner(url1.openStream());
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
		return datos; //nuestro return es de tipo String, por lo que el método ha de ser también de tipo String
	}
	
	static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	public static void main(String[] args) 
	{

		try
		{
			Main obj = new Main(); //creamos un objeto de la clase donde hayamos implementado la interface	
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			ArrayList<Tiempo> listaTiempo = new ArrayList<>();
			JSONObject datosjson = new JSONObject(obj.Conexion("https://www.el-tiempo.net/api/json/v2/provincias/28"));
			JSONArray datosCiudades = new JSONArray(datosjson.getJSONArray("ciudades"));
			
			for (Object iter: datosCiudades) //bucle FOR-EACH cuya variable es de tipo Object (para colecciones claves)
			{
				
				listaTiempo.add(new Tiempo(((JSONObject) iter).getString("name"), ((JSONObject) iter).getJSONObject("stateSky").getString("description"), Integer.parseInt(((JSONObject) iter).getJSONObject("temperatures").getString("max")), Integer.parseInt(((JSONObject) iter).getJSONObject("temperatures").getString("min"))));
				// sobre cada elemento del JSONArray, estamos creando un JSONObject -> ((JSONObject) iter) <-DEFINIMOS EL TIPO DE OBJETO QUE ES iter
			}
			
			ArrayList<String> texto1 = new ArrayList<>();
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
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			ArrayList<Universidad> listaUniversidades = new ArrayList<>();
			JSONArray datosUniversidades = new JSONArray(obj.Conexion("http://universities.hipolabs.com/search?country=United+Kingdom"));
			for (Object iter3: datosUniversidades)
			{
				listaUniversidades.add(new Universidad(((JSONObject) iter3).getString("name"),(((JSONObject) iter3).getJSONArray("web_pages").get(0).toString())));
			}
			
			ArrayList<String> texto2 = new ArrayList<>();
			for (Universidad iter4:listaUniversidades)
			{
				
				
					texto2.add(iter4.toString());

					for (int i=0;i<texto2.size();i++)
					{
						obj.Salida("Salida_"+iter4.getNombre()+"_"+LocalDate.now()+".txt", texto2.get(i));
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
interface API
{
	public String Conexion(String url) throws Exception;
}


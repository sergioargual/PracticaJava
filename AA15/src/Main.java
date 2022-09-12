import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



public class Main extends API implements CreacionArchivo
{
	public String getArchivo()
	{
		String nombreArchivo = "Salida_Provincias_"+LocalDate.now()+".txt";
		
		return nombreArchivo;

		
	}
	public static void main (String [] args) 
	{
		
		//SIEMPRE QUE USEMOS API REST, TRY-CATCH


		try
		{
			Main obj4 = new Main();
			URL url = new URL (obj4.URL); 
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Declaro la conexion
			conn.connect(); 
	
			Scanner sc = new Scanner(url.openStream());
			String json = "";
			
			int tiempoRespuesta = conn.getResponseCode(); 
			
			if(tiempoRespuesta != 200)
			{
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			}
			else
			{

				while(sc.hasNext())
				{
					 json = json + sc.nextLine();
				}
				sc.close();

				String datos = json.toString();
				JSONObject obj = new JSONObject(datos);
				ArrayList<String> list = new ArrayList<String>();
				JSONArray datos2 =  obj.getJSONArray("facet_groups");				
				list.add(datos2.get(0).toString());
				JSONObject obj2 = new JSONObject(list.get(0));
				ArrayList<String> list2 = new ArrayList<String>();
				JSONArray datos3 =  obj2.getJSONArray("facets");
				List<Provincia> listaProvincia = new ArrayList<>();
				
				  for(Object iter:datos3) 
				  {
		            listaProvincia.add(new Provincia(((JSONObject) iter).getString("name"), ((JSONObject) iter).getString("path")));
		          }
				  Usuario U = new Usuario(1, "Vargas,Gustavo", LocalDate.now());
				  
				  String TextoTXT = U + listaProvincia.toString();
				  Path file = Paths.get(obj4.getArchivo());				
				  List<String> lineas = Arrays.asList(TextoTXT);
				  Files.write(file, lineas, StandardCharsets.UTF_8);
				  
				  
				  String TextoJenkins = "pipeline \r\n"
				  		+ "{\r\n"
				  		+ "    agent any\r\n"
				  		+ "    stages \r\n"
				  		+ "    {\r\n"
				  		+ "        stage('Provincias') \r\n"
				  		+ "        {\r\n"
				  		+ "            steps\r\n"
				  		+ "            {\r\n"
				  		+ "					echo "+"'"+TextoTXT+"'"
				  		+ "            }\r\n"
				  		+ "        }\r\n"
				  		+ "    }\r\n"
				  		+ "}";
				  String jenkins = "jenkinsfileAA15";
				  Path file2 = Paths.get(jenkins);
				  List<String> lineas2 = Arrays.asList(TextoJenkins);
				  Files.write(file2, lineas2, StandardCharsets.UTF_8);
				  
				  
				
			}	
;		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
   }

}

interface CreacionArchivo
{
}

class API
{
	String URL = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=provincia";
}

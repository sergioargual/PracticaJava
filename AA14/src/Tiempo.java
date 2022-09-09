import java.io.File;
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
import org.json.JSONArray;
import org.json.JSONObject;
import java.time.LocalDate;

public class Tiempo extends Chocolates implements produccionActiva
{
	public void produccionActiva()
	{
	
	}
	public static void main (String [] arg)
	{
		try
		{

			URL url = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/41"); //Declaro la URL
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Declaro la conexion
			conn.connect(); //Abro la conexion
			StringBuilder informacionString = new StringBuilder();
			Scanner sc = new Scanner(url.openStream());
			
			int tiempoRespuesta = conn.getResponseCode(); 
			
			if(tiempoRespuesta != 200)
			{
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			}
			else
			{

				while(sc.hasNext())
				{
					informacionString.append(sc.nextLine());
				}
				sc.close();
			
			}
			    String nombreArchivo1 = "Produccion_"+LocalDate.now()+".txt";
			    String nombreArchivo2 = "jenkinsfileAA14.txt";
				String datos = informacionString.toString();
				JSONObject obj = new JSONObject(datos);
				/*
				String Temperatura = obj.getJSONObject("temperatures").getString("max");
				*/
				ArrayList<String> list = new ArrayList<String>();
				JSONArray Ciudades =  obj.getJSONArray("ciudades");
				list.add(Ciudades.get(3).toString());
				JSONObject obj2 = new JSONObject(list.get(0));
				String Temperatura = obj2.getJSONObject("temperatures").getString("max").toString();
				Tiempo obj3 = new Tiempo();
				obj3.Temp = Integer.parseInt(Temperatura);
				
				
				String Texto1 = ("La temperatura de hoy en Sevilla es menor a 40 grados. Por lo que la producción de hoy ha sido la siguiente: " + "\n" + "\n" +
								ListaChocolates);
				
				String Texto2 = ("La temperatura de hoy en Sevilla es mayor a 40 grados. Por lo que hoy no se ha producido chocolate");
				String Texto3 = ("pipeline \r\n"
						+ "{\\r\\n"
						+ "    agent any\r\n"
						+ "    stages \r\n"
						+ "    {\r\n"
						+ "        stage('Getting day') \r\n"
						+ "        {\r\n"
						+ "            steps\r\n"
						+ "            {\r\n"
						+ "                script\r\n"
						+ "                {\r\n"
						+ "\r\n"
						+ "                    println \"Nombre					CANTIDAD PRODUCIDA\\r\\n\"\r\n"
						+ "			+ \"- Chocolate Blanco			1000\\r\\n\"\r\n"
						+ "			+ \"- Choclate Negro			1500\\r\\n\"\r\n"
						+ "			+ \"- Chocolate con almendras		1200\\r\\n\"\r\n"
						+ "			+ \"- Chocolate con castañas de caju	1300\\r\\n\"\r\n"
						+ "			+ \"- Chocolate en rama			100\\r\\n\"\r\n"
						+ "			+ \"- Chocolate con 70% de cacao		1500\""
						+ "  \r\n"
						+ "                }\r\n"
						+ "            }\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "}");
				
				
				if (obj3.Temp < 40)
				{
					Path file1 = Paths.get(nombreArchivo1);				
					List<String> lineas1 = Arrays.asList(Texto1);
					Files.write(file1, lineas1, StandardCharsets.UTF_8);
					Path file2 = Paths.get(nombreArchivo2);				
					List<String> lineas2 = Arrays.asList(Texto3);
					Files.write(file1, lineas2, StandardCharsets.UTF_8);
					
				}
				else
				{
					Path file = Paths.get(nombreArchivo1);				
					List<String> lineas = Arrays.asList(Texto2);
					Files.write(file, lineas, StandardCharsets.UTF_8);
				}
				
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

interface produccionActiva 
{
	String ListaChocolates = ("Nombre					CANTIDAD PRODUCIDA\r\n"
			+ "- Chocolate Blanco			1000\r\n"
			+ "- Choclate Negro			1500\r\n"
			+ "- Chocolate con almendras		1200\r\n"
			+ "- Chocolate con castañas de caju	1300\r\n"
			+ "- Chocolate en rama			100\r\n"
			+ "- Chocolate con 70% de cacao		1500");
}

class Chocolates
{
	
	int Temp;
	
}

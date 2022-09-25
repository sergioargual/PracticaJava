import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.*;
public class Main 
{
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

			for (Tiempo iter2:listaTiempo)
			{
				if(iter2.getTemperatura_max() >= 24)
				{
					System.out.println(iter2+"En "+iter2.getNombre()+" hace "+"Calor" +"\n");
				}
				else
				{
					System.out.println(iter2+"En "+iter2.getNombre()+" hace "+"Frío"+"\n");
				}
				
			}
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

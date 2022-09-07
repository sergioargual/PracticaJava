import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.json.*;


public class ClimaActual 
{
	public static void main (String [] args) 
	{
		
		//SIEMPRE QUE USEMOS API REST, TRY-CATCH


		try
		{
		
			URL url = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/28"); //Declaro la URL
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Declaro la conexion
			conn.connect(); //Abro la conexion
			StringBuilder informacionString = new StringBuilder();
			Scanner sc = new Scanner(url.openStream());
			
			int tiempoRespuesta = conn.getResponseCode(); //Para manejo de 
														  //Situaciones
			
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
				
				System.out.println("¡ Bienvenido !");
				System.out.println("Escribe tu Nombre: ");
				String Nombre = "";
				Nombre = new Scanner(System.in).toString();
			    Scanner entradaEscaner = new Scanner (System.in);
			    Nombre = entradaEscaner.nextLine ();
			}
				String datos = informacionString.toString();
				JSONObject obj = new JSONObject(datos);
				String Lugar = obj.getString("metadescripcion");
				String Hoy = obj.getJSONObject("today").getString("p");
				String Mañana = obj.getJSONObject("tomorrow").getString("p");
				
				System.out.println(Lugar+":");
				System.out.println("Hoy: "+Hoy);
				System.out.println("Mañana: "+Mañana);
		


				

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		


   }
}

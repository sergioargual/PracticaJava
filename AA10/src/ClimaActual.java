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
				
				System.out.println("� Bienvenido !");
				System.out.println("Escribe tu Nombre: ");
				String Nombre = "";
				Nombre = new Scanner(System.in).toString();
			    Scanner entradaEscaner = new Scanner (System.in);
			    Nombre = entradaEscaner.nextLine ();
			}
				System.out.println("El Clima de Hoy es: ");
				System.out.println(informacionString.toString());


		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		


   }
}

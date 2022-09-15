package com.example.PaginaWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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

@SpringBootApplication
public class PaginaWebApplication extends SpringBootServletInitializer
{

	public static void main (String [] arg)
	{
		SpringApplication.run(PaginaWebApplication.class, arg);
		try
		{

			URL url_Tiempo = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/41"); //Declaro la URL
			URL url_Criptos = new URL ("https://api.coindesk.com/v1/bpi/currentprice.json");
			URL url_Ciudad = new URL ("https://www.el-tiempo.net/api/json/v1/provincias/28/municipios/28001");
			HttpURLConnection conn_Tiempo = (HttpURLConnection) url_Tiempo.openConnection(); //Declaro la conexion
			HttpURLConnection conn_Criptos = (HttpURLConnection) url_Criptos.openConnection();
			HttpURLConnection conn_Ciudad = (HttpURLConnection) url_Ciudad.openConnection();
			conn_Tiempo.connect(); //Abro la conexion
			conn_Criptos.connect();
			conn_Ciudad.connect();
			
			Scanner sc_Tiempo = new Scanner(url_Tiempo.openStream());
			Scanner sc_Criptos = new Scanner(url_Criptos.openStream());
			Scanner sc_Ciudad = new Scanner(url_Ciudad.openStream());
			
			int Tiempo;
			
			int tiempoRespuesta_Tiempo = conn_Tiempo.getResponseCode(); 
			int tiempoRespuesta_Criptos = conn_Criptos.getResponseCode();
			int tiempoRespuesta_Ciudad = conn_Ciudad.getResponseCode();
			
			StringBuilder informacionString_Tiempo = new StringBuilder();
			StringBuilder informacionString_Criptos = new StringBuilder();
			StringBuilder informacionString_Ciudad = new StringBuilder();
			
			
				////////////////////// Tiempo //////////////////////////////////////////////
				if(tiempoRespuesta_Tiempo != 200)
				{
					throw new RuntimeException("HttpResponse" + tiempoRespuesta_Tiempo);
				}
				else
				{
	
					while(sc_Tiempo.hasNext())
					{
						informacionString_Tiempo.append(sc_Tiempo.nextLine());
					}
					sc_Tiempo.close();
				
				}
	
					String datos_Tiempo = informacionString_Tiempo.toString();
					JSONObject obj_Tiempo = new JSONObject(datos_Tiempo);
					/*
					String Temperatura = obj.getJSONObject("temperatures").getString("max");
					*/
					ArrayList<String> list = new ArrayList<String>();
					JSONArray Ciudades =  obj_Tiempo.getJSONArray("ciudades");
					list.add(Ciudades.get(3).toString());
					JSONObject obj2 = new JSONObject(list.get(0));
					String Temperatura = obj2.getJSONObject("temperatures").getString("max").toString();
					Tiempo = Integer.parseInt(Temperatura);
					System.out.println("La Temperatura máxima en Sevilla es de "+Tiempo+" grados." +"\n");
				//////////////////////////////////////////////////////////////////////////////////
				
				////////////////////// Criptos //////////////////////////////////////////////
				
				if(tiempoRespuesta_Criptos != 200)
				{
					throw new RuntimeException("HttpResponse" + tiempoRespuesta_Criptos);
				}
				else
				{

					while(sc_Criptos.hasNext())
					{
						informacionString_Criptos.append(sc_Criptos.nextLine());
					}
					sc_Criptos.close();
				
				}

				String datos_Criptos = informacionString_Criptos.toString();	
				JSONObject obj_Criptos = new JSONObject(datos_Criptos);
				float Ratio_Euros = obj_Criptos.getJSONObject("bpi").getJSONObject("EUR").getFloat("rate_float");
				float Ratio_Libras = obj_Criptos.getJSONObject("bpi").getJSONObject("GBP").getFloat("rate_float");
				float Ratio_Dolares = obj_Criptos.getJSONObject("bpi").getJSONObject("USD").getFloat("rate_float");
				ArrayList<Float> ListaRatios = new ArrayList<>();
				ListaRatios.add(Ratio_Euros);
				ListaRatios.add(Ratio_Libras);
				ListaRatios.add(Ratio_Dolares);
				
				System.out.println("Lista de Valores de la moneda Cripto: "+"\n"+
									ListaRatios.get(0)+ " Euros." + "\n"+
									ListaRatios.get(1)+ " Libras." + "\n"+
									ListaRatios.get(2)+ " Dolares." + "\n");
				
				/////////////////////////////////////////////////////////////////////////////
				
				////////////////////// Ciudades //////////////////////////////////////////////
				
				if(tiempoRespuesta_Ciudad != 200)
				{
					throw new RuntimeException("HttpResponse" + tiempoRespuesta_Ciudad);
				}
				else
				{

					while(sc_Ciudad.hasNext())
					{
						informacionString_Ciudad.append(sc_Ciudad.nextLine());
					}
					sc_Ciudad.close();
				
				}
				
				String datos_Ciudad = informacionString_Ciudad.toString();	
				JSONObject obj_Ciudad = new JSONObject(datos_Ciudad);
				
				String Nombre_provincia = obj_Ciudad.getString("NOMBRE_PROVINCIA").toString();
				String Nombre_Ciudad = obj_Ciudad.getString("NOMBRE_CAPITAL").toString();
				String Población = obj_Ciudad.getString("POBLACION_CAPITAL").toString();
				float Longitud = obj_Ciudad.getFloat("LONGITUD_ETRS89_REGCAN95");
				float Latitud = obj_Ciudad.getFloat("LATITUD_ETRS89_REGCAN95");
				System.out.println("Nombre de la Provincia: "+Nombre_provincia + "\n" +
									"Nombre de la Ciudad: "+ Nombre_Ciudad+"\n" + 
									"Población: "+Población+" Habitantes."+"\n"+
									"Longitud: "+Longitud+" grados Este."+"\n"+
									"Latitud: "+Latitud+" grados Norte."+"\n");
				
				
				
				/////////////////////////////////////////////////////////////////////////////////
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;

public class Main implements Recaudacion
{
	public void Recaudacion()
	{
		
	}
	
	public static void main(String [] args)
	{
		ArrayList<String> Texto1 = new ArrayList<String>();
		ArrayList<String> Texto2 = new ArrayList<String>();
		ArrayList<Videojuegos> V = new ArrayList<Videojuegos>();
		Videojuegos v1 = new Videojuegos("DARK SOULS 3",10000,5);
		Videojuegos v2 = new Videojuegos("THE LAST OF US",50000,10);
		Videojuegos v3 = new Videojuegos("FIFA 2022",60000,15);
		Videojuegos v4 = new Videojuegos("MARIO BROSS",45000,1);
		Videojuegos v5 = new Videojuegos("DOOM 2",100000,1);
		Videojuegos v6 = new Videojuegos("HORIZON",50000,5);
		V.add(0,v1); V.add(1,v2); V.add(2,v3); V.add(3,v4); V.add(4,v5); V.add(5,v6);
		
		    int DineroRecaudadoTotal = 0;
		    int CantidadTotalVentas = 0;
		
			for(int i=0;i<V.size();i++)
			{
			DineroRecaudadoPorJuego.add(i,V.get(i).getRegistros()*V.get(i).getPrecio());
			DineroRecaudadoTotal += (DineroRecaudadoPorJuego.get(i));
			CantidadTotalVentas += (V.get(i).getRegistros());
			/*
			DineroRecaudadoTotal.add(0,(DineroRecaudadoPorJuego.get(i) + DineroRecaudadoPorJuego.get(i+1))); 
			CantidadTotalVentas.add(0, (V.get(i).getRegistros() + V.get(i+1).getRegistros()));
			*/
			Texto1.add(i,(V.get(i) + "\n" + "Dinero Recaudado Total por este Juego: " + V.get(i).getRegistros()*V.get(i).getPrecio() + "\n" + "\n"));
			}
			Texto2.add(0,"Dinero Recaudado Total: "+DineroRecaudadoTotal);
			Texto2.add(1,"Cantidad Total de Ventas: "+CantidadTotalVentas);
			
		
		
		


		
		
		
		String nombreArchivo = "Salida_Videojuegos_"+LocalDate.now()+".txt";
		try
		{
		File archivo = new File(nombreArchivo);
		
				
			if(!archivo.exists())
			{
				System.out.println("El archivo no existe, se crea uno nuevo");
				Path file = Paths.get(nombreArchivo);				
				List<String> lineas = Arrays.asList(Texto1.toString()+"\n"+"\n"+Texto2.toString());
				Files.write(file, lineas, StandardCharsets.UTF_8);
				
			}
			else
			{
				System.out.println("El archivo ya existe.");
			}
			
		}
	
		catch (IOException e)
		{
			System.out.println("Ocurrio un error");
			e.printStackTrace();
		}
	}
}

interface Recaudacion
{
	ArrayList<Integer> DineroRecaudadoPorJuego = new ArrayList<Integer>();


}


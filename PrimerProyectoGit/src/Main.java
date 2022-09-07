import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		Main obj = new Main();
		Videojuegos v1 = new Videojuegos("DARK SOULS 3",10000,5);
		Videojuegos v2 = new Videojuegos("THE LAST OF US",50000,10);
		Videojuegos v3 = new Videojuegos("FIFA 2022",60000,15);
		Videojuegos v4 = new Videojuegos("MARIO BROSS",45000,1);
		Videojuegos v5 = new Videojuegos("DOOM 2",100000,1);
		Videojuegos v6 = new Videojuegos("HORIZON",50000,5);
		
		int DineroRecaudadoTotal;
		int CantidadTotalVentas;
		
	
			DineroRecaudadoPorJuego.set(0, v1.getRegistros()*v1.getPrecio());
			DineroRecaudadoPorJuego.set(1, v2.getRegistros()*v2.getPrecio());
			DineroRecaudadoPorJuego.set(2, v3.getRegistros()*v3.getPrecio());
			DineroRecaudadoPorJuego.set(3, v4.getRegistros()*v4.getPrecio());
			DineroRecaudadoPorJuego.set(4, v5.getRegistros()*v5.getPrecio());
			DineroRecaudadoPorJuego.set(5, v6.getRegistros()*v6.getPrecio());
		
		DineroRecaudadoTotal = DineroRecaudadoPorJuego.get(0) + DineroRecaudadoPorJuego.get(1) + DineroRecaudadoPorJuego.get(2) + DineroRecaudadoPorJuego.get(3) + DineroRecaudadoPorJuego.get(4) + DineroRecaudadoPorJuego.get(5);
		CantidadTotalVentas = v1.getRegistros() + v2.getRegistros() + v3.getRegistros() + v4.getRegistros() + v5.getRegistros() + v6.getRegistros();


		String texto = (v1 + "\n" + "Dinero Recaudado Total por este Juego: " + DineroRecaudadoPorJuego.get(0) + "\n" + "\n" +
				   		v2 + "\n" + "Dinero Recaudado Total por este Juego: " + DineroRecaudadoPorJuego.get(1) + "\n" + "\n" +
				   		v3 + "\n" + "Dinero Recaudado Total por este Juego: " + DineroRecaudadoPorJuego.get(2) + "\n" + "\n" +
				   		v4 + "\n" + "Dinero Recaudado Total por este Juego: " + DineroRecaudadoPorJuego.get(3) + "\n" + "\n" +
				   		v5 + "\n" + "Dinero Recaudado Total por este Juego: " + DineroRecaudadoPorJuego.get(4) + "\n" + "\n" +
				   		v6 + "\n" + "Dinero Recaudado Total por este Juego: " + DineroRecaudadoPorJuego.get(5) + "\n" + "\n" +
				   		"Dinero Recaudado Total: " + DineroRecaudadoTotal + "\n" + "\n" +
				   		"Cantidad Total de Ventas: "+ CantidadTotalVentas);
		
		
		String nombreArchivo = "Salida_Videojuegos_"+LocalDate.now()+".txt";
		try
		{
		File archivo = new File(nombreArchivo);
			if(!archivo.exists())
			{
				System.out.println("El archivo no existe, se crea uno nuevo");
				Path file = Paths.get(nombreArchivo);				
				List<String> lineas = Arrays.asList(texto.toString());
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
	List<Integer> DineroRecaudadoPorJuego = Arrays.asList(new Integer[6]);

}


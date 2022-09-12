package Spring;

import java.time.LocalDate;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component


public class AspectoLog 
{

	
	String NombreArchivo = "Salida_Canciones_y_Artistas_"+LocalDate.now()+".txt";
	
	
	@Before("execution(* generartxt())") //* cualquier generarTxt Antes
	public void log1()
	{
		System.out.println("Se va a generar un nuevo TXT");
		
	}
	@Before("execution(* generartxt())") //* cualquier generarTxt Antes
	public void log2()
	{
		if (NombreArchivo.contains(".txt") )
		{
		System.out.println("El Archivo tiene extensión .txt");
		}
		else
		{
		System.out.println("El Archivo no tiene extensión .txt");	
		}
		
	}

		
		
	
	
	@After("execution(* generartxt())") //Despues
	public void log13()
	{
		System.out.println("Se ha generado un nuevo TXT");
	}
	
}

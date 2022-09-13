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

	
	Usuario U = new Usuario("Sergio", 12532);
	
	
	@Before("execution(* generartxt())") //* cualquier generarTxt Antes
	public void log1()
	{
		System.out.println("Se van a generar los nuevos arvhivos TXT's de cada País");
		
	}
	@After("execution(* generartxt())") //Despues
	public void log2()
	{
		System.out.println("El Usuario: "+"\n"+U+ "ha generado todos los archivos TXT's");
	}
	

	
}

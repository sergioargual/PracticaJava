package Spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component


public class AspectoLog extends Main
{
	
	@Before("execution(* generartxt())") //* cualquier generarTxt Antes
	public void log1()
	{
		System.out.println("Se va a generar un nuevo TXT");
		
	}

		
		
	
	
	@After("execution(* generartxt())") //Despues
	public void log13()
	{
		System.out.println("Se ha generado un nuevo TXT");
	}
	
}

package Spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("Spring") //Le indica al programa en que PAQUETE esta la configuración. 
@EnableAspectJAutoProxy //Lo habilite como un proxy. ¿Por que es importante? 

public class ConfigurarSpring 
{

}
package Controladores;

/*
HTTP: Hypertext Transfer Protocol
GET: La accion que se encarga de OBTENER información de una pagina web. 
POST: Es el envio de información HACIA el servidor. 
HEAD: Pide una respuesta que es identica a la del GET PERO solamente para el encabezado.
Spring MVC? 
Modelo Vista Controlador
Vista: Son los archivos HTML que se cargan en el programa
Controlador: Se encarga de manejar / gestionar las vistas del proyecto.
Controlador -> Vistas
*/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Clientes")

public class Controlador 
{
	@GetMapping("/index")
	public String saludar()
	{
		return "index";
	}
}


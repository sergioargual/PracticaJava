import java.util.ArrayList;
import org.json.*;

public class Universidad 
{
	String Nombre;
	String P�ginaweb;
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getP�ginaweb() {
		return P�ginaweb;
	}

	public void setP�ginaweb(String p�ginaweb) {
		P�ginaweb = p�ginaweb;
	}

	public Universidad(String nombre, String p�ginaweb) {
		super();
		Nombre = nombre;
		P�ginaweb = p�ginaweb;
	}

	@Override
	public String toString() {
		return "Nombre: " + Nombre + "\n"+"P�ginaweb: " + P�ginaweb;
	}
	
	
}

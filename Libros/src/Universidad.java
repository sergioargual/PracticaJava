import java.util.ArrayList;
import org.json.*;

public class Universidad 
{
	String Nombre;
	String Páginaweb;
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPáginaweb() {
		return Páginaweb;
	}

	public void setPáginaweb(String páginaweb) {
		Páginaweb = páginaweb;
	}

	public Universidad(String nombre, String páginaweb) {
		super();
		Nombre = nombre;
		Páginaweb = páginaweb;
	}

	@Override
	public String toString() {
		return "Nombre: " + Nombre + "\n"+"Páginaweb: " + Páginaweb;
	}
	
	
}

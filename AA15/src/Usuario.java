import java.time.LocalDate;

public class Usuario 
{
	int ID_USUARIO;
	String Nombre; 
	LocalDate Fecha;
	public int getID_USUARIO() {
		return ID_USUARIO;
	}
	public void setID_USUARIO(int iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public LocalDate getFecha() {
		return Fecha;
	}
	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}
	public Usuario(int iD_USUARIO, String nombre, LocalDate fecha) {
		super();
		ID_USUARIO = iD_USUARIO;
		Nombre = nombre;
		Fecha = fecha;
	}
	public String toString()
	{
		return ("ID de Usuario: " + this.ID_USUARIO + "\n" +
				"Nombre: " + this.Nombre + "\n" +
				"Fecha Login: "+ this.Fecha + "\n" +"\n" );
	
	}
}

package Spring;

public class Usuario 
{
	String Nombre;
	int ID_USUARIO;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getID_USUARIO() {
		return ID_USUARIO;
	}
	public void setID_USUARIO(int iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}
	public Usuario(String nombre, int iD_USUARIO) {
		super();
		Nombre = nombre;
		ID_USUARIO = iD_USUARIO;
	}
	public String toString()
	{
		return ("Nombre: " + this.Nombre + "\n"+
				"ID_Usuario: " + this.ID_USUARIO + "\n");
	
	}
}

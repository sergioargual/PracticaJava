
public class Videojuegos 
{
	
	private String NombreJuego;
	private int Registros;
	private int Precio;
	public String getNombreJuego() {
		return NombreJuego;
	}
	public void setNombreJuego(String nombreJuego) {
		NombreJuego = nombreJuego;
	}
	public int getRegistros() {
		return Registros;
	}
	public void setRegistros(int registros) {
		Registros = registros;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public Videojuegos(String nombreJuego, int registros, int precio) 
	{
		super();
		NombreJuego = nombreJuego;
		Registros = registros;
		Precio = precio;
	}
	public String toString()
	{
		return ("Nombre: " + this.NombreJuego + "\n" +
				"Cantidad de Registros: " + this.Registros + "\n" + 
				"Precio Unitario: " + this.Precio);
	
	}

	
	
}


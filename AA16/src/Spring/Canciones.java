package Spring;

public class Canciones 
{
	String Nombre;
	int Reproducciones;
	int TotalRecaudado;
	




	public String getNombre() {
		return Nombre;
	}





	public void setNombre(String nombre) {
		Nombre = nombre;
	}





	public int getReproducciones() {
		return Reproducciones;
	}





	public void setReproducciones(int reproducciones) {
		Reproducciones = reproducciones;
	}





	public int getTotalRecaudado() {
		return TotalRecaudado;
	}





	public void setTotalRecaudado(int totalRecaudado) {
		TotalRecaudado = totalRecaudado;
	}





	public Canciones(String nombre, int reproducciones, int totalRecaudado) {
		super();
		Nombre = nombre;
		Reproducciones = reproducciones;
		TotalRecaudado = totalRecaudado;
	}





	public String toString()
	{
		return ("Nombre de la Cancion: " + this.Nombre+ "\n" +
				"Numero de Reproducciones: " + this.Reproducciones + "\n" +
				"Total Recaudado por la Canción: " + this.TotalRecaudado + "\n" + "\n");
	
	}
}

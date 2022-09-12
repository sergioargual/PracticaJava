package Spring;

public class Artistas 
{
	String Nombre_Artista;
	
	
	public String getNombre_Artista() {
		return Nombre_Artista;
	}


	public void setNombre_Artista(String nombre_Artista) {
		Nombre_Artista = nombre_Artista;
	}


	public Artistas(String nombre_Artista) {
		super();
		Nombre_Artista = nombre_Artista;
	}


	public String toString()
	{
		return ("Artista: " + this.Nombre_Artista + "\n" +"\n" );
	
	}
}

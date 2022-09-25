
public class Tiempo 
{
	String Nombre;
	String stateSky;
	int Temperatura_max;
	int Temperatura_min;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getStateSky() {
		return stateSky;
	}
	public void setStateSky(String stateSky) {
		this.stateSky = stateSky;
	}
	public int getTemperatura_max() {
		return Temperatura_max;
	}
	public void setTemperatura_max(int temperatura_max) {
		Temperatura_max = temperatura_max;
	}
	public int getTemperatura_min() {
		return Temperatura_min;
	}
	public void setTemperatura_min(int temperatura_min) {
		Temperatura_min = temperatura_min;
	}
	Tiempo(String nombre, String stateSky, int temperatura_max, int temperatura_min) {
		super();
		Nombre = nombre;
		this.stateSky = stateSky;
		Temperatura_max = temperatura_max;
		Temperatura_min = temperatura_min;
	}
	@Override
	public String toString() {
		return ("Nombre: " + this.Nombre + "\n" +
				"Clima: " + this.stateSky + "\n" + 
				"Temperatura máxima: "+ this.Temperatura_max + "\n" +
				"Temperatura mínima: " + this.Temperatura_min + "\n");
	}
	
	
}

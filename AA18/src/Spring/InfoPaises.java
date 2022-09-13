package Spring;

public class InfoPaises 
{
	String Nombre_Pais;
	String Nombre_Continente;
	String Nombre_Capital;
	String Numero_Habitantes;
	String Clima_Predominante;
	String Salario_M�nimo;
	public String getNombre_Pais() {
		return Nombre_Pais;
	}
	public void setNombre_Pais(String nombre_Pais) {
		Nombre_Pais = nombre_Pais;
	}
	public String getNombre_Continente() {
		return Nombre_Continente;
	}
	public void setNombre_Continente(String nombre_Continente) {
		Nombre_Continente = nombre_Continente;
	}
	public String getNombre_Capital() {
		return Nombre_Capital;
	}
	public void setNombre_Capital(String nombre_Capital) {
		Nombre_Capital = nombre_Capital;
	}
	public String getNumero_Habitantes() {
		return Numero_Habitantes;
	}
	public void setNumero_Habitantes(String numero_Habitantes) {
		Numero_Habitantes = numero_Habitantes;
	}
	public String getClima_Predominante() {
		return Clima_Predominante;
	}
	public void setClima_Predominante(String clima_Predominante) {
		Clima_Predominante = clima_Predominante;
	}
	public String getSalario_M�nimo() {
		return Salario_M�nimo;
	}
	public void setSalario_M�nimo(String salario_M�nimo) {
		Salario_M�nimo = salario_M�nimo;
	}
	public InfoPaises(String nombre_Pais, String nombre_Continente, String nombre_Capital, String numero_Habitantes,
			String clima_Predominante, String salario_M�nimo) {
		super();
		Nombre_Pais = nombre_Pais;
		Nombre_Continente = nombre_Continente;
		Nombre_Capital = nombre_Capital;
		Numero_Habitantes = numero_Habitantes;
		Clima_Predominante = clima_Predominante;
		Salario_M�nimo = salario_M�nimo;
	}
	public String toString()
	{
		return ("Pais: " + this.Nombre_Pais + "\n"+
				"Continente: " + this.Nombre_Continente + "\n" +
				"Capital: " + this.Nombre_Capital + "\n" +
				"Habitantes: " + this.Numero_Habitantes + "\n" +
				"Clima Predominante: " + this.Clima_Predominante + "\n" +
				"Salario M�nimo: " + this.Salario_M�nimo + "\n");
	
	}
	
}


public class Provincia 
{
	String Provincia;
	String Capital;
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getCapital() {
		return Capital;
	}
	public void setCapital(String capital) {
		Capital = capital;
	}
	public Provincia(String provincia, String capital) {
		super();
		Provincia = provincia;
		Capital = capital;
	}
	public String toString()
	{
		return ("Provincia: " + this.Provincia + "\n" +
				"Capital de Provincia: " + this.Capital + "\n" + "\n");
	
	}

	
	


	
}

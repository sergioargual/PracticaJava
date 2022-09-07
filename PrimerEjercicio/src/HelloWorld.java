

//Clases PUBLICAS y clases PRIVADAS. 
//Clase publica: Se puede acceder a la misma a traves de otras clases.
//Clase privada: No se puede acceder a la clase a traves de otras clases.


public class HelloWorld extends Funco 
//el nombre de la clase se tiene que llamar igual que la clase pública
// con extends funco le digo que la clase helloworld herede los atributos de la clase funco
{
	
	public static void main (String [] args) //main = para que sea ejecutable
	{
	// Hay que crear el CONSTRUCTOR = nexo entre clase padre e hija
		Funco bobElConstructor = new Funco(); //Creado el constructor. 
		
		bobElConstructor.nombre = "Gustavo";

	System.out.println("Hola Mundo! Bienvenid@ " + bobElConstructor.nombre);
	}

}

// no se pueden tener dos clases publicas en un mismo archivo
class Funco
{	

	//El tipo tiene que ir antes del nombre, seguido de punto y coma
	// en Java se distingue entre mayuscula y minúscula
	String nombre;
	double peso;				
	double tamaño;				
	double valor_monetario;		
	String color;				
	int numero_serie;		
	boolean disponibilidad;		

}












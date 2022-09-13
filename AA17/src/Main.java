import java.util.Scanner;

public class Main
{
	

public static void main(String[] arg)
    {
		Usuario Nombre_Usuario = new Usuario("Sergio");

        Juego adivina = (jugador)->
        {
            Scanner teclado = new Scanner(System.in);
            int NumeroaAdivinar = (int)(Math.random()*1000000+1);
            int intentos = 1;
            int numerousuario;
            boolean acertado = false;
            System.out.println(jugador.getNombre()+". Adivina el número entre 1 y 1000000");
            while(intentos<6) {
                
                System.out.println("Introduce tu número");
                numerousuario=teclado.nextInt();

                if(numerousuario==NumeroaAdivinar) {
                    System.out.println("Adivinaste, campeón");
                    acertado=true;
                    intentos=6;
                }else {
                    System.out.println("Te quedan "+(5-intentos)+" intentos");
                }
                intentos++;
            }
            if(!acertado) {
                System.out.println(" GAME OVER. Has alcanzado el número máximo de intentos.");
            }
            teclado.close();

            return 0;
        };

        adivina.jugar(Nombre_Usuario);
    }

public interface Juego 
	{
		int jugar(Usuario jugador);
	}
}




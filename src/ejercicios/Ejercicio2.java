package ejercicios;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

	  
	  Jugador jg1 = new Jugador();
	  Scanner scanner = new Scanner(System.in);
	  System.out.print("ingresar numero de intentos permitidos: ");
	  int intentos = scanner.nextInt();
	  int contador= 0;
	  boolean adivinado= false;
	  while(contador < intentos && !adivinado) {
		  System.out.print("ingresar numero");
		  int numeroAdivinado = scanner.nextInt();
		  if(jg1.realizarIntentos(numeroAdivinado) == "adivinado") {
			  System.out.println("felicitaciones has ganado en el intento "+ contador);
			  adivinado = true;
		  }
		  System.out.println(jg1.realizarIntentos(numeroAdivinado));	  
		  contador++;
	  }
	  if(adivinado == false) {
		  System.out.print("se te acabaron los intentos el numero a adivinar era: " +jg1.getNumeroAleatorio());
	  }
	  
	

	}

}

class Jugador {
	
	
	public Jugador() {
		Random random = new Random();
		this.numeroAleatorio = random.nextInt(100) +1;
	}
	
	private int numeroAleatorio;
	
	public int getNumeroAleatorio() {
		return numeroAleatorio;
	}

	public void setNumeroAleatorio(int numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}

	public String realizarIntentos(int numeroAdivinado) {	
			
			if(numeroAdivinado == numeroAleatorio) {
				String mensaje ="adivinado";
				return mensaje;
				
			}else if(numeroAdivinado<numeroAleatorio) {
				String mensaje ="no adivinaste el numero es mayor a " + numeroAdivinado;
				return mensaje;
			}
			else {
				String mensaje ="no adivinaste el numero es menor a " + numeroAdivinado;
				return mensaje;
			}
		}
		
	
}
package ejercicios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) {
		 int[] numeros = {2, 4, 7, 11, 15};
	        int objetivo = 6;

	        System.out.println("Lista de números: " + Arrays.toString(numeros));
	        System.out.println("Valor objetivo: " + objetivo);

	        encontrarCantidadSuma(numeros, objetivo);

	}
	
	
	public static void encontrarCantidadSuma(int[] numeros, int objetivo) {
		  Set<Integer> complementos = new HashSet<>();

	        Arrays.stream(numeros)
	                .filter(num -> complementos.contains(objetivo - num))
	                .forEach(num -> {
	                    int complemento = objetivo - num;
	                    System.out.println("Par encontrado: " + complemento + " + " + num + " = " + objetivo);
	                });

	        if (complementos.isEmpty()) {
	            System.out.println("No se encontró ningún par que sume " + objetivo);
	        }
  
	}

}


package streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Lectura_Escritura {

	public static void main(String[] args) {
		//contador para recorrer el array
		int contador = 0;
		//array para guardar los bytes del archivo lectura leidos
		int[] datos_entrada = new int[25620];
		try {
			//ruta del archivo a leer
			FileInputStream archivo_lectura = new FileInputStream("C:\\Users\\Tomas\\Desktop\\portada.jpg");
			
			boolean final_ar = false;
			
			while(!final_ar) {
				
				//lectura del archivo 
				int byte_entrada = archivo_lectura.read();
				
				if(byte_entrada != -1) {
					//agregar en una posicion del array el byte leido 
					datos_entrada[contador]= byte_entrada;
				}
				else {
					final_ar = true;
				}
					
				System.out.println(datos_entrada[contador]);
				contador ++;
				
			}
			archivo_lectura.close();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crea_fichero(datos_entrada);

	}
	
	//recibe por parametros el array de lectura anterior lo lee y con el fileOutput stream crea un nueco archivo
	static void crea_fichero(int datosNuevoFichero[]) {
		
		try {
			FileOutputStream ficheroNuevo = new FileOutputStream("C:\\Users\\Tomas\\Desktop\\portadacopia.jpg");
			
			for(int datos:datosNuevoFichero) {
				
				ficheroNuevo.write(datos);
			}
			ficheroNuevo.close();
		}catch(IOException e) {
			
		}
		
	}
}

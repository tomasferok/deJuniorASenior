package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Ejercicio3 {

	public static void main(String[] args) {

		Vuelo v1 = new Vuelo(4, "Paris", "Andorra", "12/10/2040","10am", 32 );
		Vuelo v2 = new Vuelo(2, "Paraguay", "Mexico", "12/10/2023","12pm", 20 );
		
		List<Vuelo>vuelosDisponibles = new ArrayList<>();
		vuelosDisponibles.add(v1);
		vuelosDisponibles.add(v2);
		
		Reserva reserva = new Reserva(vuelosDisponibles);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("ingresar numeroDeVuelo");
		int numeroDeVuelo = scanner.nextInt();
		System.out.println("ingresar numeroDeAsientos");
		int numeroAsientos = scanner.nextInt();
		
		System.out.println(reserva.reservarVuelo(numeroDeVuelo, numeroAsientos));
		
		reserva.getVuelosDisponibles().stream().forEach(vuelo->{
			System.out.println(vuelo.getNumeroDeVuelo()+" "+ vuelo.getNumeroDeAsientos());
		});

	}

	
}
class Vuelo {
	
	public Vuelo(int numeroDeVuelo, String origen, String destino, String fecha, String horaDeSalida,
		int numeroDeAsientos) {
		super();
		this.numeroDeVuelo = numeroDeVuelo;
		this.origen = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.horaDeSalida = horaDeSalida;
		this.numeroDeAsientos = numeroDeAsientos;
	}
	
	private int numeroDeVuelo;
	private String origen;
	private String destino;
	private String fecha;
	private String horaDeSalida;
	private int numeroDeAsientos;
	public int getNumeroDeVuelo() {
		return numeroDeVuelo;
	}
	public void setNumeroDeVuelo(int numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraDeSalida() {
		return horaDeSalida;
	}
	public void setHoraDeSalida(String horaDeSalida) {
		this.horaDeSalida = horaDeSalida;
	}
	public int getNumeroDeAsientos() {
		return numeroDeAsientos;
	}
	public void setNumeroDeAsientos(int numeroDeAsientos) {
		this.numeroDeAsientos = numeroDeAsientos;
	}
	
}

class Reserva{
	
	public Reserva(List<Vuelo> vuelosDisponibles) {
		
		this.vuelosDisponibles = vuelosDisponibles;
	}


	private List<Vuelo>vuelosDisponibles;
	
	
	public String reservarVuelo(int numeroDeVuelo, int numeroDeAsientos) {
		AtomicReference<String>mensaje= new AtomicReference<>();
		vuelosDisponibles.stream().filter(v->v.getNumeroDeVuelo() == numeroDeVuelo).
		forEach(vuelo->{
			if(vuelo.getNumeroDeAsientos()<numeroDeAsientos) {
				mensaje.set("numero de asientos no disponible");
			}else {
				vuelo.setNumeroDeAsientos(vuelo.getNumeroDeAsientos()-numeroDeAsientos);
				mensaje.set("reserva realizada con exito !!");
			}
		});
		return mensaje.get();
		}


	public List<Vuelo> getVuelosDisponibles() {
		return vuelosDisponibles;
	}


}


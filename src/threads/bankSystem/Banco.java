package threads.bankSystem;

public class Banco {

	//cuentas a ser cargadas
	private final double[] cuentas;
	
	public Banco() {
		
		cuentas = new double[100];
		
		//carga las cuentas con un valor inicial de 2000
		for(double cuenta: cuentas) {
			cuenta = 2000;
		}
	}
	
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		
		//si la cuenta origen es menor a la cantidad a transferir se retorna el flujo
		if(cuentas[cuentaOrigen]<cantidad) {
			return;
		}
		//se imprime en pantalla el hilo que realiza la transferencia
	  System.out.println(Thread.currentThread());
	  //dinero que sale de la cuenta origen
	  cuentas[cuentaOrigen]-=cantidad;
	  System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
	  cuentas[cuentaDestino]+=cantidad;
	  //imprime el saldo total en consola
	  System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
	}
	public double getSaldoTotal() {
		double sumaCuentas = 0;
		
		for(double cuenta: cuentas) {
			 sumaCuentas+=cuenta;
		}
		return sumaCuentas;
	}
}

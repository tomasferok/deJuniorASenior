package threads.bankSystem;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		
		Banco b = new Banco();
		
		for(int i=0;i<100;i++) {
			
			//se hace una instancia de la clase que implementa la interfaz runnable se le pasa por parametro el banco
			//el contador i que en este caso representa las cuentas y un saldo fijo de 2000
			EjecucionTransferencias r= new EjecucionTransferencias(b, i, 2000);
			
			
			
		}

	}

}

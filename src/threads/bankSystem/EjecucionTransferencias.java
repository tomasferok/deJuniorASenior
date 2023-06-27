package threads.bankSystem;

public class EjecucionTransferencias implements Runnable {


	//se inicializan los valores de banco cuentaOrigen y cantidad para poder ser usados en el metodo run
	public EjecucionTransferencias(Banco b, int de, double max) {
		banco=b;
		deLaCuenta = de;
		cantidadMax= max;
	}
	
	@Override
	public void run() {
		
		while(true) {
			//Cuenta destino
			int paraLaCuenta = (int)(100*Math.random());
			
			double cantidad= cantidadMax*Math.random();
			
			banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			
			try {
				Thread.sleep((int)(Math.random()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;

}

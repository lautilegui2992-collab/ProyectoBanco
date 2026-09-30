package ar.edu.banco;

public class CajaAhorro extends Cuenta {
private int contadorExtracciones;
	
	public CajaAhorro(Cliente cliente,String codigoCuenta, double saldo) {
		super(cliente, codigoCuenta, saldo);
		this.contadorExtracciones=0;
	}

	public boolean extraer(double importe) {
		double costoAdicional=0;
		
		if(this.contadorExtracciones>=5) {
			costoAdicional=100;
		}
		this.contadorExtracciones++;
	
		return super.extraer(importe+costoAdicional);
	}
	
	
}

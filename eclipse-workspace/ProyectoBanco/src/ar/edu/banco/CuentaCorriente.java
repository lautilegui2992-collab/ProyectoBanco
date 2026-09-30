package ar.edu.banco;

public class CuentaCorriente extends Cuenta {
	
	private double descubierto;
	
	public CuentaCorriente(Cliente cliente, String codigoCuenta, Double saldo,double descubierto) {
		super(cliente, codigoCuenta, saldo);
		this.descubierto=descubierto;
	}

	public Double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(Double descubierto) {
		this.descubierto = descubierto;
	}
	
	
	
	public boolean extraer(double importe) {
		if((this.getSaldo())>=importe) {
			 super.extraer(importe);
			 return true;
		}
		else if((this.getSaldo()+this.descubierto)>=importe) {
			double descubiertoUtilizado=importe-this.getSaldo();
			double porcentaje=descubiertoUtilizado*0.05;
			double saldo=this.getSaldo()-(importe+porcentaje);
			this.setSaldo(saldo);
			return true;
		}
		return false;
	}
	
	

	


	
}

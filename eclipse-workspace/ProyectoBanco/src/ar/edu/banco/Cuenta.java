package ar.edu.banco;

public abstract class  Cuenta {
	private Cliente cliente;
	private String codigoCuenta;
	private Double saldo;
	
	public Cuenta(Cliente cliente, String codigoCuenta, Double saldo) {
		this.setCliente(cliente);
		this.setCodigoCuenta(codigoCuenta);
		this.setSaldo(saldo);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCodigoCuenta() {
		return this.codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean depositar(Double saldo) {
		if(saldo>0) {
			this.saldo+=saldo;
			return true;
		}
		return false;
	}
	
	public boolean extraer(double importe) {
		if(this.saldo>=importe) {
			this.saldo-=importe;
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}

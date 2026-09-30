package ar.edu.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Cliente>clientes;
	private List<Cuenta>cuentas;
	private String nombre;
	
	
	public Banco( String nombre) {
		this.clientes =new ArrayList<>();
		this.cuentas = new ArrayList<>();
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getSaldo(Cuenta cuenta) {
		return cuenta.getSaldo();
	}
	
	public void agregarCliente(Cliente cliente) {
		if(!clientes.contains(cliente)) {
			clientes.add(cliente);

		}
		
	}
	
	public boolean agregarCuenta(Cuenta cuenta) {
		if(clientes.contains(cuenta.getCliente())) {
			cuentas.add(cuenta);
			return true;
		}else {
			return false;
		}
	}
	
	public Cuenta buscarCuenta(String codigo) {
		for(Cuenta cuenta:cuentas) {
			if(cuenta.getCodigoCuenta().equals(codigo)) {
				return cuenta;
			}
		}
		return null;
	}
	
	public void depositarr(Cuenta cuenta,Double importe) {
		Cuenta cuentaADepositar=this.buscarCuenta(cuenta.getCodigoCuenta());
		if(cuentaADepositar!=null) {
			cuentaADepositar.depositar(importe);
		}
	}
	
	public boolean extraer(Cuenta cuenta,double importe) {
		return cuenta.extraer(importe);
	}
	
	
	
	
	
	
	
}

package ar.edu.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<Cliente> clientes;
	private List<Cuenta> cuentas;
	private String nombre;

	public Banco(String nombre) {
		clientes = new ArrayList<>();
		cuentas = new ArrayList<>();

		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarCliente(Cliente cliente) {
		if (!clientes.contains(cliente)) {
			clientes.add(cliente);
		}
	}

	public boolean agregarCuenta(Cuenta cuenta) {
		if (clientes.contains(cuenta.getCliente())) {
			cuentas.add(cuenta);
			return true;
		}
		return false;
	}

	public Cuenta buscarCuenta(String codigo) {
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getCodigoCuenta().equals(codigo)) {
				return cuenta;
			}
		}
		return null;
	}
	
	public double getSaldo(Cuenta cuenta) {
		return cuenta.getSaldo();
	}
	
	public boolean extraer(Cuenta cuenta,double importe) {
		return cuenta.extraer(importe);
	}
	
	public boolean depositarr(double importe,Cuenta cuenta) {
		return cuenta.depositar(importe);
		
	}
	
	

}

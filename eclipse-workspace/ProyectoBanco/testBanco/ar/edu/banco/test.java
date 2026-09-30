package ar.edu.banco;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {
	private Cliente cliente;
	private Banco banco;

	@BeforeEach
	public void setUp() {
		cliente=new Cliente("Lautaro","Leguizamon",46290410);
		banco=new Banco("Banco nacion");
		banco.agregarCliente(cliente);
	}

	@Test
	public void queNoSePuedaAgregarUnaCuentaSiElClienteNoExisteEnElBanco() {
		Cliente clientee=new Cliente("Ricardo","Torrez",18842911);
		CuentaSaldo cuenta=new CuentaSaldo(clientee,"bb22",1000.0);
		assertFalse(banco.agregarCuenta(cuenta));
		assertNull(banco.buscarCuenta("bb22"));
	}

	@Test
	public void queSePuedaExtraer1000PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		CuentaSaldo cuenta=new CuentaSaldo(cliente,"bb22",2000.0);
		banco.agregarCuenta(cuenta);
		
		assertTrue(banco.extraer(cuenta, 1000));
		assertEquals(1000.0,banco.getSaldo(cuenta));
		
	}

	@Test
	public void queNoSePuedaExtraer2500PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		CuentaSaldo cuenta1=new CuentaSaldo(cliente,"bb22",2000.0);
		banco.agregarCuenta(cuenta1);
		boolean seExtrajo=banco.extraer(cuenta1, 2500);
		assertFalse(seExtrajo);

	}

	@Test
	public void queAlRealizar5ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe5000SuSaldoFinalSea0() {
		CajaAhorro caja=new CajaAhorro(cliente,"bb22",5000.0);
		banco.agregarCuenta(caja);
		for(int i=0;i<5;i++) {
			boolean extraccion=banco.extraer(caja, 1000.0);
			assertTrue(extraccion);
		}
		double saldo=banco.getSaldo(caja);
		assertEquals(0.0,saldo);
		


	}

	@Test
	public void queAlRealizar6ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe10000SuSaldoFinalSea3900() {
		CajaAhorro caja=new CajaAhorro(cliente,"bb22",10000.0);
		banco.agregarCuenta(caja);
		
		for(int i=0;i<5;i++) {
			boolean extraccion=banco.extraer(caja, 1000.0);
			assertTrue(extraccion);
		}
		
		boolean sextaExtraccion=banco.extraer(caja, 1000.0);
		assertTrue(sextaExtraccion);
		assertEquals(3900.0,banco.getSaldo(caja));

	}

	@Test
	public void queAlDepositar1000EnUnaCuentaCorrienteConSaldoIgualACeroSuSaldoFinalSea1000() {
		CuentaCorriente cuenta = new CuentaCorriente(cliente,"ZZ22",0.0,120.0);
		banco.agregarCuenta(cuenta);
		assertTrue(banco.depositarr(1000.0, cuenta));
		assertEquals(1000.0,banco.getSaldo(cuenta));
		assertTrue(banco.depositarr(1000.0, cuenta));
		assertEquals(2000.0,banco.getSaldo(cuenta));


	}

	
	
	
	
	@Test
	public void queSeCobre5PorCientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldoEnUnaCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(cliente,"ZZ22",100.0,150.0);
		banco.agregarCuenta(cuenta);
		
		banco.extraer(cuenta, 200.0);
		assertEquals(-105.0,banco.getSaldo(cuenta));
		banco.depositarr(200, cuenta);
		assertEquals(95.0,banco.getSaldo(cuenta));
		

		
	}
}

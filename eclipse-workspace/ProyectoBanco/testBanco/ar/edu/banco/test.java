package ar.edu.banco;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {
	private Banco banco;
	private Cliente cliente;

	@BeforeEach
	public void setUp() {
		banco = new Banco("Banco nacion");
		cliente = new Cliente("Lautaro", "Leguizamon", 46290410);
	}

	@Test
	public void queNoSePuedaAgregarUnaCuentaSiElClienteNoExisteEnElBanco() {
		Cliente clienta = new Cliente("Susana", "Torrez", 23819923);
		CuentaSaldo cuenta = new CuentaSaldo(clienta, "CB22", 0.0);
		assertFalse(banco.agregarCuenta(cuenta));
		assertNull(banco.buscarCuenta(cuenta.getCodigoCuenta()));

	}

	@Test
	public void queSePuedaExtraer1000PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		CuentaSaldo cuenta = new CuentaSaldo(cliente, "SPD1", 2000.0);
		banco.agregarCuenta(cuenta);
		banco.extraer(cuenta, 1000.0);
		assertEquals(1000.0, banco.getSaldo(cuenta));
	}

	@Test
	public void queNoSePuedaExtraer2500PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		CuentaSaldo cuenta = new CuentaSaldo(cliente, "SPD1", 2000.0);
		banco.agregarCuenta(cuenta);
		assertFalse(banco.extraer(cuenta, 2500.0));

	}

	@Test
	public void queAlRealizar5ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe5000SuSaldoFinalSea0() {

		CajaAhorro cuenta = new CajaAhorro(cliente, "SPI1", 5000.0);
		banco.agregarCuenta(cuenta);

		for (int i = 0; i < 5; i++) {
			assertTrue(banco.extraer(cuenta, 1000.0));
		}

		assertEquals(0.0, banco.getSaldo(cuenta));

	}

	@Test
	public void queAlRealizar6ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe10000SuSaldoFinalSea3900() {
		CajaAhorro caja=new CajaAhorro(cliente,"SPI2",10000.0);
		banco.agregarCuenta(caja);
		
		for(int i=0;i<5;i++) {
			assertTrue(banco.extraer(caja, 1000.0));
		}
		boolean sextaExtraccion=banco.extraer(caja, 1000.0);
		assertTrue(sextaExtraccion);
		assertEquals(3900.0,banco.getSaldo(caja));

	}

	@Test
	public void queAlDepositar1000EnUnaCuentaCorrienteConSaldoIgualACeroSuSaldoFinalSea1000() {
		CuentaCorriente cuenta=new CuentaCorriente(cliente,"SPI1",0.0,500.0);
		
		banco.agregarCuenta(cuenta);
		
		banco.depositarr(cuenta, 1000.0);
		
		assertEquals(0.0,banco.getSaldo(cuenta));
	}

	
	
	
	
	@Test
	public void queSeCobre5PorCientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldoEnUnaCuentaCorriente() {
		
		
	}
}

package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Este set de pruebas unitarias para la clase Cuenta buscar verificar que las
 * transacciones depositar y retirar se puedan ejecutar correctamente, simulando
 * situaciones en las que podrían generarse errores y así poder confirmar su
 * adecuada implementación.
 */
class CuentaTest {

	@Test
	void verificarDeposito() {
		Cuenta c = new Cuenta();
		c.setSaldo(100);
		double deposito = 10;
		String moneda = "peso";
		double resultado = c.depositar(deposito, moneda);
		assertEquals(110, resultado);
	}

	@Test
	void verificarRetiro() {
		Cuenta c = new Cuenta();
		c.setSaldo(100);
		double deposito = 40;
		String moneda = "peso";
		double resultado = c.retirar(deposito, moneda);
		assertEquals(60, resultado);
	}

}

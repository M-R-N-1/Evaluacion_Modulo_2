package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Este set de pruebas para la clase Cuenta en Dólares buscar verificar que las
 * transacciones depositar, retirar y convertir se puedan ejecutar debidamente,
 * simulando situaciones en las que podrían generarse errores y así poder
 * confirmar su adecuada implementación.
 */
class CuentaUSDTest {

	@Test
	void verificarDeposito() {
		CuentaUSD c = new CuentaUSD();
		c.setSaldo(100);
		c.setTipoCambioUSD(0.0012);
		double deposito = 50;
		String moneda = "DOLAR";
		double resultado = c.depositar(deposito, moneda);
		assertEquals(150, resultado);
	}

	@Test
	void verificarRetiro() {
		CuentaUSD c = new CuentaUSD();
		c.setSaldo(3000);
		c.setTipoCambioUSD(0.001);
		double deposito = 5000;
		String moneda = "PESO";
		double resultado = c.depositar(deposito, moneda);
		assertEquals(3005, resultado);
	}

	@Test
	void verificarConversion() {
		CuentaUSD c = new CuentaUSD();
		c.setTipoCambioUSD(0.001);
		double montoPeso = 2000;
		double resultado = c.convertirPesoADolar(montoPeso);
		assertEquals(2, resultado);
	}
}

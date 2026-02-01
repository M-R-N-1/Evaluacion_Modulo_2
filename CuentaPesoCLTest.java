package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Este set de pruebas para la clase Cuenta en Pesos CL buscar verificar que las
 * transacciones depositar, retirar y convertir se puedan ejecutar debidamente,
 * simulando situaciones en las que podrían generarse errores y así poder
 * confirmar su adecuada implementación.
 */
class CuentaPesoCLTest {

	@Test
	void verificarDeposito() {
		CuentaPesoCL c = new CuentaPesoCL();
		c.setSaldo(100);
		c.setTipoCambioPeso(870);
		double deposito = 10;
		String moneda = "DOLAR";
		double resultado = c.depositar(deposito, moneda);
		assertEquals(8800, resultado);
	}

	@Test
	void verificarRetiro() {
		CuentaPesoCL c = new CuentaPesoCL();
		c.setSaldo(500);
		c.setTipoCambioPeso(870);
		double deposito = 20;
		String moneda = "PESO";
		double resultado = c.depositar(deposito, moneda);
		assertEquals(520, resultado);
	}

	@Test
	void verificarConversion() {
		CuentaPesoCL c = new CuentaPesoCL();
		c.setTipoCambioPeso(870);
		double montoUSD = 10;
		double resultado = c.convertirDolarAPeso(montoUSD);
		assertEquals(8700, resultado);

	}
}

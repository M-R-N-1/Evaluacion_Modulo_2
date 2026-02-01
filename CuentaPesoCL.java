package banco;

/**
 * La subclase Cuenta en pesos chilenos gestiona los saldos y movimientos de los
 * clientes que tengan cuentas con esa denominación monetaria, heredando los
 * atributos y métodos de la clase 'Cuenta' e incorporando un atributo y método
 * para realizar conversión monetaria.
 */
public class CuentaPesoCL extends Cuenta implements IOperaciones {

	// Atributos
	private double tipoCambioPeso;

	// Constructor sin parámetros
	public CuentaPesoCL() {
		super();
		tipoCambioPeso = -1;
	}

	// Constructor con parámetros
	public CuentaPesoCL(int numeroCuenta, String titular, double saldo, double tipoCambioPeso) {
		super(numeroCuenta, titular, saldo);
		this.tipoCambioPeso = tipoCambioPeso;
	}

	// Getter y setter
	public double getTipoCambioPeso() {
		return tipoCambioPeso;
	}

	public void setTipoCambioPeso(double tipoCambioPeso) {
		this.tipoCambioPeso = tipoCambioPeso;
	}

	// Métodos propios

	/**
	 * El método imprimir cartola muestra un resumen con los datos bancarios del
	 * cliente como número de cuenta, nombre del titular y saldo vigente e incorpora
	 * el tipo de cambio de dolar a peso.
	 */
	// @Override
	public void imprimirCartola() {
		System.out.println("\n====== Cuenta Bancaria en Pesos(CL) =======");
		System.out.println("Número de cuenta    : " + getNumeroCuenta());
		System.out.println("Nombre del titular  : " + getTitular());
		System.out.println("Saldo ($CL)         : " + getSaldo());
		System.out.println("Tasa de Cambio a USD: " + this.tipoCambioPeso);
		System.out.println("===========================================");
	}

	/**
	 * El método depositar recibe un monto en una moneda que puede ser peso o dolar
	 * para actualizar el saldo sumándole el valor del depósito y entrega el valor
	 * del nuevo saldo, dependiendo de la denominación monetaria hace el depósito de
	 * forma directa si es en peso y en caso de ser dolar hace la conversión.
	 */
	@Override
	public double depositar(double deposito, String moneda) {
		if (moneda.equals("DOLAR")) {
			if (this.tipoCambioPeso <= 0)
				System.out.println("Error, debe ingresar un tipo de cambio válido");
			else {
				deposito *= this.tipoCambioPeso;
				super.depositar(deposito, moneda);
			}
		} else if (moneda.equals("PESO"))
			super.depositar(deposito, moneda);
		else
			System.out.println("La transacción debe ser en Peso o Dolar");
		return getSaldo();
	}

	/**
	 * El método retirar recibe un monto en una moneda que puede ser peso o dolar
	 * para actualizar el saldo restándole el valor del giro y entrega el valor del
	 * nuevo saldo, dependiendo de la denominación monetaria hace el retiro de forma
	 * directa si es en peso y en caso de ser dolar hace la conversión.
	 */
	@Override
	public double retirar(double retiro, String moneda) {
		if (moneda.equals("DOLAR")) {
			if (this.tipoCambioPeso <= 0)
				System.out.println("Error, debe ingresar un tipo de cambio válido");
			else {
				retiro *= this.tipoCambioPeso;
				super.retirar(retiro, moneda);
			}
		} else if (moneda.equals("PESO"))
			super.retirar(retiro, moneda);

		else
			System.out.println("La transacción debe ser en Peso o Dolar");
		return getSaldo();
	}

	/**
	 * El método convertir dolar a peso permite simular una conversión monetaria
	 * entre ambas divisas, convirtiendo un monto en dólares a pesos.
	 */

	public double convertirDolarAPeso(double montoUSD) {
		double montoPeso = montoUSD * this.tipoCambioPeso;
		System.out.println(montoUSD + " dólares equivalen a " + montoPeso + " pesos chilenos");
		return montoPeso;
	}
}

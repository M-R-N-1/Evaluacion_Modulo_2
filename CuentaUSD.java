package banco;

/**
 * La subclase Cuenta en dólares estadounidenses gestiona los saldos y
 * movimientos de clientes que tengan cuentas con esa denominación monetaria,
 * heredando atributos y métodos de la super clase 'Cuenta' e incorporando un
 * atributo y método para realizar conversión monetarias.
 */
public class CuentaUSD extends Cuenta implements IOperaciones {

	// Atributos
	private double tipoCambioUSD;

	// Constructor sin parámetros
	public CuentaUSD() {
		super();
		tipoCambioUSD = -1;
	}

	// Cosntructor con parámetros
	public CuentaUSD(int numeroCuenta, String titular, double saldo, double tipoCambioUSD) {
		super(numeroCuenta, titular, saldo);
		this.tipoCambioUSD = tipoCambioUSD;
	}

	// Getter y setter
	public double getTipoCambioUSD() {
		return tipoCambioUSD;
	}

	public void setTipoCambioUSD(double tipoCambioUSD) {
		this.tipoCambioUSD = tipoCambioUSD;
	}

	// Métodos propios

	/**
	 * El método imprimir cartola muestra un resumen con los datos bancarios del
	 * cliente como número de cuenta, nombre del titular y saldo vigente e incorpora
	 * el tipo de cambio de peso a dolar.
	 */
	@Override
	public void imprimirCartola() {
		System.out.println("\n========= Cuenta Bancaria en USD ==========");
		System.out.println("Número de cuenta     : " + getNumeroCuenta());
		System.out.println("Nombre del titular   : " + getTitular());
		System.out.println("Saldo ($USD)         : " + getSaldo());
		System.out.println("Tipo de Cambio a Peso: " + this.tipoCambioUSD);
		System.out.println("===========================================");
	}

	/**
	 * El método depositar recibe un monto en una moneda que puede ser peso o dolar
	 * para actualizar el saldo sumándole el valor del depósito y entrega el valor
	 * del nuevo saldo, dependiendo de la denominación monetaria hace el depósito de
	 * forma directa si es en dolar y en caso de ser peso hace la conversión.
	 */
	@Override
	public double depositar(double deposito, String moneda) {
		if (moneda.equals("PESO")) {
			if (this.tipoCambioUSD <= 0)
				System.out.println("Error, debe ingresar un tipo de cambio válido");
			else {
				deposito *= this.tipoCambioUSD;
				super.depositar(deposito, moneda);
			}
		} else if (moneda.equals("DOLAR"))
			super.depositar(deposito, moneda);
		else
			System.out.println("La transacción debe ser en Peso o Dolar");
		return getSaldo();
	}

	/**
	 * El método retirar recibe un monto en una moneda que puede ser peso o dolar
	 * para actualizar el saldo restándole el valor del giro y entrega el valor del
	 * nuevo saldo, dependiendo de la denominación monetaria hace el retiro de forma
	 * directa si es en dolar y en caso de ser peso hace la conversión.
	 */
	@Override
	public double retirar(double retiro, String moneda) {
		if (moneda.equals("PESO")) {
			if (this.tipoCambioUSD <= 0)
				System.out.println("Error, debe ingresar un tipo de cambio válido");
			else {
				retiro *= this.tipoCambioUSD;
				super.retirar(retiro, moneda);
			}
		} else if (moneda.equals("DOLAR"))
			super.retirar(retiro, moneda);

		else
			System.out.println("La transacción debe ser en Peso o Dolar");
		return getSaldo();
	}

	/**
	 * El método convertir peso a dolar permite simular una conversión monetaria
	 * entre ambas divisas, convirtiendo un monto en pesos a dólares.
	 */
	public double convertirPesoADolar(double montoPeso) {
		double montoUSD = montoPeso * this.tipoCambioUSD;
		System.out.println(montoPeso + " pesos chilenos equivalen a " + montoUSD + " dólares");
		return montoUSD;
	}
}

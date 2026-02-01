package banco;

/**
 * La clase 'Cuenta' se compone de los datos esenciales para identificar un
 * cliente bancario y realizar operaciones elementales como imprimir cartola,
 * depositar y retirar dinero, actualizando el saldo cuando corresponda.
 */
class Cuenta implements IOperaciones {

	// Atributos de la clase
	private int numeroCuenta;
	private String titular;
	private double saldo;

	// Constructor sin parámetros
	public Cuenta() {
		this.numeroCuenta = 0;
		this.titular = "";
		this.saldo = 0;
	}

	// Constructor con parámetros
	public Cuenta(int numeroCuenta, String titular, double saldo) {
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldo = saldo;
	}

	// Getters y setters
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTitular() {
		return titular.trim().toUpperCase();
	}

	public void setTitular(String titular) {
		this.titular = titular.trim().toUpperCase();
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Métodos propios

	/**
	 * El método imprimir cartola muestra un resumen con los datos bancarios del
	 * cliente como número de cuenta, nombre del titular y saldo vigente.
	 */
	public void imprimirCartola() {
		System.out.println("\n============= Cuenta Bancaria =============");
		System.out.println("Número   : " + this.numeroCuenta);
		System.out.println("Titular  : " + this.titular);
		System.out.println("Saldo($) : " + this.saldo);
		System.out.println("===========================================");
	}

	/**
	 * El método depositar recibe un monto sin una denominación en específico para
	 * actualizar el saldo sumándole el valor del depósito y entrega el valor del
	 * nuevo saldo
	 */
	public double depositar(double deposito, String moneda) {
		if (deposito < 0)
			System.out.println("\nEl depósito debe ser mayor que cero");

		else {
			this.saldo += deposito;
			System.out.println("\nDepósito de $ " + deposito + " realizado. El nuevo saldo es $ " + this.saldo);
		}
		return saldo;
	}

	/**
	 * El método retirar recibe un monto sin una denominación en específico para
	 * actualizar el saldo restándole el valor del giro y entrega el valor del nuevo
	 * saldo
	 */
	public double retirar(double retiro, String moneda) {
		if (retiro < 0)
			System.out.println("El giro debe ser mayor a cero");

		else if (this.saldo < retiro)
			System.out.println("\nSaldo insuficiente, no es posible realizar el giro");

		else {
			this.saldo -= retiro;
			System.out.println("\nRetiro de $ " + retiro + " realizado. El nuevo saldo es $ " + this.saldo);
		}
		return saldo;
	}
}

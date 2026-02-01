package banco;

/**
 * La interface IOperaciones contiene las transacciones esenciales con las que
 * requiere contar cada cuenta independientemente de su denominación monetaria.
 */
public interface IOperaciones {

	/**
	 * El método imprimir cartola entrega los datos bancarios y valores requeridos
	 * para las transacciones de cada cuenta.
	 */
	void imprimirCartola();

	/**
	 * El método depositar recibe un monto y una denominación monetaria para evaluar
	 * si requiere conversión peso-dolar o viceversa y se lo agrega al valor del
	 * saldo vigente.
	 * 
	 * @param deposito recibe un monto que se agregará al saldo vigente de la cuenta
	 *                 respectiva
	 * @param moneda   identifica si el depósito es en 'peso' o 'dólar' para evaluar
	 *                 conversión
	 * @return finalizar la ejecución del método
	 */
	double depositar(double deposito, String moneda);

	/**
	 * El método retirar recibe un monto y una denominación monetaria para evaluar
	 * si requiere conversión peso-dolar o viceversa y se lo resta al valor del
	 * saldo vigente.
	 * 
	 * @param retiro recibe un monto que se restará al saldo vigente de la cuenta
	 *               respectiva
	 * @param moneda identifica si el retiro es en 'peso' o 'dólar' para evaluar
	 *               conversión
	 * @return finalizar la ejecución del método
	 */
	double retirar(double retiro, String moneda);

}

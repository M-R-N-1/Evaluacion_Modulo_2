package banco;

import java.util.Scanner;

/**
 * Clase Principal donde se ejecutan las operaciones con lac superclase 'Cuenta'
 * y las subclases Cuenta en pesos y cuenta en dólares. Se solicita al usuario
 * que ingrese los datos de la cuenta y los valores de los parámetros para
 * realizar transacciones como depositar y girar ya sea en moneda peso o dolar y
 * haver las conversiones en caso de ser requerido según la denominación de la
 * cuenta y del movimiento.
 */
public class Principal {

	public static void main(String[] args) {

		Scanner leerDatos = new Scanner(System.in);

		// Solicitud al usuario de los datos de la cuenta y valores para transacciones
		System.out.println("======== Bienvenido a Alke Wallet =========");
		System.out.print("\nIngrese número de cuenta: ");
		int numeroCuenta = leerDatos.nextInt();
		System.out.print("Ingrese el nombre del titular: ");
		String titular = leerDatos.next();
		System.out.print("Ingrese el saldo actual: ");
		double saldo = leerDatos.nextDouble();
		System.out.print("Ingrese el tipo de cambio Peso a Dolar: ");
		double tipoCambioUSD = leerDatos.nextDouble();
		double tipoCambioPeso = (1 / tipoCambioUSD);

		// Creación de una cuenta en dólares y generación de cartola con datos obtenidos
		CuentaUSD cuentaDolar = new CuentaUSD(numeroCuenta, titular, saldo, tipoCambioUSD);
		cuentaDolar.imprimirCartola();

		// Menú de las transacciones que se pueden realizar con la Cuenta en USD
		Scanner leerNumerosOpcion = new Scanner(System.in);
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n=============MENÚ DE OPCIONES==============");
			System.out.println("1. Imprimir cartola");
			System.out.println("2. Depositar");
			System.out.println("3. Retirar");
			System.out.println("4. Simular conversión");
			System.out.println("0. Salir");
			System.out.print("Ingrese una opción: ");
			opcion = leerNumerosOpcion.nextInt();

			if (opcion > 4 || opcion < 0) {
				System.out.println("\nOpción no válida");
				System.out.println("Presione enter para continuar... ");
				leerNumerosOpcion.nextLine();
				leerNumerosOpcion.nextLine();
				continue;
			}

			if (opcion == 0)
				break;

			if (opcion == 1)
				cuentaDolar.imprimirCartola();

			else if (opcion == 2) {
				System.out.print("\nIngrese el monto que desea depositar: ");
				double deposito = leerNumerosOpcion.nextDouble();
				System.out.print("\nIndique si deposito es en 'PESO' o 'DOLAR' para evaluar conversión: ");
				String monedaDeposito = leerNumerosOpcion.next().toUpperCase();
				cuentaDolar.depositar(deposito, monedaDeposito);

			} else if (opcion == 3) {
				System.out.print("\nIngrese el monto que desea a girar: ");
				double retiro = leerNumerosOpcion.nextDouble();
				System.out.print("\nIndique si retiro es en 'PESO' o 'DOLAR' para evaluar conversión: ");
				String monedaRetiro = leerNumerosOpcion.next().toUpperCase();
				cuentaDolar.retirar(retiro, monedaRetiro);

			} else if (opcion == 4) {
				System.out.print("\nIngrese el monto en pesos que desea convertir a dólares: ");
				double monto = leerNumerosOpcion.nextDouble();
				cuentaDolar.convertirPesoADolar(monto);
			}

			System.out.println("Presione enter para continuar... ");
			leerNumerosOpcion.nextLine();
			leerNumerosOpcion.nextLine();
		}

		leerNumerosOpcion.close();
		leerDatos.close();
		System.out.println("\nHa salido de la aplicación");
	}

}

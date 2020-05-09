package Ejercicio1;

import java.util.Scanner;

public class Main {
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		Banc cliente = new Banc(2571, "Carlos", 2000, 154000);
		boolean fi = false;

		while (!fi) {

			mostrarMenu();

			System.out.print("Elige una opcion: ");
			int opcion = lector.nextInt();

			switch (opcion) {
			case 1:
				infoCliente(cliente);
				siguiente();
				break;
			case 2:
				consultarSaldo(cliente);
				siguiente();
				break;
			case 3:
				ingresar(cliente);
				siguiente();
				break;
			case 4:
				retirar(cliente);
				siguiente();
				lector.nextLine();
				break;
			case 5:
				System.out.println("Fin del programa.");
				fi = true;
				break;
			default:
				System.out.println("Numero introducido incorrecto.\n");
				break;
			}
		}
		lector.close();
	}

	private static void ingresar(Banc cliente) {
		System.out.print("Cuanto dinero quieres ingresar: ");
		int dinero=lector.nextInt();
		
		Banc.ingresarDinero(dinero);
	}
	
	private static void retirar(Banc cliente) {
		System.out.print("Cuanto dinero quieres retirar: ");
		int dinero=lector.nextInt();
		
		Banc.retirarDinero(dinero);
	}

	private static void siguiente() {
		System.out.println("Presiona Enter..." + lector.nextLine());
		lector.nextLine();
	}

	private static void consultarSaldo(Banc cliente) {
		System.out.println("\nTu saldo actual es " + cliente.getSaldo() + ".\n");

	}

	private static void infoCliente(Banc cliente) {
		System.out.println("\nNumero Cuenta: " + cliente.getNombreCompte() + "\nNombre: " + cliente.getNom()
				+ "\nDeposito: " + cliente.getDeposit() + "\nSaldo: " + cliente.getSaldo() + "\n");
	}

	private static void mostrarMenu() {
		System.out.println("Banco La Caixa\n" + "---------------\n" + "1. Mostrar informacion.\n"
				+ "2. Consultar saldo.\n" + "3. Ingresar dinero.\n" + "4. Retirar dinero.\n" + "5. Salir.\n");
	}

}

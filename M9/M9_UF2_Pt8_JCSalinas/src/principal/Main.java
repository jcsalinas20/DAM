package principal;

import java.util.Scanner;

import objetos.*;

public class Main {

	public static AlmacenHerramientas almacenHerramientas;
	public static AlmacenHierro almacenHierro;
	public static Minero minero;
	public static Herrero herrero;
	public static Tren tren;

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		inicialize();// Metodo para inicializar los valores de cada objeto

		System.out.println("Introduce la cantidad de mineros: ");
		int numMineros = lector.nextInt();// Pregunta el número de mineros
		System.out.println("Introduce la cantidad de herreros: ");
		int numHerreros = lector.nextInt();// Pregunta el número de herreros

		ProduccionHierro pHierro = new ProduccionHierro();
		for (int i = 0; i < numMineros; i++) {
			Thread hierro = new Thread(pHierro);
			hierro.start();// Comienza el trabajo del minero
		}

		ProduccionHerramientas pHerramientas = new ProduccionHerramientas();
		for (int i = 0; i < numHerreros; i++) {
			Thread herramientas = new Thread(pHerramientas);
			herramientas.start();// Comienza el trabajo del herrero
		}

		CargamentoTren cTren = new CargamentoTren();
		Thread cargamentoTren = new Thread(cTren);
		cargamentoTren.start();// Comienza el trabajo del tren

		lector.close();
	}

	private static void inicialize() {
		almacenHerramientas = new AlmacenHerramientas(10, 0);// (capacidad maxima, capacidad actual)
		almacenHierro = new AlmacenHierro(10, 0);// (capacidad maxima, capacidad actual)
		minero = new Minero(1000);// (velocidad a la que trabaja)
		herrero = new Herrero(2000);// (velocidad a la que trabaja)
		tren = new Tren(5000, 5);// (velocidad a la que trabaja, cargamento maximo)
	}

}

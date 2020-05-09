import java.util.Scanner;

public class Main {
	static Validaciones vali = new Validaciones();
	static ArchivoDDBB archivo = new ArchivoDDBB();
	static boolean finBucle = false;
	static Scanner lector = new Scanner(System.in);
	static int contador;// Contador para ingresar los valores del bacario

	public static void main(String[] args) {

		archivo.comprobarQueExiste();// Metodo para comprobar que existe el archivo

		Becari.listaBecarios = archivo.lecturaDeFichero();// Metodo para leer el archivo y meterlos en el ArrayList

		while (!finBucle) {
			mostrarMenu();// Metodo para mostrar el menu
			int opcion = seleccionDeOpcion();// Metodo para escoger una opcion
			menu(opcion);// Metodo para hacer la accion del menu

		}

//		 Metodo para guardar el arraylist en el archivo cuando acabe el programa
		archivo.guardarEnArchivo(Becari.listaBecarios);
	}

//	 Metodo para hacer la accion del menu
	private static void menu(int opcion) {
		switch (opcion) {
		case 1:
			ingresarBecario();// Metodo para agregar un becario
			break;
		case 2:
			Becari.mostrarBecarios();// Metodo para mostrar los becarios
			break;
		case 3:
			archivo.crearBackUp(Becari.listaBecarios);// Metodo para crear el archivo backup
			break;
		case 4:
			finBucle = true;
			System.out.println("El programa ha finalizado.");
			break;
		}
	}

	private static void ingresarBecario() {
		contador = 0;// Inicializar contador en 0
		Becari b = new Becari();// Declaracion de la variable b de la clase Becari
		lector.nextLine();

		System.out.print("\n\nIntroduce nombre y apellidos: ");
		String nombreApellidos = lector.nextLine();
		b.setNombreApellidos(nombreApellidos);// Agregado el nombre y apellido
		for (contador = 0; contador < 1; contador++) {// For para validar que se ha introducido el valor correcto.
			System.out.print("Introduce tu sexo(H\\M):");
			String letra = lector.next();
			char sexo = letra.charAt(contador);// Pasar de String a Char
			b.setSexe(sexo);// Agregado el sexo
		}
		for (contador = 0; contador < 1; contador++) {
			System.out.print("Introduce tu edad:");
			int edad = lector.nextInt();
			b.setEdad(edad);// Agregado la edad
		}
		for (contador = 0; contador < 1; contador++) {
			System.out.print("Introduce el numero de suspendidas:");
			int suspendidas = lector.nextInt();
			b.setNumSuspendidos(suspendidas);// Agregado las notas suspendidas
		}
		for (contador = 0; contador < 1; contador++) {
			System.out.print("Residencia familiar(SI\\NO): ");
			String respuesta = lector.next();
			if (respuesta.equalsIgnoreCase("si")) {
				b.setResicenciaFamiliar(true);// Agregado la residencia familiar con true
			} else if (respuesta.equalsIgnoreCase("no")) {
				b.setResicenciaFamiliar(false);// Agregado la residencia familiar con false
			} else {
//				Si no es ni "si" ni "no" se resta 1 al contador hasta que lo introduzca bien.
				contador--;
			}
		}
		for (contador = 0; contador < 1; contador++) {
			System.out.print("Introduce tus ingresos: ");
			float ingresos = lector.nextFloat();
			b.setIngresos(ingresos);// Agregado los ingresos
		}
		Becari.listaBecarios.add(b);// Agregar Becari al ArrayList
		System.out.println("\n");
	}

//	 Metodo para escoger una opcion
	private static int seleccionDeOpcion() {
		int opcion = vali.validacionOpcionMenu();// Metodo para validar la opcion introducida
		return opcion;
	}

//	Metodo para mostrar el menu
	private static void mostrarMenu() {
		System.out.println(
				"1. Insertar Becario\n" + "2. Mostrar Becarios\n" + "3. Crear Backup del fichero\n" + "4. Salir");
		System.out.print("\nIntroduce una opcion: ");
	}

}

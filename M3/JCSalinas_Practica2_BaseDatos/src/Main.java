import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static Scanner lector = new Scanner(System.in);
	static Connection con = null;
	static boolean fi = false;
	static PreparedStatement pstmnt = null;
	static Statement stmnt = null;
	static ResultSetMetaData rmetad = null;
	static ResultSet rset = null;
	static boolean validacion = false;

	public static void main(String[] args) {
		con = Datos.conexion(con);

		while (!fi) {
//			menu();
//
//			int opcion = validarOpcion();
//
//			opcionElegida(opcion);
		}

	}

	private static void opcionElegida(int opcion) {
		switch (opcion) {
		case 0:
			fi = true;
			System.out.println("Has salido del programa.");
			break;

		case 1:
			Datos.mostrarBasesDeDatos(con);
			break;

		case 2:
			Datos.mostrarTablas(con);
			break;

		case 3:
			Datos.ordenarDinero(con);
			break;

		case 4:
			System.out.print("Ordenar por Nombre, Dinero o Puntos: ");
			String ordenarPor = lector.next();
			if (ordenarPor.equalsIgnoreCase("nombre")) {
				Datos.ordenacionMultiple(con, ordenarPor);
			} else if (ordenarPor.equalsIgnoreCase("dinero")) {
				Datos.ordenacionMultiple(con, ordenarPor);
			} else if (ordenarPor.equalsIgnoreCase("puntos")) {
				Datos.ordenacionMultiple(con, ordenarPor);
			} else {
				System.out.println("Opcion incorrecta.\n");
			}
			break;

		case 5:
			Datos.registrarFila(con);
			break;

		case 6:
			System.out.print("Nombre o Descripcion: ");
			String buscarPor = lector.next();
			if (buscarPor.equalsIgnoreCase("nombre") || buscarPor.equalsIgnoreCase("descripcion")) {
				Datos.buscar(con, buscarPor);
			}else {
				System.out.println("Opcion incorrecta.");
			}
			break;

		case 7:
			System.out.print("Introduce el nombre del granjero: ");
			lector.nextLine();
			String nombre = lector.nextLine();
			Datos.incrementarNivel(con, nombre);
			break;

		case 8:
			int id = validarId();
			Datos.eliminar(con, id);
			break;

		}

	}

	private static void menu() {
		System.out.println("0. Salir\n" + "1. Mostrar Bases de Datos\n" + "2. Mostrar tablas de farmville\n"
				+ "3. Ordenar granjeros por dinero\n" + "4. Ordenar por Nombre, Dinero o Puntos\n"
				+ "5. Registrar Granjeros\n" + "6. Buscar granjero por nombre o descripcion\n"
				+ "7. Incrementar 1 nivel el granjero\n" + "8. Eliminar granjero\n");
	}

	private static int validarOpcion() {
		validacion = false;
		int opcion = 0;
		do {
			System.out.print("Elige una opcion: ");
			if (lector.hasNextInt()) {
				opcion = lector.nextInt();
				if (opcion >= 0 && opcion < 9) {
					validacion = true;
				} else {
					lector.nextLine();
				}
			} else {
				lector.nextLine();
			}
		} while (validacion != true);
		return opcion;

	}
	private static int validarId() {
		validacion = false;
		int id = 0;
		do {
			System.out.print("Introduce el id del granjero: ");
			if (lector.hasNextInt()) {
				id = lector.nextInt();
				if (id >= 0) {
					validacion = true;
				} else {
					lector.nextLine();
				}
			} else {
				lector.nextLine();
			}
		} while (validacion != true);
		return id;

	}

}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	static Connection conn;
	static boolean finPrimerMenu = false, finSegundoMenu = false;
	static Scanner lector = new Scanner(System.in);
	static String tablaSeleccionada;
	static PreparedStatement pstmnt;
	static ResultSet rset;

	public static void main(String[] args) throws SQLException {
		conn = Conexion.conexion();

		while (!finPrimerMenu) {
			mostrarMenu1();
			int opcion = Validaciones.opcionMenu(1);
			menu1(opcion);
		}

		conn.close();
	}

	private static void menu1(int opcion) {
		switch (opcion) {
		case 1:
			tablaSeleccionada = "Empleado";
			segundaParte();
			break;
		case 2:
			tablaSeleccionada = "Departamento";
			segundaParte();
			break;
		case 3:
			finPrimerMenu = true;
			System.out.println("Has salido del programa.");
			break;
		default:
			break;
		}
	}

	private static void segundaParte() {
		finSegundoMenu = false;
		while (!finSegundoMenu) {
			mostrarMenu2();
			int opcion = Validaciones.opcionMenu(2);
			menu2(opcion);
		}
	}

	private static void menu2(int opcion) {
		switch (opcion) {
		case 1:
			if (tablaSeleccionada.equals("Empleado"))
				Inserts.empleado();
			else
				Inserts.departamento();
			break;
		case 2:
			if (tablaSeleccionada.equals("Empleado"))
				Updates.empleado();
			else
				Updates.departamento();
			break;
		case 3:
			if (tablaSeleccionada.equals("Empleado"))
				Deletes.empleado();
			else
				Deletes.departamento();
			break;
		case 4:
			finSegundoMenu = true;
			System.out.println("\nHas salido de " + tablaSeleccionada + ".\n");
			break;

		default:
			break;
		}
	}

	private static void mostrarMenu2() {
		System.out.print("\n1. Insertar " + tablaSeleccionada + ".\n2. Modificar " + tablaSeleccionada
				+ ".\n3. Eliminar " + tablaSeleccionada + ".\n4. Salir de " + tablaSeleccionada + "\n\n-> ");
	}

	private static void mostrarMenu1() {
		System.out.print("1. Modificar tabla Empleado.\n2. Modificar tabla Departamento.\n\n-> ");
	}

}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio3 {

	static PreparedStatement pstmnt;
	static Connection connection;
	static ResultSet rset;
	static Scanner lector = new Scanner(System.in);
	static int id;

	public static void main(String[] args) throws SQLException {
		connection = Conexion.conexion();

		System.out.println("Introduce el nombre: ");
		String nombre = lector.nextLine();
		System.out.println("Introduce el apellido 1: ");
		String ape1 = lector.nextLine();
		System.out.println("Introduce el apellido 2: ");
		String ape2 = lector.nextLine();

		if (comprobarCliente(nombre, ape1, ape2)) {
			System.out.println("Nom de l'assegurat: " + nombre + " " + ape1 + " " + ape2);
			System.out.println("Total assistencia medica: " + contarSeguros());
			System.out.println("Import: " + sumaSeguros());
		}

	}

	private static int contarSeguros() throws SQLException {
		String select = "SELECT count(importe) FROM asistenciamedica WHERE IdSeguro = " + id;
		pstmnt = connection.prepareStatement(select);
		rset = pstmnt.executeQuery();

		while (rset.next()) {
			return rset.getInt(1);
		}
		return 0;
	}

	private static int sumaSeguros() throws SQLException {
		String select = "SELECT sum(importe) FROM asistenciamedica WHERE IdSeguro = " + id;
		pstmnt = connection.prepareStatement(select);
		rset = pstmnt.executeQuery();

		while (rset.next()) {
			return rset.getInt(1);
		}
		return 0;
	}

	private static boolean comprobarCliente(String nombre, String ape1, String ape2) throws SQLException {
		String select = "SELECT idSeguro FROM seguro WHERE nombre = '" + nombre + "' AND ape1='" + ape1 + "' AND ape2='"
				+ ape2 + "';";
		pstmnt = connection.prepareStatement(select);
		rset = pstmnt.executeQuery();

		while (rset.next()) {
			id = rset.getInt(1);
			return true;
		}
		return false;
	}

}

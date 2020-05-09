package ejercicio2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	static Connection con;
	static PreparedStatement pstmnt;
	static ResultSet rset;
	static boolean statement;
	static ResultSet rs;
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		con = conexion();

		insertarDepartamento();
		insertarPersonal();

//		CREATE DEFINER=`root`@`localhost` PROCEDURE `IgualarComision`(IN `nuevaComision` INT) NOT DETERMINISTIC NO SQL SQL SECURITY DEFINER UPDATE empleados SET comision = nuevaComision WHERE oficio LIKE 'VENDEDOR'
		System.out.print("\n\nIntroduce la nueva comision: ");
		int comision = lector.nextInt();
		CallableStatement cs = con.prepareCall("{call IgualarComision(" + comision + ")}");
		rs = cs.executeQuery();
		System.out.println("Comisiones igualadas en VENDEDORES");

//		CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarEmpleados`(IN `dep` VARCHAR(100)) NOT DETERMINISTIC NO SQL SQL SECURITY DEFINER SELECT * FROM empleados WHERE dept_no = (SELECT dept_no FROM departamentos WHERE dnombre LIKE dep)
		System.out.print("\n\nIntroduce el departamento: ");
		String dep = lector.nextLine();
		CallableStatement cstat = con.prepareCall("CALL `mostrarEmpleados`(?);");
        cstat.setString(1, dep);
		
		rs = cstat.executeQuery();
		boolean empleadosEncontrados = false;
		while (rset.next()) {
			empleadosEncontrados = true;
			System.out.println(rset.getInt(1) + " - " + rset.getString(2) + " - " + rset.getString(3) + " - "
					+ rset.getInt(4) + " - " + rset.getDate(5) + " - " + rset.getInt(6) + " - " + rset.getInt(7) + " - "
					+ rset.getInt(8));
		}

		if (!empleadosEncontrados)
			System.out.println("No se ha encontrado ningun empleado con el departamento " + dep + ".");
	}

	private static void insertarPersonal() {
		String insert = "INSERT INTO empleados VALUES (1, 'JOAQUIN', 'DEVELOPER', 7450, '2020-01-12', 1500, null, 50);";
		try {
			if (!comprobarEmpleado()) {
				pstmnt = con.prepareStatement(insert);
				int resultado = pstmnt.executeUpdate();
				if (resultado == 0) {
					System.out.println("NO se ha agregado el nuevo empleado.");
				} else {
					System.out.println("Se ha agregado el nuevo empleado.");
				}
			} else {
				System.out.println("El empleado ya existe.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean comprobarEmpleado() throws SQLException {
		pstmnt = con.prepareStatement("SELECT * FROM `empleados` WHERE dept_no = 50");
		rset = pstmnt.executeQuery();
		boolean ningunResutado = true;
		while (rset.next())
			return true;

		if (ningunResutado == true)
			return false;

		return true;
	}

	private static void insertarDepartamento() {
		String insert = "INSERT INTO departamentos VALUES (50, 'DEVOPS', 'MARTORELL');";
		try {
			if (!comprobarDepartamento()) {
				pstmnt = con.prepareStatement(insert);
				int resultado = pstmnt.executeUpdate();
				if (resultado == 0) {
					System.out.println("NO se ha agregado el nuevo departamento \\\"DEVOPS\\\".");
				} else {
					System.out.println("Se ha agregado el nuevo departamento \"DEVOPS\".");
				}
			} else {
				System.out.println("El departamento ya existe.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean comprobarDepartamento() throws SQLException {
		pstmnt = con.prepareStatement("SELECT * FROM `departamentos` WHERE dnombre LIKE 'DEVOPS'");
		rset = pstmnt.executeQuery();
		boolean ningunResutado = true;
		while (rset.next())
			return true;

		if (ningunResutado == true)
			return false;

		return true;
	}

	public static Connection conexion() {
		Connection con = null;
		String usuari = "root";
		String clau = "";
		String urlDades = "jdbc:mysql://localhost/vuelos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(urlDades, usuari, clau);
			System.out.println("Conectado correctamente");
		} catch (ClassNotFoundException ex) {
			System.out.println("No trobat el Driver MySQL per JDBC.");
		} catch (SQLException e) {
			System.out.println("Excepcion del tipus SQL");
			e.printStackTrace();
		}
		return con;
	}

}

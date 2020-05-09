import java.sql.SQLException;
import java.util.Date;

public class Inserts {

	// DATOS EMPLEADO
	static int id_emp;
	static String apellido;
	static String oficio;
	static int dir;
	static float salario;
	static float comision;
	static int dep;
	// DATOS DEPARTAMENTO

	public static void empleado() {
		datosEmpleado();
		String insert = "INSERT INTO empleados VALUES (" + id_emp + ", '" + apellido + "', '" + oficio + "', " + dir
				+ ", now(), " + salario + ", " + comision + ", " + dep + ")";
		try {
			Main.pstmnt = Main.conn.prepareStatement(insert);
			int resultado = Main.pstmnt.executeUpdate();
			if (resultado != 0)
				System.out.println("\nSe ha agregado correctamente.\n");
		} catch (SQLException e) {
		}
	}

	public static void departamento() {
		// TODO Auto-generated method stub

	}

	private static void datosEmpleado() {
		id_emp = Validaciones.idEmpleado();
		System.out.print("Introduce el apellido: ");
		apellido = Main.lector.next();
		System.out.print("Introduce el oficio: ");
		oficio = Main.lector.next();
		System.out.print("Introduce el dir: ");
		dir = Main.lector.nextInt();
		System.out.print("Introduce el salario: ");
		salario = Main.lector.nextFloat();
		System.out.print("Introduce la comision: ");
		salario = Main.lector.nextFloat();
		System.out.print("Introduce el departamento: ");
		dep = Main.lector.nextInt();

	}

	private static void datosDepartamento() {
		// TODO Auto-generated method stub

	}

}

import java.sql.SQLException;

public class Selects {

	public static boolean comprobarIdEmpleado(int id) {
		String select = "SELECT emp_no FROM empleados WHERE emp_no = " + id + ";";
		try {
			Main.pstmnt = Main.conn.prepareStatement(select);
			Main.rset = Main.pstmnt.executeQuery();
			boolean ningunResutado = true;
			while (Main.rset.next()) {
				if (Main.rset.getInt(1) == id) {
					System.err.print("El id introducido ya existe.\n-> ");
					return false;
				}
			}
			if (ningunResutado)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

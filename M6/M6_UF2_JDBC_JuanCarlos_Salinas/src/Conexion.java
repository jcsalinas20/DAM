import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


	public static Connection conexion() {
		Connection con = null;
		String usuari = "root";
		String clau = "";
		String urlDades = "jdbc:mysql://localhost/seguros?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid";
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

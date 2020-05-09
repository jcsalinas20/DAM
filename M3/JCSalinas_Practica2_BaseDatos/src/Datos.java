import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Datos {
	static PreparedStatement pstmnt = null;
	static Statement stmnt = null;
	static ResultSetMetaData rmetad = null;
	static ResultSet rset = null;
	static String valorOrdenacion;
	static ArrayList<Granjero> granjeros = new ArrayList<Granjero>();

	public static Connection conexion(Connection con) {
//		String usuari = "carlos";
//		String clau = "P@ssw0rd";
//		String urlDades = "jdbc:mysql://localhost/farmville?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.1.240:3307/naruto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid", "pain", "P@ssw0rd");
			System.out.println("Conectado correctamente");
		} catch (ClassNotFoundException ex) {
			System.out.println("No trobat el Driver MySQL per JDBC.");
		} catch (SQLException e) {
			System.out.println("Excepcion del tipus SQL");
			e.printStackTrace();
		}
		return con;
	}

	public static void mostrarBasesDeDatos(Connection con) {
		try {
			stmnt = con.createStatement();
			rset = stmnt.executeQuery("show databases;");

			System.out.println("\nBases de Datos");
			while (rset.next()) {
				System.out.println(rset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pressEnter();
	}

	public static void pressEnter() {
		Main.lector.nextLine();
		System.out.println("\nPress Enter...\n\n");
		Main.lector.nextLine();
	}

	public static void mostrarTablas(Connection con) {
		try {
			stmnt = con.createStatement();
			rset = stmnt.executeQuery("show tables;");

			System.out.println("Tablas");
			while (rset.next()) {
				System.out.println(rset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pressEnter();
	}

	public static void ordenarDinero(Connection con) {
		Granjero g = new Granjero(0, null, null, 0, 0, 0);
		try {
			stmnt = con.createStatement();
			// rset = stmnt.executeQuery("select * from granjeros order by dinero;");
			rset = stmnt.executeQuery("select * from granjeros;");
			valorOrdenacion = "dinero";

			if (granjeros.size() == 0) {
				g = llenarArray(g);
			}

			for (int i = 0; i < granjeros.size(); i++) {
				g.compareTo(granjeros.get(i));
			}

			Collections.sort(granjeros);

			for (int i = 0; i < granjeros.size(); i++) {
				System.out.println((granjeros.get(i)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pressEnter();
	}

	private static Granjero llenarArray(Granjero g) {
		try {
			granjeros.clear();
			while (rset.next()) {
				g = new Granjero(rset.getInt("id"), rset.getString("nombre"), rset.getString("descripcion"),
						rset.getFloat("dinero"), rset.getInt("puntos"), rset.getInt("nivel"));
				granjeros.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public static void ordenacionMultiple(Connection con, String ordenarPor) {
		valorOrdenacion = ordenarPor;

		try {
			Granjero g = new Granjero(0, null, null, 0, 0, 0);
			stmnt = con.createStatement();
			rset = stmnt.executeQuery("select * from granjeros;");

			g = llenarArray(g);

			for (int i = 0; i < granjeros.size(); i++) {
				g.compareTo(granjeros.get(i));
			}

			Collections.sort(granjeros);

			for (int i = 0; i < granjeros.size(); i++) {
				System.out.println(granjeros.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pressEnter();
	}

	public static void registrarFila(Connection con) {
		String insert = "insert into granjeros(`nombre`, descripcion) values (?, 'Nombre:' ?)";
		try {
			pstmnt = con.prepareStatement(insert);
			System.out.print("Introduce el nombre del granjero:");
			String nombre = Main.lector.next();
			pstmnt.setString(1, nombre);
			pstmnt.setString(2, nombre);
			int resultado = pstmnt.executeUpdate();
			if (resultado == 0) {
				System.out.println("No se ha podido aumentar el nivel.");
			} else {
				System.out.println("Se ha aumentado el nivel.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pressEnter();
	}

	public static void buscar(Connection con, String buscarPor) {
		try {
			if (buscarPor.equalsIgnoreCase("nombre")) {
				pstmnt = con.prepareStatement("select * from granjeros where nombre like ?");
				System.out.print("Introduce el nombre: ");
				Main.lector.nextLine();
				String nombre = Main.lector.nextLine();
				pstmnt.setString(1, "%" + nombre + "%");
			} else if (buscarPor.equalsIgnoreCase("descripcion")) {
				pstmnt = con.prepareStatement("select * from granjeros where descripcion like ?");
				System.out.print("Introduce la descripcion: ");
				Main.lector.nextLine();
				String desc = Main.lector.nextLine();
				pstmnt.setString(1, "%" + desc + "%");
			}
			rset = pstmnt.executeQuery();
			boolean ningunResutado = true;
			while (rset.next()) {
				ningunResutado = false;
				System.out.print(rset.getInt(1) + "  -  ");
				System.out.print(rset.getString(2) + "  -  ");
				System.out.print(rset.getString(3) + "  -  ");
				System.out.print(rset.getInt(4) + "  -  ");
				System.out.print(rset.getInt(5) + "  -  ");
				System.out.println(rset.getInt(6));
			}
			if (ningunResutado == true) {
				System.out.println("No se ha encontrado ninguna fila.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pressEnter();
	}

	public static void incrementarNivel(Connection con, String nombre) {
		try {
			pstmnt = con.prepareStatement("update granjeros set nivel = nivel + 1 where nombre = ?");
			pstmnt.setString(1, nombre);
			int resultado = pstmnt.executeUpdate();
			if (resultado == 0) {
				System.out.println("No se ha podido aumentar el nivel.");
			} else {
				System.out.println("Se ha aumentado el nivel.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pressEnter();
	}

	public static void eliminar(Connection con, int id) {
		try {
			pstmnt = con.prepareStatement("DELETE FROM granjeros WHERE id = ?");
			pstmnt.setInt(1, id);
			int resultado = pstmnt.executeUpdate();
			if (resultado == 0) {
				System.out.println("No existe el granjero " + id +".");
			} else {
				System.out.println("Se ha eliminado correctamente.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		pressEnter();
	}

}

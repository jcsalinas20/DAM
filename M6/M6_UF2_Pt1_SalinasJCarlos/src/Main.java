import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static boolean creacionDeTablaFaccion;
	static boolean creacionDeTablaPersonaje;
	static Scanner lector = new Scanner(System.in);
	static boolean finPrograma = false;
	static Connection con;
	static String ddbb = "ForHonor.db";

//	Conexion con la base de datos
	public static void connect() throws SQLException {
		con = DriverManager.getConnection("jdbc:sqlite:" + ddbb);
		System.out.println("Conexion establecida con la base de datos " + ddbb + "\n");
	}

//	Metodo para crear las tablas
	private static void creacionTablas(Connection con) {
		try {
			String sql = "CREATE TABLE faccion (\n" + "    faccion_id integer PRIMARY KEY,\n"
					+ "    nombre_faccion text NOT NULL,\n" + "    lore text NOT NULL\n" + ");";
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			creacionDeTablaFaccion = true;// poner como true si la tabla no estaba creada
		} catch (SQLException e) {
			creacionDeTablaFaccion = false;// poner como false si ya estaba creada
		}
		try {
			String sql = "CREATE TABLE personajes (\n" + "    personaje_id integer PRIMARY KEY,\n"
					+ "    nombre_personaje text NOT NULL,\n" + "    ataque integer NOT NULL,\n"
					+ "    defensa integer NOT NULL,\n" + "    faccion_id integer NOT NULL,\n"
					+ "    FOREIGN KEY(faccion_id) REFERENCES faccion(faccion_id));";
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			creacionDeTablaPersonaje = true;// poner como true si la tabla no estaba creada
		} catch (SQLException e) {
			creacionDeTablaPersonaje = false;// poner como false si ya estaba creada
		}

	}

//	Metodo para la consulta de los personajes
	private static void mostrarPersonajes(Connection con) throws SQLException {
		String sql = "SELECT * FROM personajes;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("\npersonaje_id\tnombre_personajet\tataque\tdefensa\tfaccion_id");
		System.out.println("------------------------------------------------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt("personaje_id") + "\t\t" + rs.getString("nombre_personaje") + "\t\t"
					+ rs.getInt("ataque") + "\t" + rs.getInt("defensa") + "\t" + rs.getInt("faccion_id"));
		}
		System.out.println();
	}

//	Metodo para la consulta de los caballeros
	private static void mostrarCaballeros(Connection con) throws SQLException {
		String sql = "SELECT * FROM personajes p, faccion f WHERE p.faccion_id = f.faccion_id AND f.nombre_faccion LIKE 'Caballeros';";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("\npersonaje_id\tnombre_faccion\tnombre_personaje\tataque\tdefensa");
		System.out.println("-----------------------------------------------------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt("personaje_id") + "\t\t" + rs.getString("nombre_faccion") + "\t"
					+ rs.getString("nombre_personaje") + "\t\t" + rs.getInt("ataque") + "\t" + rs.getInt("defensa"));
		}
		System.out.println();
	}

//	Metodo para la consulta del samurai
	private static void mostrarSamurai(Connection con) throws SQLException {
		String sql = "SELECT * FROM personajes p, faccion f WHERE p.faccion_id = f.faccion_id AND p.ataque = (SELECT max(p.ataque) FROM personajes p, faccion f WHERE p.faccion_id = f.faccion_id AND f.nombre_faccion LIKE 'Samurais');";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("\npersonaje_id\tnombre_faccion\tnombre_personaje\tataque\tdefensa");
		System.out.println("-----------------------------------------------------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt("personaje_id") + "\t\t" + rs.getString("nombre_faccion") + "\t"
					+ rs.getString("nombre_personaje") + "\t\t" + rs.getInt("ataque") + "\t" + rs.getInt("defensa"));
		}
		System.out.println();
	}

//	Metodo para insertar las filas de la tabla faccion
	private static void insertarFilasPorDefectoFaccion(Connection con, int id, String nombre, String lore)
			throws SQLException {
		String sql = "INSERT INTO faccion(faccion_id,nombre_faccion,lore) VALUES(?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, nombre);
		pstmt.setString(3, lore);
		pstmt.executeUpdate();
	}

//	Metodo para insertar las filas de la tabla personajes
	private static void insertarFilasPorDefectoPersonaje(Connection con, int id, String nombre, int ataque, int defensa,
			int faccion_id) throws SQLException {
		String sql = "INSERT INTO personajes(personaje_id,nombre_personaje,ataque,defensa,faccion_id) VALUES(?,?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, nombre);
		pstmt.setInt(3, ataque);
		pstmt.setInt(4, defensa);
		pstmt.setInt(5, faccion_id);
		pstmt.executeUpdate();
	}

//	Metodo para el menu
	private static void opcionesMenu(int opcion) throws SQLException {
		switch (opcion) {
		case 1:
			mostrarPersonajes(con);
			break;
		case 2:
			mostrarCaballeros(con);
			break;
		case 3:
			mostrarSamurai(con);
			break;
		case 4:
			finPrograma = true;
			System.out.println("Has salido del programa.");
			break;
		}
	}

//	Metodo para validar la opcion del menu elegida
	private static int validarOpcion() {
		int opcion = 0;
		boolean validacion = false;
		do {
			if (lector.hasNextInt()) {
				opcion = lector.nextInt();
				if (opcion > 0 && opcion < 5) {
					validacion = true;
				} else {
					lector.nextLine();
					System.out.print("->");
				}
			} else {
				lector.nextLine();
				System.out.print("->");
			}
		} while (validacion != true);
		return opcion;
	}

	public static void main(String[] args) throws SQLException {
		try {
			connect();// Metodo para abrir la conexion
			creacionTablas(con);// Metodo para crear las tablas
			if (creacionDeTablaFaccion) {// si se ha creado la tabla faccion se introducen los datos
				insertarFilasPorDefectoFaccion(con, 1, "Caballeros",
						"Originalmente los caballeros pertenecían a familias nobles o poseían títulos especiales que ensalzaban su noble comportamiento.");
				insertarFilasPorDefectoFaccion(con, 2, "Vikingos",
						"Los vikingos fueron guerreros escandinavos que entre el siglo VIII y XI realizaron múltiples incursiones en el continente europeo para perpetrar ataques y saqueos.");
				insertarFilasPorDefectoFaccion(con, 3, "Samurais",
						"Los samuráis eran militares que vivieron en la época del Japón feudal y su función principal era defender a los nobles.");
			}
			if (creacionDeTablaPersonaje) {// si se ha creado la tabla personajes se introducen los datos
				insertarFilasPorDefectoPersonaje(con, 1, "Pacificadora", 90, 70, 1);
				insertarFilasPorDefectoPersonaje(con, 2, "Conquistador", 140, 100, 1);
				insertarFilasPorDefectoPersonaje(con, 3, "Justiciero", 110, 80, 1);
				insertarFilasPorDefectoPersonaje(con, 4, "Huscarle", 125, 100, 2);
				insertarFilasPorDefectoPersonaje(con, 5, "Invasor ", 130, 70, 2);
				insertarFilasPorDefectoPersonaje(con, 6, "Nobushi ", 80, 120, 3);
				insertarFilasPorDefectoPersonaje(con, 7, "Kensei  ", 70, 150, 3);
			}
//			Bucle para mostrar el menu
			while (!finPrograma) {
				System.out.print(
						"1. Mostrar Personajes\n2. Mostrar Caballeros\n3. Mostrar el Samurai con mas ataque\n4. Salir del programa\n\nElige una opcion: ");
				int opcion = validarOpcion();// Metodo para validar la opcion del menu elegida
				opcionesMenu(opcion);// Metodo para el menu
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}

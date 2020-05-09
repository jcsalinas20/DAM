import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static boolean finPrograma = false;
	static Scanner lector = new Scanner(System.in);
	static Connection con;
	static PreparedStatement pstmnt;
	static ResultSet rset;
	static int numeroFila;

	public static void main(String[] args) {

		conexion();// Hacer la conexion con la base de datos
		sacarElNumeroDeFila();// Saber el numero de fila del id maximo
		while (!finPrograma) {
			mostrarMenu();// mostrar menu
			int opcion = comprobarOpcion();// comprobar el numero de opcion
			System.out.println();// salto de linea
			menu(opcion);// acciones de menu
		}

	}

	private static void sacarElNumeroDeFila() {
		try {
			Statement stmnt = con.createStatement();
			rset = stmnt.executeQuery("SELECT max(COD_SOC) FROM socio");// consulta para sacar el maximo numero

			numeroFila = rset.getInt(1);// guardarlo en una variable

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	Menu
	private static void menu(int opcion) {
		switch (opcion) {
		case 1:
			insertarSocio();// insertar socios en base de datos
			break;
		case 2:
			System.out.print("Introduce el numero de id del socio: ");
			int id = lector.nextInt();
			mostrarSocio(id);// mostrar los socios de la base de datos
			break;
		case 3:
			System.out.print("Introduce el numero de id del socio: ");
			id = lector.nextInt();
			eliminarSocio(id);// eliminar socio de la base de datos
			break;
		case 4:
			finPrograma = true;
			System.out.println("El programa ha finalizado.");
			break;
		}
	}

//	eliminar socio de la base de datos
	private static void eliminarSocio(int id) {
		try {
			pstmnt = con.prepareStatement("DELETE FROM socio WHERE COD_SOC = ?");// eliminar socio con el id pasado con
																					// el metodo
			pstmnt.setInt(1, id);
			int resultado = pstmnt.executeUpdate();// ejecutar delete
			if (resultado == 0) {// comprobar si alguna fila ha sido afectada
				System.out.println("No se ha encontrado el socio " + id + ".");
			} else {
				System.out.println("Se ha eliminado correctamente.");
			}
			System.out.println("\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	mostrar socios de la base de datos
	private static void mostrarSocio(int id) {
		try {
			pstmnt = con.prepareStatement("SELECT COD_SOC, NOMBRE, APELLIDOS, CUOTA FROM socio WHERE COD_SOC = ?");// consulta
																													// con
																													// el
																													// id
																													// pasado
																													// con
																													// el
																													// metodo
			pstmnt.setInt(1, id);

			rset = pstmnt.executeQuery();// ejecutar consulta

			boolean ningunResutado = true;// booleano para saber si se encontro algun dato.
			System.out.println("COD_SOC\tNOMBRE\tAPELLIDOS\tCUOTA");
			System.out.println("--------------------------------------");
			while (rset.next()) {// Mostrar datos de la consulta
				ningunResutado = false;
				System.out.print(rset.getInt(1) + "\t");
				System.out.print(rset.getString(2) + "\t");
				System.out.print(rset.getString(3) + "\t");
				System.out.print(rset.getInt(4));
			}
			System.out.println();// salto de la linea

			if (ningunResutado == true) {// si no se entra en el while muestra el siguiente mensaje
				System.out.print("No se ha encontrado ninguna fila.");
			} else {
				System.out.print("\nQuieres cambiar la cuota? ");
				String respuesta = lector.next();

				if (respuesta.equalsIgnoreCase("si")) {
					System.out.print("Introduce la nueva cuota: ");
					int nuevaCuota = comprobarCuotaEdad();
					pstmnt = con.prepareStatement("UPDATE socio SET CUOTA = ? WHERE COD_SOC = ?");// Actualizar cuota
																									// del socio
					pstmnt.setInt(1, nuevaCuota);
					pstmnt.setInt(2, id);
					int resultado = pstmnt.executeUpdate();// ejecutar update
					if (resultado == 0) {
						System.out.println("No se ha podido cambiar la cuota.");
					} else {
						System.out.println("Se ha cambiado correctamente la cuota.");
					}
				}

			}
			// Mostrar resultados otra vez
			pstmnt = con.prepareStatement("SELECT COD_SOC, NOMBRE, APELLIDOS, CUOTA FROM socio WHERE COD_SOC = ?");
			pstmnt.setInt(1, id);

			rset = pstmnt.executeQuery();

			ningunResutado = true;
			System.out.println("COD_SOC\tNOMBRE\tAPELLIDOS\tCUOTA");
			System.out.println("--------------------------------------");
			while (rset.next()) {
				System.out.print(rset.getInt(1) + "\t");
				System.out.print(rset.getString(2) + "\t");
				System.out.print(rset.getString(3) + "\t");
				System.out.print(rset.getInt(4));
			}
			System.out.println("\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void insertarSocio() {
		lector.nextLine();
		// insercion de socio
		String insert = "insert into socio(cod_soc, nombre, apellidos, direccion, telefono, poblacion, cp, provincia, pais, edad, fechaalta, cuota) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmnt = con.prepareStatement(insert);

//			Preguntar parametros del nuevo socio
			System.out.println("Agregar socio");
			System.out.print("Nombre: ");
			String nombre = comprobarString("nombre");
			System.out.print("Apellidos: ");
			String apellidos = comprobarString("apellido");
			System.out.print("Direccion: ");
			String direccion = comprobarString("direccion");
			System.out.print("Telefono: ");
			int telefono = comprobarTelefono();
			lector.nextLine();
			System.out.print("Poblacion: ");
			String poblacion = comprobarString("poblacion");
			System.out.print("Codigo postal: ");
			int cp = comprobarCP();
			lector.nextLine();
			System.out.print("Provincia: ");
			String provincia = comprobarString("provincia");
			System.out.print("Pais: ");
			String pais = comprobarString("pais");
			System.out.print("Edad: ");
			int edad = comprobarCuotaEdad();
			System.out.print("Cuota: ");
			int cuota = comprobarCuotaEdad();

//			Insertar parametros en consulta
			pstmnt.setInt(1, numeroFila);
			pstmnt.setString(2, nombre);
			pstmnt.setString(3, apellidos);
			pstmnt.setString(4, direccion);
			pstmnt.setInt(5, telefono);
			pstmnt.setString(6, poblacion);
			pstmnt.setInt(7, cp);
			pstmnt.setString(8, provincia);
			pstmnt.setString(9, pais);
			pstmnt.setInt(10, edad);
			pstmnt.setDate(11, sacarFechaSistema());
			pstmnt.setInt(12, cuota);

			int resultado = pstmnt.executeUpdate();// ejecutar insercion
			numeroFila++;// sumar 1 al numero de la fila
			if (resultado == 0) {
				System.out.println("No se ha podido insertar la fila.");
			} else {
				System.out.println("Fila insertada correctamente.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	Validacion de numero de caracteres de los strings
	private static String comprobarString(String valor) {
		String respuesta = "";
		boolean validacion = false;
		int numMaxCaracteres = 0;
		if (valor.equals("poblacion")) {
			numMaxCaracteres = 30;
		} else if (valor.equals("pais")) {
			numMaxCaracteres = 10;
		} else {
			numMaxCaracteres = 20;
		}

		do {
			respuesta = lector.nextLine();
			if (respuesta.length() < numMaxCaracteres) {
				validacion = true;
			} else {
				System.out.print("->");
			}
		} while (!validacion);

		return respuesta;
	}

//	Validacion de la cuota y la edad
	private static int comprobarCuotaEdad() {
		int cuotaEdad = 0;
		boolean validacion = false;
		do {
			if (lector.hasNextInt()) {
				cuotaEdad = lector.nextInt();
				if (cuotaEdad > 0) {
					validacion = true;
				} else {
					lector.nextLine();
					System.out.print("->");
				}
			} else {
				lector.nextLine();
				System.out.print("->");
			}
		} while (!validacion);
		return cuotaEdad;
	}

//	validacion del codigo postal
	private static int comprobarCP() {
		int cp = 0;
		boolean validacion = false;
		do {
			if (lector.hasNextInt()) {
				cp = lector.nextInt();
				if (cp > 9999 && cp < 100000) {
					validacion = true;
				} else {
					lector.nextLine();
					System.out.print("->");
				}
			} else {
				lector.nextLine();
				System.out.print("->");
			}
		} while (!validacion);
		return cp;
	}

//	Validar el numero del telefono
	private static int comprobarTelefono() {
		int telefono = 0;
		boolean validacion = false;
		do {
			if (lector.hasNextInt()) {
				telefono = lector.nextInt();
				if (telefono > 99999999 && telefono < 1000000000) {
					validacion = true;
				} else {
					lector.nextLine();
					System.out.print("->");
				}
			} else {
				lector.nextLine();
				System.out.print("->");
			}
		} while (!validacion);
		return telefono;
	}

//	sacar la fecha del sistema
	private static java.sql.Date sacarFechaSistema() {
		Date objDate = new Date();
		String strDateFormat = "YYYY-MM-dd";// formato de la fecha
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		String fecha = objSDF.format(objDate);// pasar de util.Date a string
		java.sql.Date sqlDate = java.sql.Date.valueOf(fecha);// pasr de string a sql.Date
		return sqlDate;
	}

//	Validar numero introducido del menu
	private static int comprobarOpcion() {
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
		} while (!validacion);
		return opcion;
	}

//	mostrar menu
	private static void mostrarMenu() {
		System.out.print(
				"1. Dar de alta un socio\n2. Cuota del socio\n3. Eliminar socio\n4. Salir del programa\n\nOpcion: ");
	}

//	Crear conexion con la base de datos
	public static void conexion() {
		String usuari = "root";
		String clau = "";
		String urlDades = "jdbc:mysql://localhost/bd_videoclub?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid";
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
	}

}

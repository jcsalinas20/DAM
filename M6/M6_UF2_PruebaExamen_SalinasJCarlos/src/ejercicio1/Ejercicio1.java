package ejercicio1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import objetos.Personal;
import objetos.Vuelo;
import util.HibernateUtil;

public class Ejercicio1 {

	private static Session session;
	private static Transaction transaction;
	public static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();// comienzo de sesion
		transaction = session.beginTransaction();
		Date date = new Date();

		if (!mostrarVuelo()) {
			System.out.println("Insertando nuevo Vuelo: ");
			System.out.println("    new Vuelo(\"123\", \"ABDUS\", \"MADRID\", \"COMERCIAL\", date, null, null);");
			Vuelo vuelo = new Vuelo("123", "ABDUS", "MADRID", "COMERCIAL", date, null, null);
			session.save(vuelo);
			boolean vueloMostrado = mostrarVuelo();
		}

		System.out.println("\n\n");

		// listar personal con categoria PILOTO
		mostrarPilotos();

		System.out.println("\n\n");

		// llamar al stored procedure
		llamarAlProcedured();

		transaction.commit();// guardar todos los cambios
		session.close();
		System.exit(0);// cerrar el programa
	}

	private static void llamarAlProcedured() {
		System.out.println("Vuelos posteriores al 17/02/2020");
		Query procedureQuery = session.createSQLQuery("CALL MostrarVuelos()").addEntity(Vuelo.class);
		List<Vuelo> vuelos = procedureQuery.list();
		if (vuelos.size() > 0) {
			for (Vuelo vuelo : vuelos) {
				System.out.println("\t" + vuelo.toString());
			}
		} else {
			System.out.println("NO HAY NINGUN VUELO");
		}
	}

	private static void mostrarPilotos() {
		Query query = session.createQuery("FROM Personal WHERE CATEGORIA LIKE 'PILOTO'");// consulta a Persona
		List<Personal> personals = query.list();
		if (personals.size() > 0) {
			System.out.println("TABLA Personal");
			for (Personal personal : personals) {
				System.out.println("\t" + personal.toString());
			}
		} else {
			System.out.println("NO HAY NINGUN PILOTO");
		}
	}

	private static boolean mostrarVuelo() {
		Query query = session.createQuery("from Vuelo where IDENTIFICADOR = '123'");// consulta a Persona
		List<Vuelo> vuelos = query.list();
		if (vuelos.size() > 0) {
			System.out.println("TABLA Vuelo");
			for (Vuelo vuelo : vuelos) {
				System.out.println("\t" + vuelo.toString());
			}
		} else {
			return false;
		}
		return true;
	}

}
package main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import objetos.Faccion;
import objetos.Personaje;
import util.HibernateUtil;

@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
public class Main {

	private static Session session;
	private static boolean finPrograma = false;
	private static Transaction transaction;
	public static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();// comienzo de sesion
		transaction = session.beginTransaction();

		while (!finPrograma) {
			session.clear();
			mostrarMenu();
			int opcion = Validaciones.comprobarOpcion();
			menu(opcion);
		}

		transaction.commit();// guardar todos los cambios
		session.close();
		System.exit(0);// cerrar el programa
	}

	private static void menu(int opcion) {
		switch (opcion) {
		case 1:
			mostrarTodosLosPersonajes();
			break;
		case 2:
			cambiarAtaque();
			break;
		case 3:
			borrarPersonaje();
			break;
		case 4:
			borrarFaccion();
			break;
		case 5:
			cambioFaccion();
			break;
		case 6:
			System.out.println("El programa ha finalizado.");
			finPrograma = true;
			break;
		}
	}

	private static void cambioFaccion() {
		System.out.print("\nIntroduce el ID del personaje para cambiar de faccion: ");
		int id = Validaciones.validarID();// Validar el id introducido
		Query query = session.createQuery("from Personaje where personaje_id = :id");// consulta a Personajes
		query.setParameter("id", id);
		List<Personaje> personajes = query.list();// lista de Personajes
		if (personajes.size() > 0) {// comprobar que existe el personaje
			Personaje personaje = personajes.get(0);// coger peronaje de la posicion 0
			System.out.print("Introduce la nueva faccion para " + personaje.getNombre() + ": ");
			int nuevaFaccion = Validaciones.validarID();
			query = session.createQuery("from Faccion where faccion_id = :id");// consulta a Faccion
			query.setParameter("id", nuevaFaccion);
			List<Faccion> faccions = query.list();
			if (faccions.size() > 0) {// comprobar que la faccion introducida existe
				// llamar al stored procedure
				Query procedureQuery = session
						.createSQLQuery("CALL Change_Faction( " + id + ", " + nuevaFaccion + " )");
				procedureQuery.executeUpdate();
				System.out.println("Faccion cambiada correctamente.\n");
			} else {
				System.out.println("El numero de la faccion introducida no existe.\n");
			}
		} else {
			System.out.println("No se ha encontrado ningun personaje con el ID \"" + id + "\".\n");
		}
	}

	private static void borrarFaccion() {
		System.out.print("\nIntroduce el ID de la faccion a eliminar: ");
		int id = Validaciones.validarID();// Comprobar el id introducido
		Query query = session.createQuery("from Faccion where faccion_id = :id");// consulta a Faccion
		query.setParameter("id", id);
		List<Faccion> facciones = query.list();
		if (facciones.size() > 0) {// comprobar que existe la faccion
			Faccion faccion = facciones.get(0);
			query = session.createQuery("from Personaje where faccion_id = :id");// Consulta a Personajes
			query.setParameter("id", id);
			List<Personaje> personajes = query.list();
			if (personajes.size() == 0) {// comprobar que no hay ningun personaje en la faccion
				System.out.print("Deseas eliminar la faccion " + faccion.getNombre() + "(Si\\No): ");
				String respuesta = lector.next();
				if (respuesta.equalsIgnoreCase("si")) {
					// delete para eliminar la faccion
					Query deleteQuery = session.createQuery("delete from Faccion where faccion_id = :id");
					deleteQuery.setParameter("id", id);
					deleteQuery.executeUpdate();

					System.out.println("Se ha eliminado correctamente.\n");
				} else {
					System.out.println("La faccion no se ha eliminado.\n");
				}
			} else {
				System.out.println("En la faccion \"" + id + "\" no se puede eliminar porque hay personajes.\n");
			}
		} else {
			System.out.println("No se ha encontrado ninguna faccion con el ID \"" + id + "\".\n");
		}
	}

	private static void borrarPersonaje() {
		System.out.print("\nIntroduce el ID del personaje a eliminar: ");
		int id = Validaciones.validarID();
		Query query = session.createQuery("from Personaje where personaje_id = :id");// consulta a Personajes
		query.setParameter("id", id);
		List<Personaje> personajes = query.list();
		if (personajes.size() > 0) {// comprobar existe el personaje
			Personaje personaje = personajes.get(0);
			System.out.print("Deseas eliminar el personaje " + personaje.getNombre() + "(Si\\No): ");
			String respuesta = lector.next();
			if (respuesta.equalsIgnoreCase("si")) {
				// delete para eliminar el personaje
				Query deleteQuery = session.createQuery("delete from Personaje where personaje_id = :id");
				deleteQuery.setParameter("id", id);
				deleteQuery.executeUpdate();

				System.out.println("Se ha eliminado correctamente.\n");
			} else {
				System.out.println("El personaje no se ha eliminado.\n");
			}
		} else {
			System.out.println("No se ha encontrado ningun personaje con el ID \"" + id + "\".\n");
		}
	}

	private static void cambiarAtaque() {
		System.out.print("\nIntroduce el ID del personaje para cambiar el ataque: ");
		int id = Validaciones.validarID();
		Query query = session.createQuery("from Personaje where personaje_id = :id");// consulta a Personajes
		query.setParameter("id", id);
		List<Personaje> personajes = query.list();
		if (personajes.size() > 0) {// comprobar que existe el personaje
			Personaje personaje = personajes.get(0);
			System.out.print("Introduce el nuevo ataque para el personaje " + personaje.getNombre() + "("
					+ personaje.getAtaque() + "): ");
			int nuevoAtaque = Validaciones.validarAtaque();
			// actualizar el ataque con un update
			Query updateQuery = session.createQuery("update Personaje set ataque=:atack where personaje_id=:id");
			updateQuery.setParameter("id", id);
			updateQuery.setParameter("atack", nuevoAtaque);
			updateQuery.executeUpdate();

			System.out.println("Se ha cambiado correctamente.\n");
		} else {
			System.out.println("No se ha encontrado ningun personaje con el ID \"" + id + "\".\n");
		}
	}

	private static void mostrarTodosLosPersonajes() {
		Query query = session.createQuery("from Personaje");// consulta a Personaje
		List<Personaje> personajes = query.list();
		System.out.println("------DATOS------");
		for (Personaje personaje : personajes) {
			System.out.print(personaje.getPersonaje_id() + " - " + personaje.getNombre() + " - " + personaje.getAtaque()
					+ " - " + personaje.getDefensa() + " - ");
			// consulta a Faccion con la faccion_id del personaje actual
			query = session.createQuery("from Faccion where faccion_id = :id");
			query.setParameter("id", personaje.getFaccion_id());
			List<Faccion> facciones = query.list();
			for (Faccion faccion : facciones) {
				System.out.println(faccion.getNombre());
			}
		}
		System.out.println("\n");
	}

	private static void mostrarMenu() {
		System.out.print(
				"1. Mostrar Personajes\n2. Cambiar ataque\n3. Borrar personaje\n4. Borrar faccion\n5. Cambiar faccion de personaje\n6. Salir\n\n-> ");
	}
}

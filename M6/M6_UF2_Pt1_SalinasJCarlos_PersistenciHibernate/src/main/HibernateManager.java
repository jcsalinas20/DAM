package main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Llibre;
import biblioteca.Persona;
import persistencia.Hibernateutil;

public class HibernateManager {

	private static Session session;
	private static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		session = Hibernateutil.getSessionFactory().openSession();// abrir sesion
		Transaction transaction = session.beginTransaction();

		mostrarBaseDeDatos();

		pressEnter("introducir datos");
		insertar();// insertar datos

		mostrarBaseDeDatos();

		pressEnter("eliminar datos");
		eliminar();// eliminar datos
		transaction.commit();// guardar todos los datos

		mostrarBaseDeDatos();

		session.close();// cerrar la sesion
		System.exit(0);// cerrar el programa
	}

	private static void eliminar() {
		Persona persona = (Persona) session.load(Persona.class, 14521452);
		session.delete(persona);
		Llibre llibre = (Llibre) session.load(Llibre.class, 531);
		session.delete(llibre);
	}

	private static void insertar() {
		objetosPersona(14521452, "Pedro", 478569852);
		objetosPersona(25896325, "Eric", 589632147);
		objetosBiblioteca(20, "Biblioteca Virtual");
		objetosLlibre(531, "Harry Potter y el prisionero de Azkaban", "Narrativa Joven", "J.K. Rowling");
		objetosLlibre(532, "Harry Potter y el cáliz de fuego", "Narrativa Joven", "J.K. Rowling");
		objetosAutor(150, "J.K. Rowling");
	}

	private static void objetosAutor(int id, String autor) {
		session.save(new Autor(id, autor));// insertar fila en tabla Autor
	}

	private static void objetosLlibre(int id, String titulo, String editoril, String autor) {
		session.save(new Llibre(id, titulo, editoril, autor));// insertar fila en tabla Llibre
	}

	private static void objetosBiblioteca(int id, String nom) {
		session.save(new Biblioteca(id, nom));// insertar fila en tabla Biblioteca
	}

	private static void objetosPersona(int dni, String nombre, int tel) {
		session.save(new Persona(dni, nombre, tel));// insertar fila en tabla Persona
	}

	private static void mostrarBaseDeDatos() {
		System.out.println("\n");

		Query query = session.createQuery("from Persona");// consulta a Persona
		List<Persona> personas = query.list();
		System.out.println("TABLA Persona");
		if (personas.size() > 0) {
			for (Persona persona : personas) {
				System.out.println("\t" + persona.toString());
			}
		} else {
			System.out.println("NINGUN DATO EN LA TABLA PERSONA");
		}

		query = session.createQuery("from Biblioteca");// consulta a Biblioteca
		List<Biblioteca> bibliotecas = query.list();
		System.out.println("TABLA Biblioteca");
		if (bibliotecas.size() > 0) {
			for (Biblioteca biblioteca : bibliotecas) {
				System.out.println("\t" + biblioteca.toString());
			}
		} else {
			System.out.println("NINGUN DATO EN LA TABLA BIBLIOTECA");
		}

		query = session.createQuery("from Llibre");// consulta a Llibre
		List<Llibre> llibres = query.list();
		System.out.println("TABLA Llibre");
		if (llibres.size() > 0) {
			for (Llibre llibre : llibres) {
				System.out.println("\t" + llibre.toString());
			}
		} else {
			System.out.println("NINGUN DATO EN LA TABLA LLIBRE");
		}

		query = session.createQuery("from Autor");// consulta a Autor
		List<Autor> autors = query.list();
		System.out.println("TABLA Autor");
		if (autors.size() > 0) {
			for (Autor autor : autors) {
				System.out.println("\t" + autor.toString());
			}
		} else {
			System.out.println("NINGUN DATO EN LA TABLA AUTOR");
		}

		System.out.println();
		System.out.println("---------------------------------------------------------------------------");
		System.err.println();
	}

	private static void pressEnter(String text) {
		System.out.println("Pulsa Enter para " + text + "...\n");
		lector.nextLine();
	}

}

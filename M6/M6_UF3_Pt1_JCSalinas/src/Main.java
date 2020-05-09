import java.util.Scanner;

import org.bson.Document;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.scene.control.Menu;

public class Main {

	private static boolean finPrograma = false;
	private static boolean salirMenu1 = false;

	private static Scanner lector = new Scanner(System.in);

	private static final String USER = "admin";
	private static final String PASS = "admin";
	private static final String DB = "Tienda";

	private static MongoCollection<Document> collection;

	private static String coleccionSeleccionada = "";

	private static MongoDatabase database;
	private static MongoClient mongo;

	private static String nombre;
	private static String plataforma;
	private static float precio;

	public static void main(String[] args) {
		crearConexion();

		while (!finPrograma) {
			mostrarMenu1();
			int opcionMenu1 = lector.nextInt();
			menu1(opcionMenu1);

			collection = database.getCollection(coleccionSeleccionada);

			if (!finPrograma) {
				salirMenu1 = false;
				while (!salirMenu1) {
					mostrarMenu2();
					int opcionMenu2 = lector.nextInt();
					menu2(opcionMenu2);
				}
			}
		}

	}

	private static void menu2(int opcion) {
		switch (opcion) {
		case 1:
			lector.nextLine();
			Document document = null;
			Document updateDocument = null;
			if (coleccionSeleccionada.equals("Consolas")) {
				System.out.print("Nombre de la consola: ");
				nombre = lector.nextLine();
				System.out.print("Precio: ");
				precio = lector.nextFloat();
				document = new Document("nombre", nombre).append("precio", precio);
			} else {
				System.out.print("Nombre del juego: ");
				nombre = lector.nextLine();
				System.out.print("Precio: ");
				precio = lector.nextFloat();
				lector.nextLine();
				System.out.print("Nombre de la consola: ");
				plataforma = lector.nextLine();
				document = new Document("nombre", nombre).append("precio", precio).append("plataforma", plataforma);
			}
			collection.insertOne(document);
			System.out.println("Insertado correctamente.");
			break;
		case 2:
			lector.nextLine();
			if (coleccionSeleccionada.equals("Consolas")) {
				System.out.print("Nombre de la consola que quieres actualizar: ");
				nombre = lector.nextLine();
				System.out.print("Nuevo precio: ");
				precio = lector.nextFloat();
				document = new Document("nombre", nombre);
				updateDocument = new Document("$set", new Document("precio", precio));
			} else {
				System.out.print("Nombre del juego que quieres actualizar: ");
				nombre = lector.nextLine();
				System.out.print("Nuevo precio: ");
				precio = lector.nextFloat();
				document = new Document("nombre", nombre);
				updateDocument = new Document("$set", new Document("precio", precio));
			}
			collection.findOneAndUpdate(document, updateDocument);
			System.out.println("Actualizado correctamente.");
			break;
		case 3:
			lector.nextLine();
			if (coleccionSeleccionada.equals("Consolas")) {
				System.out.print("Nombre de la consola que quieres eliminar: ");
				nombre = lector.nextLine();
				document = new Document("nombre", nombre);
			} else {
				System.out.print("Nombre del juego que quieres eliminar: ");
				nombre = lector.nextLine();
				document = new Document("nombre", nombre);
			}
			boolean res = collection.findOneAndDelete(document) != null;
			if (res)
				System.out.println("Eliminado correctamente.");
			break;
		case 4:
			mostrarMenu3();
			int opcion3 = lector.nextInt();
			menu3(opcion3);
			break;
		case 5:
			salirMenu1 = true;
			System.out.println();
			break;
		default:
			break;
		}
	}

	private static void mostrarMenu3() {
		System.out.print("\n1. Mostrar todos los datos\n2. Filtrar datos\n\n->");	
	}

	private static void menu3(int opcion) {
		switch (opcion) {
		case 1:
			MongoCollection<Document> coll = database.getCollection(coleccionSeleccionada);
			MongoCursor<Document> cursor = coll.find().iterator();
			while (cursor.hasNext()) {
			   Document document = cursor.next();
			   System.out.println(document);
			}
			break;

		case 2:
			lector.nextLine();
			if (coleccionSeleccionada.equals("Consolas"))
				System.out.print("Nombre de la consola: ");
			else 
				System.out.print("Nombre del juego: ");
			nombre = lector.nextLine();
			
			Document findDocument = new Document("nombre", nombre);
			
			coll = database.getCollection(coleccionSeleccionada);
			cursor = coll.find(findDocument).iterator();
			while (cursor.hasNext()) {
			   Document document = cursor.next();
			   System.out.println(document);
			}
			break;

		default:
			break;
		}
	}

	private static void mostrarMenu2() {
		System.out.print("\n1. Insertar datos\n2. Modificar datos\n3. Eliminar datos\n4. Buscar datos\n5. Salir\n\n->");
	}

	private static void menu1(int opcion) {
		switch (opcion) {
		case 1:
			coleccionSeleccionada = "Consolas";
			System.out.println("\nConsolas");
			break;
		case 2:
			coleccionSeleccionada = "Juegos";
			System.out.println("\nJuegos");
			break;
		case 3:
			finPrograma = true;
			System.out.println("\nFin del programa.");
			break;

		default:
			break;
		}
	}

	private static void mostrarMenu1() {
		System.out.print("1. Consolas\n2. Juegos\n3. Salir\n\n->");
	}

	private static void crearConexion() {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://" + USER + ":" + PASS
				+ "@clustersalinas-hvex2.mongodb.net/" + DB + "?retryWrites=true&w=majority");
		mongo = new MongoClient(uri);
		database = mongo.getDatabase("Tienda");
	}

}

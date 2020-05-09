/*********************************CODIGO PRACTICA 1*********************************/
package ejercicio8;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	static Validaciones vali = new Validaciones();// Constructor para llamar a los metodos de la clase Validaciones
	static HashMap<String, Float> juegos = new HashMap<String, Float>();// Guardar los productos
	static Scanner lector = new Scanner(System.in);// Lector del sistema
	static boolean finBucle = false;// boolean para el while

	public static void main(String[] args) throws FileNotFoundException {
//		Metodo que devuelve los productos que ya habian en el fichero
		juegos = MetodosPt2.cogerProductosDelHashMapDelFichero();

		while (!finBucle) {// Bucle while

			mostrarMenu();// Metodo para mostrar menu

			int opcion = seleccionarOpcion();// Metodo para introducir un numero

			opcionSeleccionada(opcion);// Metodo para hacer la accion a partir del numero

		}
		lector.close();// Cierre del lector

//		Metodo para guardar los productos en el fichero
		MetodosPt2.insertarHashMapEnFichero(juegos);
	}

//	 Metodo para hacer la accion a partir del numero
	private static void opcionSeleccionada(int opcion) {
		switch (opcion) {
		case 1:
			insertarModificarProducto("insertar");// Metodo para insertar un producto
			break;

		case 2:
			insertarModificarProducto("modificar");// Metodo para modificar un producto
			break;

		case 3:
			borrar();// Metodo para borrar un producto
			break;

		case 4:
			mostrar();// Metodo para mostrar los productos
			break;

		case 5:
			finBucle = true;// Boolean para terminar el while
			System.out.println("Fin del programa.");// Mensaje
			break;
		}
	}

//	 Metodo para introducir un numero
	private static int seleccionarOpcion() {
		int opcion = vali.validacionOpcionMenu();// Metodo para validar el numero introducido
		return opcion;// Devuelve el numero
	}

//	 Metodo para mostrar menu
	private static void mostrarMenu() {
		System.out.println("1. Insertar producto\r\n" + "2. Modificar producto\r\n" + "3. Borrar videojuego\r\n"
				+ "4. Mostrar productos\r\n" + "5. Salir\r\n");

	}

//	 Metodo para borrar un producto
	private static void borrar() {
		lector.nextLine();
		System.out.print("\nIntroduce el nombre del producto que quieres eliminar: ");// Mensaje para que introduzca el
																						// producto
		String producto = lector.nextLine();// Guargar en string el producto

		producto = producto.toLowerCase();// Convertir el string en todo minusculas

//		IF con metodo para validar si existe el producto
		if (vali.comprobacionProductoExiste(producto)) {// si existe
			juegos.remove(producto);// Borra el producto
			System.out.println("Se ha borrado el producto " + producto + ".");// Mensaje con el nombre del producto
		} else {
			System.out.println("No se ha encontrado el producto.");// Mensaje
		}
		System.out.println("\n");// Doble salto de linea
	}

//	 Metodo para mostrar los productos
	private static void mostrar() {
		TreeMap<String, Float> ordenacion = new TreeMap<String, Float>();// Declaraion de un TreeMap
		ordenacion = conversionTreeMap(ordenacion);// Metodo que devuelve el TreeMap con los valores del HashMap

		Iterator<String> producto = ordenacion.keySet().iterator();// Covertir el Iterator la key del treemap

		System.out.println("\nLista de juegos.");// Menaje
		while (producto.hasNext()) {
			String clave = producto.next();// Guardar en string el iterator
			System.out.println(clave + ": " + ordenacion.get(clave));// Mostrar la key y el valor.
		}
		System.out.println("\n");// Doble salto de linea
	}

//	 Metodo que devuelve el TreeMap con los valores del HashMap
	private static TreeMap<String, Float> conversionTreeMap(TreeMap<String, Float> ordenacion) {
		ordenacion.putAll(juegos);// Meter el HashMap entero dentro del TreeMap para que lo ordene
		return ordenacion;// Devuelve el TreeMap
	}

//	 Metodo para insertar y modificar un producto
	private static void insertarModificarProducto(String opcion) {
		lector.nextLine();

		System.out.print("\nIntroduce el nombre del juego: ");// Mensaje para introducir el producto
		String nombreJuego = lector.nextLine();// String para guardar el producto

		nombreJuego = nombreJuego.toLowerCase();// Convertir el string en todo minusculas

		boolean existe = vali.comprobacionProductoExiste(nombreJuego);// Metodo para saber si existe el producto

//		Si el string pasado al metodo es insertar y el producto no existe o el string es modificar y existe entras al if
		if ((opcion.equals("insertar") && !existe) || (opcion.equals("modificar") && existe)) {

			float precio = vali.validacionPrecio();// Metodo que devuelve el precio validado

			juegos.put(nombreJuego, precio);
			System.out.println("\n");// Doble salto de linea

		} else if (!existe) {
			System.out.println("El producto no existe.\n");// Mensaje con salto de linea
		} else if (existe) {
			System.out.println("El producto ya existe.\n");// Mensaje con salto de linea
		}
	}

}
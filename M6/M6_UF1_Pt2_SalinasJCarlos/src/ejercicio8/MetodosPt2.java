/*********************************CODIGO PRACTICA 2*********************************/
package ejercicio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class MetodosPt2 {
	static File ruta = new File("BaseDeDatosProductos.txt");// Ruta del fichero de los prouctos

//	Metodo para guardar los productos en el fichero
	public static void insertarHashMapEnFichero(HashMap<String, Float> productos) throws FileNotFoundException {
		TreeMap<String, Float> productosOrdenador = new TreeMap<String, Float>();// Declraracion del TreeMap
		productosOrdenador.putAll(productos);

		Iterator<String> iter = productosOrdenador.keySet().iterator();

		System.out.println("\nSe han guardado los siguintes juegos en la Base de Datos.");
		PrintStream escriptor = new PrintStream(ruta);// Print para escribir en el fichero
		while (iter.hasNext()) {
			String key = iter.next();// Guardar en string la key
			escriptor.print(key + "," + productosOrdenador.get(key) + "-");// print en el fichero escribiendo la key y
																			// el valor
			System.out.println(key + " - " + productosOrdenador.get(key));// Mensaje con la key y el valor
		}
		escriptor.close();// Cierre del print
	}

//	Metodo que devuelve los productos que ya habian en el fichero
	public static HashMap<String, Float> cogerProductosDelHashMapDelFichero() throws FileNotFoundException {
		HashMap<String, Float> productos = new HashMap<String, Float>();// Declaracion del HashMap
		Scanner lector = new Scanner(ruta);// Scanner del fichero
		String texto = "";// Variable para guadar el texto del fichero
		while (lector.hasNextLine()) {
			texto += lector.nextLine();// Guardar en el string el texto del fichero
		}
		String[] todosLosProductos = texto.split("-");// Separar cada producto en cada posicion
		for (int i = 0; i < todosLosProductos.length; i++) {
			String[] productoYprecio = todosLosProductos[i].split(",");// Separar el juego y el precio de cada producto
			productos.put(productoYprecio[0], Float.parseFloat(productoYprecio[1]));// 0 = juego(key), 1 = precio(value)
		}
		lector.close();// Cierre del Scanner
		return productos;// Devolvemos el hashmap con los valores del fichero
	}

}

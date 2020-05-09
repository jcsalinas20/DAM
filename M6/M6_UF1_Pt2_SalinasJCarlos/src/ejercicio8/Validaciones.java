/*********************************CODIGO PRACTICA 1*********************************/
package ejercicio8;

import java.util.Iterator;

public class Validaciones {

//	Metodo para validar el numero de la opcion del menu
	public int validacionOpcionMenu() {
		int opcion = 0;// Declaracion de la opcion
		boolean validacion = false;// Declaracion del boolean validacion
		do {
			System.out.print("Elige una opcion: ");// Mensaje para elegir un numero
			if (Main.lector.hasNextInt()) {// Comprobacion que sea un Integer
				opcion = Main.lector.nextInt();// Guardar en int la opcion
				if (opcion > 0 && opcion < 6) {// Comprobar que la opcion sea mas grande de 0 y mas pequenio de 6
					validacion = true;// Validacion se convierte en true
				} else {
					Main.lector.nextLine();// Salto de linea
				}
			} else {
				Main.lector.nextLine();// Salto de linea
			}
		} while (!validacion == true);// Comprueba que la validacion sea true
		return opcion;// Devuelve el numero de la opcion
	}

//	Metodo para comprobar si existe el producto
	public boolean comprobacionProductoExiste(String producto) {
		boolean productoEncontrado = false;// Declaracion de un boolean productoEncontrdo

		Iterator<String> productos = Main.juegos.keySet().iterator();// Convertir la key en Iterator

		while (productos.hasNext()) {
			if (productos.next().equalsIgnoreCase(producto)) {// Comprueba si el producto existe o no
				productoEncontrado = true;// El boolean se convierte en true
			}
		}

		return productoEncontrado;// Devuelve en boolean
	}

//	Metodo para validar el precio del producto
	public float validacionPrecio() {
		float precio = 0f;// Declaracion del precio
		boolean validacion = false;// Declaracion del boolean validacion
		do {
			System.out.print("Introduce el precio: ");// Mensaje para elegir el precio
			if (Main.lector.hasNextFloat()) {// Comprobacion que se un Float
				precio = Main.lector.nextFloat();// Guardar en float el precio
				if (precio >= 0) {// Comprobar que el precio es mas grande o igual a 0
					validacion = true;// Validacion se convierte en true
				} else {
					Main.lector.nextLine();// Salto de linea
				}
			} else {
				Main.lector.nextLine();// Salto de linea
			}
		} while (!validacion == true);// Comprueba que la validacion sea true
		return precio;// Devuelve el precio
	}

}

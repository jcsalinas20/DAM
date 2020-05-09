package Practica1;
import java.util.*;
public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int num = 0;
		String[] tabla = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		System.out.println("introduce un numero del 0-9: ");
		num = x.nextInt();
		if (num >= 0 && num <= 9) {
			System.out.println("El numero "+ num +" corresponde a: "+ tabla[num]);
		} 
		else {
			System.out.println("El numero "+ num +" no corresponde a ningun sitio");
		}
		x.close();
	}

}

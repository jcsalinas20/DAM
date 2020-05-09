package Practica1;
import java.util.*;
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int num = 0;
		int[] tabla = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 };
		System.out.print("Introduce un numero del 0-9: ");
		num=x.nextInt();
		if (num>=0 && num<=20) {
			System.out.println("El numero "+num+" corresponde al numero "+tabla[num]+" de la tabla.");
		}
		else {
			System.out.println("El numero "+num+" no esta dentro del rango de la tabla.");
		}
		x.close();
	}

}

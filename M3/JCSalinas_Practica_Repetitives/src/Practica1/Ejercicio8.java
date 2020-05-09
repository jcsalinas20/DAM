package Practica1;
import java.util.*;
public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner x=new Scanner (System.in);
		int i=0;
		int divisor=0;
		System.out.print("Introduce un numero: ");
		divisor=x.nextInt();
		System.out.println("");
		System.out.print("Los divisores de "+divisor+" son: ");
		for ( i = 1 ; i <= divisor ; i++) {
            if (divisor % i == 0) {
                System.out.print (i+"  ");
            }
		}
		x.close();
	}

}

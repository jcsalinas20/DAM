package Practica2;
import java.util.*;
public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int altura=0;
		int contador=1;
		System.out.print("Introduce la altura del triangulo: ");
		altura=x.nextInt();
		for (int z=0; z<altura; z++) {
			for (int y=0; y<contador; y++) {
				System.out.print("a");
			}
			System.out.println("");
			contador++;
		}
		x.close();
	}

}

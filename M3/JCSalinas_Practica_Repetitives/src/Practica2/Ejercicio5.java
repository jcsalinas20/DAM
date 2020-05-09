package Practica2;
import java.util.*;
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);

		System.out.print("Introduce un numero para saber su divisor: ");
		int num=0;
		int div=0;
		boolean i=false;
		
		num=x.nextInt();
		div = num - 1;
		while ( !i && div>1 ) {
			if (num%div==0) {
				i = true;
			} 
			else {
				div--;
			}
		}
		if (div == 0) {
			System.out.println("No s'ha trobat cap divisor.");
		} 
		else {
			System.out.println("");
			System.out.println("El divisor de "+num+" es " + div);
		}
		x.close();
	}

}

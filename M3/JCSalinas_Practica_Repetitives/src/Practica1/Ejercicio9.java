package Practica1;
import java.util.*;
public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int numIntro=0;
		int num=0;
		int numNegative=0;
		System.out.print("Cuantos numeros introduciras? ");
		numIntro=x.nextInt();
		System.out.println("");
		while (numIntro>0) {
			System.out.print("Numero "+numIntro+": ");
			num=x.nextInt();
			if (num<0) {
				numNegative=numNegative+1;
			}
			numIntro--;
		} 
		System.out.println("");
		System.out.println("Numeros negativos introducidos: "+numNegative);
		x.close();
	}

}

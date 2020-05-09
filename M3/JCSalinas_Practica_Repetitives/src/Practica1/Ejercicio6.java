package Practica1;
import java.util.*;
public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int numIntro=0;
		int num=0;
		int mediana=0;
		int numMayor=0;
		int numMenor=10000000;
		System.out.print("Introduce el numero de veces que quieres introdcir un numero: ");
		numIntro=x.nextInt();
		System.out.println("");
		while (numIntro>=1) {
			System.out.print("Numero "+numIntro+": ");
			num=x.nextInt();
			mediana=mediana+num;
			numIntro--;
			if (numMayor<num) {
				numMayor=num;
			}
			if (numMenor>num) {
				numMenor=num;
			}
		}
		System.out.println("");
		System.out.println("El numero mayor es: " + numMayor);
		System.out.println("El numero menor es: " + numMenor);
		System.out.println("La mediana es: " + mediana);
		x.close();
	}

}

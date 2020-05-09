package Practica2;
import java.util.*;
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n1=0;
		int n2=0;
		int suma=0;
		System.out.print("Introduce el priemer numero: ");
		n1=x.nextInt();
		System.out.print("Introduce el segundo numero: ");
		n2=x.nextInt();
		if (n1<n2) {
			while (n1<n2) {
				n1=n1+1;
				suma=suma+n1;
			}
			System.out.println("");
			System.out.println("Suma de los numeros entre n1<n2: "+suma);
		}
		else {
			System.out.println("Error");
		}
		x.close();
	}

}

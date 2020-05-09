package Practica2;
import java.util.*;
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n1=0;
		int n2=0;
		System.out.print("Introduce el priemer numero: ");
		n1=x.nextInt();
		System.out.print("Introduce el segundo numero: ");
		n2=x.nextInt();
		if (n1<n2) {
			while (n1<=n2) {
				System.out.print(n1+" ");
				n1=n1+1;
			}
		}
		else {
			System.out.println("Error");
		}
		x.close();
	}

}

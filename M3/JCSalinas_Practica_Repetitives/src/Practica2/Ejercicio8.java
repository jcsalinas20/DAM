package Practica2;
import java.util.*;
public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n1=0;
		int n2=0;
		System.out.print("Introduce el primer valor: ");
		n1=x.nextInt();
		System.out.print("Introduce el segundo valor: ");
		n2=x.nextInt();
		System.out.print("\rNumeros par del "+n1+" al "+n2+": ");
		if (n1<n2) {
			if (n2%2!=0) {
				n2--;
				System.out.print(n2+" ");
				while (n2>n1) {
					n2=n2-2;
					System.out.print(n2+" ");
				}
			}
			else {
				System.out.print(n2+" ");
				while (n2>n1) {
					n2=n2-2;
					System.out.print(n2+" ");
				}
			}
		}
		else {
			System.out.print("Error al introducir los valores");
		}
		x.close();
	}

}

package Practica2;
import java.util.*;
public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n1=0;
		int n2=0;
		int multiple=0;
		int i=0;
		System.out.print("Introduce el priemer numero: ");
		n1=x.nextInt();
		System.out.print("Introduce el segundo numero: ");
		n2=x.nextInt();
		if (n1<n2 && n1>=0) {
			multiple=n1;
			i=n1;
			while (multiple<=n2) {
				System.out.print(multiple+" ");
				multiple=n1*i;
				i++;
			}
		}
		else {
			System.out.println("");
			System.out.println("Error");
		}
		x.close();
	}

}

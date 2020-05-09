package Practica2;
import java.util.Scanner;
public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int num=0;
		System.out.println("Introduce un numero:");
		num=x.nextInt();
		if (num>=0) {
			if ( num%2==0 ) {
				System.out.println("Par");
			}
			else if ( num%2==1 ) {
				System.out.println("Impar");
			}
		}
		else {
			System.out.println("Error numerico");
		}
		x.close();
	}

}

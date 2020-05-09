package Practica2;
import java.util.Scanner;
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int num1=0;
		int num2=0;
		int num3=0;
		System.out.println("Introduce el primer numero: ");
		num1=x.nextInt();
		System.out.println("Introduce el segundo numero: ");
		num2=x.nextInt();
		System.out.println("Introduce el tercer numero: ");
		num3=x.nextInt();
		if (num1<num2) {
			if (num2<num3) {
				System.out.println("Numeros ordenados");
				System.out.println(num1+","+num2+","+num3);
			}
			else {
				System.out.println("Numeros desordenados");
			}
		}
		else {
			System.out.println("Numeros desordenados");
		}
		x.close();
	}

}

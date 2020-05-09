package Practica2;
import java.util.*;
public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int num=0;
		int contador=0;
		System.out.print("Introduce una serie de numeros: ");
		num=x.nextInt();
		while (num>0) {
			num=num/10;
			contador++;
		}
		System.out.println("El numero de cifras es de "+contador);
		x.close();
	}

}

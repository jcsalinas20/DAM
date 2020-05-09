package Practica2;
import java.util.*;
public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int num=0;
		int resultado=0;
		int contador=0;
		System.out.print("Introduce un limite: ");
		num=x.nextInt();
		x.nextLine();
		while (resultado<=num) {
			System.out.println(contador);
			System.out.println(resultado);
			resultado=resultado+contador;
			contador++;
		}
		System.out.println("El limite de "+num+" es "+(resultado-(contador-1)));
		x.close();
	}

}

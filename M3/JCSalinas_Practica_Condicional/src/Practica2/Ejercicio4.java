package Practica2;
import java.util.Scanner;
public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int any=0;
		System.out.println("Introduiu un any:");
		any=x.nextInt();
		if ((any % 4 == 0) && ((any % 100 != 0) || (any % 400 == 0)))
			System.out.println("L'any es de traspas");
		else
			System.out.println("L'any no es de traspas");
		x.close();
	}

}

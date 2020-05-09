package Practica1;
import java.util.Scanner;
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		double kg=0;
		double p=0;
		System.out.println("Introdueix el Kilos: ");
		kg=x.nextDouble();
		p=kg+kg;
		System.out.println("Preu: " + p + "€");
		if (kg>=0 && kg<=2) {
			System.out.println("No s'ha fet ningun descompte");
		}
		else if (kg>=2.01 && kg<=5) {
			System.out.println("Descompte del 10%");
			p= p -((p/100)*10);
		}
		else if (kg>=5.01 && kg<=10) {
			System.out.println("Descompte del 15%");
			p= p -((p/100)*15);
		}
		else if (kg>10) {
			System.out.println("Descompte del 20%");
			p= p -((p/100)*20);
		}
		else {
			System.out.println("Error al calcular los Kilos");
		}
		System.out.println("Preu Final: " + p + "€");
		x.close();
	}

}

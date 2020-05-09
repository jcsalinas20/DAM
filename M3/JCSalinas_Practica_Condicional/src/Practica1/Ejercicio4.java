package Practica1;
import java.util.Scanner;
public class Ejercicio4 {

	public static void main(String[] args) {
		//restar 1h y despues sumar 1h=1,5€
		Scanner x = new Scanner(System.in);
		int horaEnt=0;
		int horaSor=0;
		float precio=0f;
		System.out.println("Hora de Entrada: ");
		horaEnt=x.nextInt();
		System.out.println("Hora de Sortida: ");
		horaSor=x.nextInt();
		if (horaEnt>=0 && horaSor<=24) {
			horaSor-=horaEnt;
			System.out.println("Horas utilizadas:" + horaSor +"h");
		}
		else {
			System.out.println("Indroduzca la hora otra vez");
		}
		horaSor-=1;
		precio = (float) (horaSor * 2 + 1.5);

		System.out.println("Precio: " + precio + "€");
		x.close();
	}

}

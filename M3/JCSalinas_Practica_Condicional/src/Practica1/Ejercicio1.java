package Practica1;
import java.util.Scanner;
public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		float nota;
		
		System.out.println("Quina nota has tret? ");
		nota=x.nextFloat();
		if (nota>=0 && nota<5) {
			System.out.println("Suspes");
		}
		else if (nota>=5 && nota<6.5) {
			System.out.println("Be");
		}
		else if (nota>=6.5 && nota<8.5) {
			System.out.println("Notable");
		}
		else if (nota>=8.5 && nota<=10) {
			System.out.println("Excelent");
		}
		else {
			System.out.println("Nota Invalida");
		}
		x.close();
	}

}

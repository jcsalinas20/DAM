package Practica1;
import java.util.Scanner;
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		float dinero=0f;
		float conversion=0f;
		float eur_usd=1.15f;
		float eur_yen=131.18f;
		float usd_eur=0.87f;
		float usd_yen=113.73f;
		float yen_eur=0.0076f;
		float yen_usd=0.0088f;
		float convf=0f;
		System.out.println("1.- Euro a Dolares \r2.- Euro a Yenes \r3.- Dolares a Euros"
				+ "\r4.- Dolares a Yenes \r5.- Yenes a Euros \r6.- Yenes a Dolares \r\rEscoge el numero de tu conversion=");
		dinero=x.nextFloat();
		if (dinero==1) {
			System.out.println("Introduzca la cantidad de dinero: ");
			conversion=x.nextFloat();
			System.out.println("Euro a Dolar");
			convf = conversion * eur_usd;
			System.out.println(conversion+"€ => "+convf+"$");
		}
		else if (dinero==2) {
			System.out.println("Introduzca la cantidad de dinero: ");
			conversion=x.nextFloat();
			System.out.println("Euro a Yen");
			convf = conversion * eur_yen;
			System.out.println(conversion+"€ => "+convf+"¥");
		}
		else if (dinero==3) {
			System.out.println("Introduzca la cantidad de dinero: ");
			conversion=x.nextFloat();
			System.out.println("Dolar a Euro");
			convf = conversion * usd_eur;
			System.out.println(conversion+"$ => "+convf+"€");
		}
		else if (dinero==4) {
			System.out.println("Introduzca la cantidad de dinero: ");
			conversion=x.nextFloat();
			System.out.println("Dolar a Yen");
			convf = conversion * usd_yen;
			System.out.println(conversion+"$ => "+convf+"¥");
		}
		else if (dinero==5) {
			System.out.println("Introduzca la cantidad de dinero: ");
			conversion=x.nextFloat();
			System.out.println("Yen a Euro");
			convf = conversion * yen_eur;
			System.out.println(conversion+"¥ => "+convf+"€");
		}
		else if (dinero==6) {
			System.out.println("Introduzca la cantidad de dinero: ");
			conversion=x.nextFloat();
			System.out.println("Yen a Dolar");
			convf = conversion * yen_usd;
			System.out.println(conversion+"¥ => "+convf+"$");
		}
		else {
			System.out.println("Error al selecionar numero");
		}
		x.close();
	}

}

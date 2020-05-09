package Practica2;
import java.util.Scanner;
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		float horas=35f;
		float horasExt=0f;
		float precioHor=0f;
		float precioExt=0f;
		float importe=0f;
		System.out.println("Horas semanales trabajadas + horas extras:");
		horasExt=x.nextFloat();
		System.out.println("Precio por Hora:");
		precioHor=x.nextFloat();
		if (horasExt>35 && precioHor>0) {
			horasExt=horasExt-35;
			precioExt=precioHor/2;
			horasExt*=precioExt;
			horas=horas*precioHor;
			importe=horas+horasExt;
		}
		else {
			System.out.println("No tienes Horas Extras");
			importe=horasExt*precioHor;
		}
		System.out.println("Importe de Horas + Horas Extras: "+importe+"€");
		x.close();
	}

}

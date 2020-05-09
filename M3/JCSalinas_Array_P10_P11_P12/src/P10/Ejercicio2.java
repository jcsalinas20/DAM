package P10;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		boolean validacion = false;
		int posiciones = 0;
		int base = 0;

		do {
			System.out.println("Que base quieres utilizar: ");
			if (x.hasNextInt()) {
				base = x.nextInt();
				if (base > 0) {
					validacion = true;
				}
			} else {
				x.next();
			}
		} while (validacion != true);
		System.out.print("BASE " + base);

		validacion = false;
		do {
			System.out.print("\rIntroduce el numero que quieres: ");
			if (x.hasNextInt()) {
				posiciones = x.nextInt();
				if (posiciones > 0) {
					validacion = true;
				}
			} else {
				x.next();
			}
		} while (validacion != true);
		
		String total=String.valueOf(posiciones);
		int position= Integer.parseInt(total,base);
		
		System.out.println("\rResultado: " + position);
		x.close();
		
		String y = "12021";
		for(int i=4;i<=15;i++){
		    System.out.println(y + " de base " + i + " a base 10 es " + Integer.parseInt(y,i));
		}
		
		  String numero = "12021";
		int baseOrigen = 4;
		
		int numeroBase10 = 905;
		int baseDestino = 4;
		
		String numeroBaseB =  Integer . toString (numeroBase10, baseDestino);
		numeroBase10 =  Integer . parseInt (numero, baseOrigen);
		 
		System.out.println(numeroBaseB);
		System.out.println("\n\n"+numeroBase10);
		
		
		
		
		
		
		
		
		
		
		   
	}

}

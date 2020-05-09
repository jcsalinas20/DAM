import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		boolean validacion = false;
		int numero = 0;
		int base10 = 10;
		int base2 = 2;
		String cambioBase="";

		System.out.print("BASE " + base10);
		System.out.println("\nLa Base a utilizar sera la 10.");

		System.out.print("\rIntroduce el numero para cambiar a Base2: ");
		do {
			if (x.hasNextInt()) {
				numero = x.nextInt();
				if (numero >= 0) {
					validacion = true;
				}
				else {
					System.out.println("El numero tiene que ser positivo.");
				}
			} else {
				x.next();
			}
		} while (validacion != true);
		
		cambioBase = Integer.toString(numero, base2); 
		
		System.out.print("Resulado Base2: "+cambioBase);

		x.close();
	}

}

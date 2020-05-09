import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String numeros = new String();
		int sumaTotal=0;
		int numEntero=0;
		

		System.out.println("Introduce solo numeros separados por comas: ");
		numeros=lector.nextLine();
		
		String[] cadena= numeros.split(",");
		System.out.println(Arrays.toString(cadena));
		for (int i=0; i<cadena.length;i++) {
			numEntero=Integer.parseInt(cadena[i]);
			sumaTotal=sumaTotal+numEntero;
		}
		System.out.println("Suma total: "+sumaTotal);
		
		lector.close();
	}

}

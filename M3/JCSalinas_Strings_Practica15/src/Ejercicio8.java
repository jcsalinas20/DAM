import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String frase = "";
		String buscar = "hola";
 
		System.out.println("Introduce una frase:");
		frase = lector.nextLine();
		String[] cadena=frase.split(" ");
		
		for (int i = 0; i < cadena.length; i++) {
			String letra=String.valueOf(cadena[i]);
			
			if (buscar.equalsIgnoreCase(letra)) {
				System.out.println("La palabra \"hola\" se encuentra en la posicion["+i+"]");
			}
		}
		
		lector.close();
	}
}

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce la primera frase: ");
		String frase1 = lector.nextLine();
		System.out.println("Introduce la segunda frase: ");
		String frase2 = lector.nextLine();
		
		if (frase1.equalsIgnoreCase(frase2)) {
			System.out.println("La frase1 es igual a la frase2.");
		}else {
			System.out.println("La frase1 no es igual a la frase2.");
		}


		lector.close();
	}

}

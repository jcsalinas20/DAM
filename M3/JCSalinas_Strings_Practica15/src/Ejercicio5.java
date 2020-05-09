import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String frase="";
		
		System.out.println("Introduce una frase: ");
		frase=lector.nextLine();
		
		String[] palabras=frase.split(" ");
		
		System.out.println("La frase tiene "+palabras.length+" palabras.");
		
		lector.close();
	}

}

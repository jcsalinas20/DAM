import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String frase="";
		
		System.out.println("Introduce una frase:");
		frase=lector.nextLine();
		
		System.out.println(frase.replaceAll("hola", "bye"));
		
		lector.close();
	}

}

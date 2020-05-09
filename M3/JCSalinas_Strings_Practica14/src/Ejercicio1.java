import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String cadena= new String("");
		
		System.out.println("Introduce una frase para saber su longitud:");
		cadena=lector.nextLine();
		
		System.out.print("La longitud es "+cadena.length());
		lector.close();
	}
}

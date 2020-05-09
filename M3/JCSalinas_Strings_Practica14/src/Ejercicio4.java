import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String cadena=new String();
		
		System.out.println("Introduce tu frase:");
		cadena=lector.nextLine();
		
		for (int i =0; i<cadena.length();i++) {
			if (i%2!=0) {
				System.out.println("Posicon "+i+": "+cadena.charAt(i));
			}
		}
		
		lector.close();
	}

}

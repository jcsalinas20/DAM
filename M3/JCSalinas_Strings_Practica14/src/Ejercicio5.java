import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String[] palabras= new String[5];

		for (int i=0; i<palabras.length;i++) {
			System.out.println("Introduce texto:");
			palabras[i]=lector.next();
			lector.nextLine();
		}
		
		for (int i =0; i<palabras.length;i++) {
			System.out.println("Palabra de la posicion["+i+"]: "+palabras[i]);
		}
		lector.close();
	}

}

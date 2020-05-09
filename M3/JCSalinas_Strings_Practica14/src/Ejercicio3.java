import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String cadena1= new String();
		String cadena2= new String();
		
		System.out.println("Introduce el primer trozo de la frase:");
		cadena1=lector.nextLine();
		System.out.println("Introduce el segundo trozo de la frase:");
		cadena2=lector.nextLine();
		
		System.out.println(cadena1.concat(cadena2));
		lector.close();
	}

}

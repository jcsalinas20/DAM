import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String frase1="";
		String frase2="";
		
		System.out.println("Introduce el primer trozo de frase: ");
		frase1=lector.nextLine();
		System.out.println("Introduce el segundo trozo de frase: ");
		frase2=lector.nextLine();
		
		System.out.println(frase1.concat(frase2));
		
		lector.close();
	}

}

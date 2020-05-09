import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String[] palabras=new String[2];
		String auxiliar="";
		
		System.out.println("Introduce 2 palabras");
		for (int i=0; i<palabras.length;i++) {
			palabras[i]=lector.next();
		}
		
		for (int i = 1; i <= palabras.length; i++) {
            for (int j = 0; j < palabras.length - i; j++) {
                if (palabras[j].compareTo(palabras[j + 1]) > 0) {
                	auxiliar = palabras[j];
                	palabras[j] = palabras[j + 1];
                	palabras[j + 1] = auxiliar;
                }
            }
        }
		
		System.out.println("Palabras Ordenadas");
		for (int i=0; i<palabras.length;i++) {
			System.out.println(palabras[i]);
		}
		
		lector.close();
	}
}

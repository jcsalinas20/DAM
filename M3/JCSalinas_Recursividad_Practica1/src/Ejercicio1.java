import java.util.Scanner;

public class Ejercicio1 {

	public static int dividir(int num, int restador) {
		if (restador <= num) {
			return dividir(num - restador, restador) + 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.print("Introduce un numero: ");
		int num = lector.nextInt();
		System.out.print("Introduce el numeros con el que vamos a restar: ");
		int restador = lector.nextInt();
		
		System.out.println("Resultado: " + dividir(num, restador));

		System.out.println("El Programa ha acabado.");
		
		lector.close();
	}

}

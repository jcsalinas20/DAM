import java.util.Scanner;

public class Ejercicio5 {

	public static int ruso(int numDividir, int numMultiplicar) {
		if (numDividir == 1) {
			return numMultiplicar;
		}
		else if (numDividir%2==1) {
			return numMultiplicar+ruso(numDividir/2,numMultiplicar*2);
		}
		else {
			System.out.println();
			return ruso(numDividir/2,numMultiplicar*2);
		}
		
	}

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce el numero a dividir: ");
		int numDividir = lector.nextInt();
		System.out.println("Introduce el numero a multiplicar: ");
		int numMultiplicar = lector.nextInt();

		System.out.println("Resultado final: "+ruso(numDividir, numMultiplicar));

		lector.close();
	}

}

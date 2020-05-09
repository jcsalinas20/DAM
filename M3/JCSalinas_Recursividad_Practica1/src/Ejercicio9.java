import java.util.Scanner;

public class Ejercicio9 {
	
	public static int combinatorios(int n, int k) {
		int resultado = 0;
		if (k == n || k == 0) {
			return 1;
		} else {
			resultado = combinatorios(n - 1, k - 1) + combinatorios(n - 1, k);
			return resultado;
		}
	}

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);

		System.out.print("Introduce un numero para N: ");
		int n=lector.nextInt();
		System.out.print("Introduce un numero para K: ");
		int k=lector.nextInt();
		
		System.out.println("Resultado: " + combinatorios(n, k));
		
		lector.close();
	}

}

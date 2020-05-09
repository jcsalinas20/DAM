import java.util.Scanner;

public class Ejercicio6 {

	public static int potencias(int potencia, int elevado, int contador) {
		if (contador <= elevado) {
			return potencias(potencia * elevado, elevado, contador + 1);
		} else {
			return potencia;
		}
	}

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		int contador = 1;

		System.out.print("Introduce la potencia: ");
		int potencia=lector.nextInt();
		System.out.print("Introduce el numero elevado: ");
		int elevado=lector.nextInt();
		System.out.println("Numero introducido: "+potencia+" elevado a "+elevado);
		
		System.out.println("Resultado: " + potencias(potencia, elevado, contador));
		
		lector.close();
	}

}

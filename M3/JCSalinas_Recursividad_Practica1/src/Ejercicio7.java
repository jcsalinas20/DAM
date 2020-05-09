import java.util.Scanner;

public class Ejercicio7 {

	public static int productos(int producto, int contador) {
		if (contador>0) {
			return productos(producto+producto, contador-1);
		}else {
			return producto;
		}
	}
	
	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		
		System.out.println("Ingresa 2 numeros: ");
		int producto=lector.nextInt();
		int contador=lector.nextInt();
		
		System.out.println("El producto es: "+productos(producto, contador));
		
		lector.close();		
	}

}

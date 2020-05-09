
public class Main {

	public static int contador = 0;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Contador al principio del programa: " + contador);// Mensaje principal

		Hilo hilo1 = new Hilo();
		hilo1.setName("1");
		Hilo hilo2 = new Hilo();
		hilo2.setName("2");
		Hilo hilo3 = new Hilo();
		hilo3.setName("3");
		Hilo hilo4 = new Hilo();
		hilo4.setName("4");

		hilo1.start();// inicia el hilo1
		hilo2.start();// inicia el hilo2
		hilo3.start();// inicia el hilo3
		hilo4.start();// inicia el hilo4

	}

}

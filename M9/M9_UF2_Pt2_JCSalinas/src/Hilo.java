
public class Hilo extends Thread {

	@Override
	public void run() {
		Contador.uso();// llamar al metodo synchronized
	}

}

class Contador {
	static synchronized void uso() {
		for (int i = 0; i < 5000; i++) {// comienza el for
			Main.contador++;
		}
		Thread t = Thread.currentThread();
		System.out.println("\nHilo " + t.getName() + " finalizado. Recuento: " + Main.contador);
	}
}
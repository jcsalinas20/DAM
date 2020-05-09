
public class Cliente extends Thread {

	@Override
	public void run() {
		super.run();

		int numEntradas = (int) (Math.random() * 5 + 1);// numero de entradas del cliente

		Thread t = Thread.currentThread();
		// mostrar cuantas entradas tiene el cliente
		System.out.println("\n***" + t.getName() + " numero de entradas: " + numEntradas + "***");

		int entrada = 1;
		while (entrada < numEntradas + 1) {
			try {
				sleep(1000); // el cliente se piensa el asiento de la entrada
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int asiento = (int) (Math.random() * 50 + 1);// generar el numero del asiento del 1 al 50

			// si la posicion del asiento es 0 es que aun no ha sido comprada
			if (Main.entradas[asiento - 1] == 0) {
				System.out.println(t.getName() + " Entrada: " + entrada + ", Asiento: " + asiento);

				// aquí resto 1 porque si se genera el numero del 1 al 50 significa que 1 es 0
				// y 50 es 49 por las posiciones del array
				Main.entradas[asiento - 1]++;

				entrada++;// pasamos a la siguiente estrada
			}

		}
	}
}

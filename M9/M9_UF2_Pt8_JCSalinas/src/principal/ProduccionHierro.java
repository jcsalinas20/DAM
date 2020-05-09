package principal;

public class ProduccionHierro implements Runnable {

	public void run() {
		while (true) {
			try {
				Thread.sleep(Main.minero.getVelocidad());// Tiempo que tarda en sacar el hierro

				synchronized (Main.almacenHierro) {
					if (Main.almacenHierro.getUnidades() == Main.almacenHierro.getMaxUnidades()) {
						Main.almacenHierro.wait();// Se ha llegado a la capacidad maxima, se para la producción de hierro
					} else {
						Main.almacenHierro.sumarUnidad();// Se suma 1 al almacen de hierro
						Main.almacenHierro.notify();// Se reanuda la producción de herramientas

						System.out.println("*Hierro: " + Main.almacenHierro.getUnidades() + " - Herramientas: "
								+ Main.almacenHerramientas.getUnidades());
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

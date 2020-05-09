package principal;

public class ProduccionHerramientas implements Runnable {

	public void run() {
		while (true) {
			try {
				// Tiempo que tarda en crear la herramienta
				Thread.sleep(Main.herrero.getVelocidad());

				synchronized (Main.almacenHierro) {
					if (Main.almacenHierro.getUnidades() < 2) {
						Main.almacenHierro.wait();// Se para la producción de herraminetas por falta de hierro
					} else {
						Main.almacenHierro.restarUnidad();// Se resta 2 de hierro
						Main.almacenHierro.notify();// Se reanuda la producción de hierro
					}
				}

				synchronized (Main.almacenHerramientas) {
					if (Main.almacenHerramientas.getUnidades() == Main.almacenHerramientas.getMaxUnidades()) {
						Main.almacenHerramientas.wait();// Se ha llegado a la capacidad maxima, se para la producción de herramientas
					} else {
						Main.almacenHerramientas.sumarUnidad();// Se crea y se suma una herramineta al almacen
						Main.almacenHerramientas.notify();// El tren se reanuda y mira haber si ya hay 5 herramientas para poder llevarlas

						System.out.println("Hierro: " + Main.almacenHierro.getUnidades() + " - *Herramientas: "
								+ Main.almacenHerramientas.getUnidades());
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


public class Threads {

	public static void main(String[] args) {
		
		//Bucle de 5
		for (int i = 1; i <= 5; i++) {
			Hilo hilo = new Hilo("Hola mundo " + i);
			hilo.start();// comienzo de Thread
		}
	}

}

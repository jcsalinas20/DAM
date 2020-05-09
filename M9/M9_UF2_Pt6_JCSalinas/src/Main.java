import java.util.Arrays;

public class Main {

	// array donde se guardan las entradas
	public static int[] entradas = new int[50];

	public static void main(String[] args) throws InterruptedException {
		// declaracion de todos los clientes
		Cliente cliente1 = new Cliente();
		cliente1.setName("Cliente 1");
		Cliente cliente2 = new Cliente();
		cliente2.setName("Cliente 2");
		Cliente cliente3 = new Cliente();
		cliente3.setName("Cliente 3");
		Cliente cliente4 = new Cliente();
		cliente4.setName("Cliente 4");
		Cliente cliente5 = new Cliente();
		cliente5.setName("Cliente 5");
		Cliente cliente6 = new Cliente();
		cliente6.setName("Cliente 6");
		Cliente cliente7 = new Cliente();
		cliente7.setName("Cliente 7");
		Cliente cliente8 = new Cliente();
		cliente8.setName("Cliente 8");
		Cliente cliente9 = new Cliente();
		cliente9.setName("Cliente 9");
		Cliente cliente10 = new Cliente();
		cliente10.setName("Cliente 10");

		// los clientes empiezan a comprar las entradas
		cliente1.start();
		cliente2.start();
		cliente3.start();
		cliente4.start();
		cliente5.start();
		cliente6.start();
		cliente7.start();
		cliente8.start();
		cliente9.start();
		cliente10.start();

		// los clientes finalizan la compra de las entradas
		cliente1.join();
		cliente2.join();
		cliente3.join();
		cliente4.join();
		cliente5.join();
		cliente6.join();
		cliente7.join();
		cliente8.join();
		cliente9.join();
		cliente10.join();

		// total entradas vendidas
		System.out.println("\n" + Arrays.toString(entradas));
	}

}


public class Hilo extends Thread {

	private String mensaje;// variable del menasaje
	
	public Hilo(String mensaje) {
		this.mensaje = mensaje;// guardar el mensaje
	}

	@Override
	public void run() {
		System.out.println(mensaje);// Mostrar el mensaje
	}

}

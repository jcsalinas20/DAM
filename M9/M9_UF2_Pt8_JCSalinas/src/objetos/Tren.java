package objetos;

public class Tren {

	int velocidad;
	int capacidadTren;

	public Tren(int velocidad, int capacidadTren) {
		this.velocidad = velocidad;
		this.capacidadTren = capacidadTren;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getCapacidadTren() {
		return capacidadTren;
	}

	public void setCapacidadTren(int capacidadTren) {
		this.capacidadTren = capacidadTren;
	}

}

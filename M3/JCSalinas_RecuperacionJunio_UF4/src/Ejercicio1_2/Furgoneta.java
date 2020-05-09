package Ejercicio1_2;

public class Furgoneta extends Vheicle {

	Furgoneta f = null;
	float precio;
	int km;

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = CalcularPrecio.calcularPrecio(precio, f);
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public Furgoneta(String matricula, String marcaModel, String combustible, int km, float precio) {
		super(matricula, marcaModel, combustible);
		this.km = km;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Furgoneta \n" + "\tMatricula: " + matricula + "\n\tMarca Model: " + marcaModel + "\n\tPreu: " + precio;
	}

	public Furgoneta() {
		super();
	}

}

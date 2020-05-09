package Ejercicio1_2;

public class Turisme extends Vheicle {

	Turisme t = null;
	float precio;
	int km;

	@Override
	public String toString() {
		return "Turisme \n" + "\tMatricula: " + matricula + "\n\tMarca Model: " + marcaModel + "\n\tPreu: " + precio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = CalcularPrecio.calcularPrecio(precio, t);
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public Turisme(String matricula, String marcaModel, String combustible, int km, float precio) {
		super(matricula, marcaModel, combustible);
		this.km = km;
		this.precio = precio;
	}

	public Turisme() {
		super();
	}

}

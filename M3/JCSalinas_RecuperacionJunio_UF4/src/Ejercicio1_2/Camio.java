package Ejercicio1_2;

public class Camio extends Vheicle {

	Camio c = null;
	Conductor conductor = Main.conductor1;
	Mossos mo = Main.m1;

	@Override
	public String toString() {
		return "Camion \n\tMatricula: " + matricula + "\n\tConductor: \n\t" + conductor.getNomeni() + ", dni: "
				+ conductor.getDni() + ", Tarifa: " + conductor.getTarifa() + "\n\tmozos: \n\t   " + mo.getNomeni()
				+ ", dni: " + mo.getDni() + "\n\tprecio=" + precio;
	}

	float precio;
	int km;
	int kg;

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = CalcularPrecio.calcularPrecio(precio, c);
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public Camio(String matricula, String marcaModel, String combustible, int km, float precio, int kg) {
		super(matricula, marcaModel, combustible);
		this.km = km;
		this.precio = precio;
		this.kg = kg;
	}

	public Camio() {
		super();
	}

}

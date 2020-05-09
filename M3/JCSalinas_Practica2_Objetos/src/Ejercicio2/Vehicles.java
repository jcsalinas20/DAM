package Ejercicio2;


public class Vehicles {
	protected int numOcupantes;
	protected int numRuedas;
	protected String fechaMatriculacion;
	protected int numPuertas;
	protected String tipoCoche;//todoterreno, familiar...

	public Vehicles(int numOcupantes, int numRuedas, String fechaMatriculacion, int numPuertas, String tipoCoche) {
		super();
		this.numOcupantes = numOcupantes;
		this.numRuedas = numRuedas;
		this.fechaMatriculacion = fechaMatriculacion;
		this.numPuertas = numPuertas;
		this.tipoCoche = tipoCoche;
	}

	public static void mostrarInfo(Vehicles[] v, int i) {
		System.out.println("Vehiculo" + (i + 1));

		System.out.print("\nFecha de matriculacion: ");
		System.out.println(v[i].getFechaMatriculacion());
		System.out.print("Numero de Ocupantes: ");
		System.out.println(v[i].getNumOcupantes());
		System.out.print("Numero de ruedas: ");
		System.out.println(v[i].getNumRuedas());
		System.out.print("Numero de Puertas: ");
		System.out.println(v[i].getNumPuertas());
		System.out.print("Tipo de coche(familiar, todoterreno...): ");
		System.out.println(v[i].getTipoCoche());
		System.out.println("\n");
	}
	
	public int getNumOcupantes() {
		return numOcupantes;
	}

	public void setNumOcupantes(int numOcupantes) {
		this.numOcupantes = numOcupantes;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public String getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(String fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public String getTipoCoche() {
		return tipoCoche;
	}

	public void setTipoCoche(String tipoCoche) {
		this.tipoCoche = tipoCoche;
	}








}

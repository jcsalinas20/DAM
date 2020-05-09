package Ejercicio3;

public class Vehicles {
	protected int numOcupantes;
	protected int numRuedas;
	protected String fechaMatriculacion;
	protected int numPuertas;
	protected String tipoCoche;// todoterreno, familiar...
	protected String vehiculo;

	public Vehicles(int numOcupantes, int numRuedas, String fechaMatriculacion, int numPuertas, String tipoCoche,
			String vehiculo) {
		super();
		this.numOcupantes = numOcupantes;
		this.numRuedas = numRuedas;
		this.fechaMatriculacion = fechaMatriculacion;
		this.numPuertas = numPuertas;
		this.tipoCoche = tipoCoche;
		this.vehiculo = vehiculo;
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
		System.out.print("Vehiculo: ");
		System.out.println(v[i].getVehiculo());
		System.out.println("\n");
	}
	
	public static void queVehiculoEs(Vehicles[] v, int i) {
		if (v[i].numRuedas > 0) {
			if (v[i].numRuedas <= 3) {
				v[i].vehiculo="Moto";
			}else if (v[i].numRuedas == 4) {
				if (v[i].numPuertas == 5) {
					v[i].vehiculo="Coche";
				}else if (v[i].numPuertas == 3){
					if (v[i].numOcupantes == 5) {
						v[i].vehiculo="Coche";
					}else if (v[i].numOcupantes == 3) {
						v[i].vehiculo="Camion o Furgoneta";
					}else{
						v[i].vehiculo="Desconocido";
					}
				}
				else {
					v[i].vehiculo="Desconocido";
				}
			}else if (v[i].numRuedas > 4) {
				v[i].vehiculo="Trailer";
			}
			else {
				v[i].vehiculo="Desconocido";
			}
		} else {
			if (v[i].numOcupantes <= 2) {
				v[i].vehiculo="Moto acuatica";
			}else if (v[i].numOcupantes <= 4) {
				v[i].vehiculo="Lancha";
			}else if (v[i].numOcupantes <= 10) {
				v[i].vehiculo="Bote acuatico";
			}else {
				v[i].vehiculo="Desconicido";
			}
		}
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

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

}

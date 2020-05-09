package Ejercicio1_2;

public class Conductor {

	String nomeni;
	String dni;
	int tarifa;

	public String getNomeni() {
		return nomeni;
	}

	public void setNomeni(String nomeni) {
		this.nomeni = nomeni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public Conductor(String nomeni, String dni, int tarifa) {
		super();
		this.nomeni = nomeni;
		this.dni = dni;
		this.tarifa = tarifa;
	}

	public Conductor() {
		// TODO Auto-generated constructor stub
	}

}

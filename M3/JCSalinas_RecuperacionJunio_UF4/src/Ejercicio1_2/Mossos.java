package Ejercicio1_2;

import java.util.ArrayList;

public class Mossos {

	static ArrayList<Mossos> mos = new ArrayList<Mossos>();
	String nomeni;
	String dni;

	public Mossos(String nomeni, String dni) {
		super();
		this.nomeni = nomeni;
		this.dni = dni;
	}

	public Mossos() {
		// TODO Auto-generated constructor stub
	}

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

}

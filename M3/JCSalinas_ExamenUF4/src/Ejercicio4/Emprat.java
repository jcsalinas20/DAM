package Ejercicio4;

import java.util.ArrayList;

public class Emprat {
	protected String dni;
	protected String nom;
	protected String cognom;
	protected int any;

	public void imprimir(ArrayList<Emprat> emp) {
		int cont = 0;
		for (Object i : emp) {
			System.out.print(emp.get(cont).getNom());
			System.out.print(" " + emp.get(cont).getCognom());
			System.out.print(",DNI: " + emp.get(cont).getDni());
			System.out.println(", des de " + emp.get(cont).getAny());
			cont++;
		}
	}

	public Emprat(String dni, String nom, String cognom, int any) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.cognom = cognom;
		this.any = any;
	}

	public Emprat() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

}

class EAsalario extends Emprat {
	protected int numAnys;

	public EAsalario(String dni, String nom, String cognom, int any) {
	}

	public EAsalario() {
	}

	public int getNumAnys() {
		return numAnys;
	}

	public void setNumAnys(int numAnys) {
		this.numAnys = numAnys;
	}

}

class EComision extends Emprat {
	protected int salarioFinal = 750;

	public EComision(String dni, String nom, String cognom, int any) {
	}

	public EComision() {
	}

	public int getSalarioFinal() {
		return salarioFinal;
	}

	public void setSalarioFinal(int salarioFinal) {
		this.salarioFinal = salarioFinal;
	}
}
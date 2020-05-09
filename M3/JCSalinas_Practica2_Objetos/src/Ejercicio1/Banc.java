package Ejercicio1;

public class Banc {
	protected int nombreCompte;
	protected String nom;
	protected int deposit;
	protected static int saldo;

	public Banc(int nombreCompte, String nom, int deposito, int saldo) {
		this.nombreCompte = nombreCompte;
		this.nom = nom;
		this.deposit = deposito;
		Banc.saldo = saldo;
	}

	public static void ingresarDinero(int dinero) {
		if (dinero > 0) {
			saldo = saldo + dinero;
			System.out.println("Tu saldo actual es " + saldo + ".\n");
		} else {
			System.out.println("Error.");
		}
	}

	public static void retirarDinero(int dinero) {
		if (dinero > 0 && dinero < saldo) {
			saldo = saldo - dinero;
			System.out.println("Tu saldo actual es " + saldo + ".\n");
		} else {
			System.out.println("Error.");
		}
	}

	public int getNombreCompte() {
		return nombreCompte;
	}

	public void setNombreCompte(int nombreCompte) {
		this.nombreCompte = nombreCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		Banc.saldo = saldo;
	}

}

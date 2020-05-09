package ejercicio.POObasico.Cajero;

public class Banco {

	int numCompte;
	String nomClient;
	int deposit;
	int saldo;

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
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

	public void setSaldo(int saldo, int opcion) {
		if (opcion == 3 && saldo > 0) {
			this.saldo += saldo;
		} else if (opcion == 4 && saldo > 0) {
			this.saldo -= saldo;
		}
		System.out.println(this.saldo);
	}

	@Override
	public String toString() {
		return "Banco [numCompte=" + numCompte + ", nomClient=" + nomClient + ", deposit=" + deposit + ", saldo="
				+ saldo + "]";
	}

	public Banco(int numCompte, String nomClient, int deposit, int saldo) {
		super();
		this.numCompte = numCompte;
		this.nomClient = nomClient;
		this.deposit = deposit;
		this.saldo = saldo;
	}

}

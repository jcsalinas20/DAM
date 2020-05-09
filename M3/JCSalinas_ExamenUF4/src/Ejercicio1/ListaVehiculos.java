package Ejercicio1;

import java.util.ArrayList;

public class ListaVehiculos implements Vehicles, Comparable<ListaVehiculos> {
	ArrayList<ListaVehiculos> vehiculo = new ArrayList<ListaVehiculos>();
	int numeroRodes;
	int numeroPlaces;
	int velocidadActual = 0;
	String matricula;
	int velocidadMaxima;
	int consum;

	public void eliminar(ListaVehiculos lv, String opcion) {
		for (int i = 0; i < vehiculo.size(); i++) {
			if (opcion.equalsIgnoreCase(vehiculo.get(i).getMatricula())) {
				System.out.println(vehiculo.remove(i));
			}
		}
	}

	public void afegir(ListaVehiculos lv) {
		System.out.println("Numero de ruedas: ");
		int valor = Main.lector.nextInt();
		lv.setNumeroRodes(valor);
		System.out.println("Numero de places: ");
		valor = Main.lector.nextInt();
		lv.setNumeroPlaces(valor);
		lv.setVelocidadActual(0);
		System.out.println("Matricula: ");
		String matricula = Main.lector.next();
		lv.setMatricula(matricula);
		lv.setVelocidadMaxima(0);
		System.out.println("Consum: ");
		valor = Main.lector.nextInt();
		lv.setConsum(valor);
		vehiculo.add(lv);
	}

	public void mostrarVelocidad(String opcion) {
		for (int i = 0; i < vehiculo.size(); i++) {
			if (opcion.equalsIgnoreCase(vehiculo.get(i).getMatricula())) {
				System.out.println("velocidad actual del vehiculo " + vehiculo.get(i).getMatricula() + ": "
						+ vehiculo.get(i).getVelocidadActual());
			}
		}
	}

	public int canviar_marxa(int i, int marcha) {
		if (i <= 30) {
			return marcha = 1;
		} else if (i >= 30 && i < 61) {
			return marcha = 2;
		} else if (i >= 61 && i < 91) {
			return marcha = 3;
		} else if (i >= 91 && i < 141) {
			return marcha = 4;
		} else {
			return marcha = 5;
		}
	}

	public int acelerar(int i) {
		i = i + 20;
		if (this.velocidadMaxima < velocidadActual) {
			this.velocidadMaxima = velocidadActual;
		}
		return i;
	}

	public int frenar(int i) {
		i = i - 10;
		return i;
	}

	public ListaVehiculos(int numeroRodes, int numeroPlaces, int velocidadActual, String matricula, int velocidadMaxima,
			int consum) {
		super();
		this.numeroRodes = numeroRodes;
		this.numeroPlaces = numeroPlaces;
		this.velocidadActual = velocidadActual;
		this.matricula = matricula;
		this.velocidadMaxima = velocidadMaxima;
		this.consum = consum;
	}

	public ListaVehiculos() {
		super();
	}

	public int getNumeroRodes() {
		return numeroRodes;
	}

	public void setNumeroRodes(int numeroRodes) {
		this.numeroRodes = numeroRodes;
	}

	public int getNumeroPlaces() {
		return numeroPlaces;
	}

	public void setNumeroPlaces(int numeroPlaces) {
		this.numeroPlaces = numeroPlaces;
	}

	public int getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public int getConsum() {
		return consum;
	}

	public void setConsum(int consum) {
		this.consum = consum;
	}

	@Override
	public int compareTo(ListaVehiculos o) {
		return o.matricula.compareTo(this.matricula);
	}

}

class motocarro extends ListaVehiculos {

	public motocarro(int numeroRodes, int numeroPlaces, int velocidadActual, String matricula, int velocidadMaxima,
			int consum) {
		super(numeroRodes, numeroPlaces, velocidadActual, matricula, velocidadMaxima, consum);
		// TODO Auto-generated constructor stub
	}

}

class turisme extends ListaVehiculos {

	public turisme(int numeroRodes, int numeroPlaces, int velocidadActual, String matricula, int velocidadMaxima,
			int consum) {
		super(numeroRodes, numeroPlaces, velocidadActual, matricula, velocidadMaxima, consum);
		// TODO Auto-generated constructor stub
	}

}

class motocicletes extends ListaVehiculos {

	public motocicletes(int numeroRodes, int numeroPlaces, int velocidadActual, String matricula, int velocidadMaxima,
			int consum) {
		super(numeroRodes, numeroPlaces, velocidadActual, matricula, velocidadMaxima, consum);
		// TODO Auto-generated constructor stub
	}

}
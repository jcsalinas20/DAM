package Practica2;

public class Ejercicio1 {

	public static void main(String[] args) {
		Ejercicio1 programa = new Ejercicio1();
		programa.inici();
	}

	public void inici() {
		String nom = diaDeLaSetmana(3);
		System.out.println("El tercer dia de la setmana és " + nom);
		nom = diaDeLaSetmana(5);
		System.out.println("El cinquè dia de la setmana és " + nom);
		nom = diaDeLaSetmana(15);
		System.out.println("El quinzè dia de la setmana és " + nom);
	}

	public String diaDeLaSetmana(int numDia) {
		String diaSetmana = "";
		if (numDia == 1) {
			diaSetmana = "Dilluns";
		} else if (numDia == 2) {
			diaSetmana = "Dimarts";
		} else if (numDia == 3) {
			diaSetmana = "Dimecres";
		} else if (numDia == 4) {
			diaSetmana = "Dijous";
		} else if (numDia == 5) {
			diaSetmana = "Divendres";
		} else if (numDia == 6) {
			diaSetmana = "Disabte";
		} else if (numDia == 7) {
			diaSetmana = "Diumenge";
		} else {
			diaSetmana = "(No existeix aquest dia)";
		}
		return diaSetmana;
	}

}

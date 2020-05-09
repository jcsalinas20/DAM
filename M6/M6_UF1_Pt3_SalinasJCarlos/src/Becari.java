import java.util.ArrayList;

public class Becari {
	static ArrayList<Becari> listaBecarios = new ArrayList<Becari>();// Declaracion de ArrayList de Becari

/***DECLARACIONES DE VARIABLES***/
	String nombreApellidos;
	char sexe;
	int edad;
	int numSuspendidos;
	boolean resicenciaFamiliar;
	float ingresos;

//	Metodo toString
	@Override
	public String toString() {
		return nombreApellidos + "-" + sexe + "-" + edad + "-" + numSuspendidos + "-" + resicenciaFamiliar + "-"
				+ +ingresos + "\n";
	}

//	Metodo para mostrar los becarios del ArrayList
	public static void mostrarBecarios() {
		System.out.println("\n\nLista de becarios");
		for (int i = 0; i < Becari.listaBecarios.size(); i++) {
			System.out.println("Nombre y Apellidos: " + listaBecarios.get(i).getNombreApellidos() + ", Sexo: "
					+ listaBecarios.get(i).getSexe() + ", Edad: " + listaBecarios.get(i).getEdad()
					+ ", Numero de Suspendidas: " + listaBecarios.get(i).getNumSuspendidos() + ", Resicencia Familiar: "
					+ listaBecarios.get(i).getResicenciaFamiliar() + ", Ingresos: " + listaBecarios.get(i).getIngresos()
					+ ".");
		}
		System.out.println("\n");
	}

/**********DECLARACION DE GETTERS AND SETTERS**********/
	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		if (sexe == 'H' || sexe == 'M' || sexe == 'h' || sexe == 'm') {
			this.sexe = Character.toUpperCase(sexe);
		} else {
//			Si no es una "H" o una "M" se resta el contador
			Main.contador--;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad > 19 && edad < 61) {
			this.edad = edad;
		} else {
//			Si la edad no esta entre 20-60 se resta el contador
			Main.contador--;
		}
	}

	public int getNumSuspendidos() {
		return numSuspendidos;
	}

	public void setNumSuspendidos(int numSuspendidos) {
		if (numSuspendidos >= 0 && numSuspendidos < 5) {
			this.numSuspendidos = numSuspendidos;
		} else {
//			Si las suspendidas no estan entre 0-4 se resta el contador
			Main.contador--;
		}
	}

	public boolean getResicenciaFamiliar() {
		return resicenciaFamiliar;
	}

	public void setResicenciaFamiliar(boolean resicenciaFamiliar) {
		this.resicenciaFamiliar = resicenciaFamiliar;
	}

	public float getIngresos() {
		return ingresos;
	}

	public void setIngresos(float ingresos) {
		if (ingresos > 0) {
			this.ingresos = ingresos;
		} else {
//			Si los ingresos no son superiores a 0 se resta el contador
			Main.contador--;
		}
	}

}

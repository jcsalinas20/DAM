
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Curs implements Serializable {
	private static final long serialVersionUID = 1L;
	Pt2 main = new Pt2();

	String key;// Guardar la key del HashMap(idCurs)
	String tutor;// Nombre del tutor

//	ArrayList para guardar los alumnos
	ArrayList<String> alumnes = new ArrayList<String>();

//	HashMap de la clase Modul
	HashMap<String, Modul> moduls = new HashMap<String, Modul>();

	@Override
	public String toString() {
		return "Tutor: " + tutor + ", Alumnes: " + alumnes + ", Moduls: " + moduls;
	}

//	Opcion 1 del segundo menu
//	Metodo para introducir el un String con el nombre del tutor
	public String introducirNombreTutor(String idCurs) {
		System.out.print("\nIntroduiex el nom del nou tutor: ");
		String tutor = main.lector.nextLine();
		return tutor;
	}

//	Opcion 2 y 3 del segundo menu
//	Metodo para introducir los nombres de los lumnos
	public String[] demanarElsAlumnes(String idCurs) {
		System.out.println("Introdueix els alumnes separats per \"-\"");
		String str = main.lector.nextLine();
		String[] alumnes = str.split("-");
		return alumnes;
	}

//	Opcion 4 y 6 del segundo menu
//	Metodo para introducir el numero y nombre del modulo
	public String demanarModul(String idCurs) {
		System.out.println("Introdueix el nom del Modul(Ej. M6: Acces a dades): ");
		String modul = main.lector.nextLine();
		return modul;
	}

	/***** GETTERS AND SETTERS *****/
	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}


import java.io.Serializable;
import java.util.ArrayList;

public class Modul implements Serializable {
	private static final long serialVersionUID = 1L;

	Pt2 main = new Pt2();

	String nom;// Nombre del modulo
	String profe;// Nombre del profesor

//	ArrayList para guardar las UFs
	ArrayList<String> ufs = new ArrayList<String>();

//	Metodo para mostrar las UFs
	public void printUFs() {
		System.out.print(main.idModul + ": ");
		for (int i = 0; i < ufs.size(); i++) {
			if (i == ufs.size() - 2) {
				System.out.print(ufs.get(i) + "\n");
			} else {
				System.out.print(ufs.get(i) + ", ");
			}
		}
	}

//	Metodo para mostrar el modulo
	public void printModul() {
		System.out.println(main.idModul + ": " + main.cursos.get(Pt2.idCurs).moduls.get(main.idModul).toString());
		System.out.println("\n");// Doble salto de linea
	}

//	Opcion 3 del tercer menu
//	Metodo para introducir las UFs
	public String afegirUFs(String idCurs, String idModul) {
		System.out.print("Introdueix totes les Ufs separades per \"-\": ");
		String UFs = main.lector.nextLine();// Guardar todas las Ufs en un solo String
		return UFs;
	}

//	Opcion 4 del tercer menu
//	Metodo para introducir el nombre de una UF
	public String canviarUF(String idCurs, String idModul) {
		System.out.println("Introdueix el nom de la UF que vols canviar(Ej. UF1: Persistencia en fitxers):");
		String uf = main.lector.nextLine();
		return uf;
	}

//	Opcion 5 del tercer menu
//	Metodo para introducir las UFs
	public String treureUFs(String idCurs, String idModul) {
		System.out.println("Introdueix totes les ufs que vols eliminar seperades amb \"-\"(uf1-uf2):");
		String ufsAEliminar = main.lector.nextLine();
		ufsAEliminar = main.convertirUpperCase(ufsAEliminar);
		return ufsAEliminar;
	}

	/***** GETTERS AND SETTERS *****/
	public ArrayList<String> getUfs() {
		return ufs;
	}

	@Override
	public String toString() {
		return nom + ", Profe: " + profe + ", UFs: " + ufs;
	}

	public void setUfs(ArrayList<String> ufs) {
		this.ufs = ufs;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getProfe() {
		return profe;
	}

	public void setProfe(String profe) {
		this.profe = profe;
	}

}

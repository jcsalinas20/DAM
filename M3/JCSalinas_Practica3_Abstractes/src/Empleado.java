
public abstract class Empleado {
	protected String nom;
	protected String ciutatOrigen;
	protected String puestoTrabajo;

	public Empleado(String nom, String ciutatOrigen, String puestoTrabajo) {
		super();
		this.nom = nom;
		this.ciutatOrigen = ciutatOrigen;
		this.puestoTrabajo = puestoTrabajo;
	}
	
	public static void mostrarInfo(Empleado[] emp, int i) {
		System.out.println(emp[i].getNom()+"\t\t"+emp[i].getCiutatOrigen()+"\t\t"+emp[i].getPuestoTrabajo());
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCiutatOrigen() {
		return ciutatOrigen;
	}

	public void setCiutatOrigen(String ciutatOrigen) {
		this.ciutatOrigen = ciutatOrigen;
	}

	public String getPuestoTrabajo() {
		return puestoTrabajo;
	}

	public void setPuestoTrabajo(String puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}	

}

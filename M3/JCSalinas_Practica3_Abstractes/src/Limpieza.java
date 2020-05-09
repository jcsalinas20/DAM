
public class Limpieza extends Empleado {
	protected int salari;

	public Limpieza(String nom, String ciutatOrigen, String puestoTrabajo, int salari) {
		super(nom, ciutatOrigen, puestoTrabajo);
		this.salari = salari;
	}

	public int getSalari() {
		return salari;
	}

	public void setSalari(int salari) {
		this.salari = salari;
	}	

}

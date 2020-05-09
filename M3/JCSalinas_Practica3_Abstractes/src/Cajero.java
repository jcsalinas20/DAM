
public class Cajero extends Empleado {
	protected int horasTrabajadas;
	protected int salari;
	
	public Cajero(String nom, String ciutatOrigen, String puestoTrabajo, int horasTrabajadas, int salari) {
		super(nom, ciutatOrigen, puestoTrabajo);
		this.horasTrabajadas = horasTrabajadas;
		this.salari = salari;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getSalari() {
		return salari;
	}

	public void setSalari(int salari) {
		this.salari = salari;
	}
	
	
	
}

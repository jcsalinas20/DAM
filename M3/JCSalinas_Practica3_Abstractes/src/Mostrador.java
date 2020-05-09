
public class Mostrador extends Empleado {
	protected int ventas;
	protected int salario;


	public Mostrador(String nom, String ciutatOrigen, String puestoTrabajo, int ventas, int salario) {
		super(nom, ciutatOrigen, puestoTrabajo);
		this.ventas = ventas;
		this.salario = salario;
	}


	public int getVentas() {
		return ventas;
	}


	public void setVentas(int ventas) {
		this.ventas = ventas;
	}


	public int getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}
	

}

package objetos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hijo {

	/*************************** VARIABLES *****************************/
	
	public static ArrayList<Hijo> guardarHijoTemp = new ArrayList<Hijo>();

	String id;
	String nombre;
	String apellidos;
	LocalDate fecha_nacimiento;
	char sexo;
	String talla;
	String pies;

	/************************* CONSTRUCTORES ***************************/
	
	public Hijo() {
		super();
	}

	public Hijo(String id, String nombre, String apellidos, LocalDate fecha_nacimiento, char sexo, String talla,
			String pies) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.talla = talla;
		this.pies = pies;
	}

	public Hijo(String nombre, String apellidos, LocalDate localDate, char sexo, String talla,
			String pies) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = localDate;
		this.sexo = sexo;
		this.talla = talla;
		this.pies = pies;
	}

	/************************ METODO TOSTRING **************************/
	
	@Override
	public String toString() {
		return "Hijo [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento="
				+ fecha_nacimiento + ", sexo=" + sexo + ", talla=" + talla + ", pies=" + pies + "]";
	}

	/********************** GETTERS AND SETTERS ************************/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getPies() {
		return pies;
	}

	public void setPies(String pies) {
		this.pies = pies;
	}

}

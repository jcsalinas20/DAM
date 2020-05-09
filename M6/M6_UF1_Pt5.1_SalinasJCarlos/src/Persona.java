import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	String nombreApellido;// Variable para guardar el nombre
	int edad;// Varible para guardar la edad

//	Contructor de la clase
	public Persona(String nombreApellido, int edad) {
		super();
		this.nombreApellido = nombreApellido;
		this.edad = edad;
	}

//	Setters and Getters de las variables
	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}

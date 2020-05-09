package ejercicio.CompareTo_Sort;

public class Personajes implements Comparable<Personajes> {

	String nombre;
	String distrito;
	int edad;
	boolean esTitan;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEsTitan() {
		return esTitan;
	}

	public void setEsTitan(boolean esTitan) {
		this.esTitan = esTitan;
	}

	public Personajes(String nombre, String distrito, int edad, boolean esTitan) {
		super();
		this.nombre = nombre;
		this.distrito = distrito;
		this.edad = edad;
		this.esTitan = esTitan;
	}

	@Override
	public String toString() {
		return "Personajes [nombre=" + nombre + ", distrito=" + distrito + ", edad=" + edad + ", esTitan=" + esTitan
				+ "]";
	}

	@Override
	public int compareTo(Personajes p) {
		if (Main.ordenacion.equalsIgnoreCase("nombre")) {
			return this.nombre.compareTo(p.nombre);
		} else if (Main.ordenacion.equalsIgnoreCase("edad")) {
			return this.edad - p.edad;
		} else if (Main.ordenacion.equalsIgnoreCase("objeto")) {
			return this.toString().compareTo(p.toString());
		}
		return 0;
	}

}

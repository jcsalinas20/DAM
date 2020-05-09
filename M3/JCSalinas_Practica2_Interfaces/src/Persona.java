
public class Persona implements Comparable<Persona> {
	protected String nombre;
	protected int altura;
	protected int edad;

	public Persona(String nombre, int altura, int edad) {
		super();
		this.nombre = nombre;
		this.altura = altura;
		this.edad = edad;
	}

	public Persona() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int compareTo(Persona o) {
		return o.altura - this.altura;
	}

}

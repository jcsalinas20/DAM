package Ejercicio1_2;

public class Vheicle implements Comparable<Vheicle>{

	String matricula;
	String marcaModel;
	String combustible;

	public Vheicle(String matricula, String marcaModel, String combustible) {
		super();
		this.matricula = matricula;
		this.marcaModel = marcaModel;
		this.combustible = combustible;
	}

	public Vheicle() {
		// TODO Auto-generated constructor stub
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarcaModel() {
		return marcaModel;
	}

	public void setMarcaModel(String marcaModel) {
		this.marcaModel = marcaModel;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		if (combustible.equalsIgnoreCase("super 98"))
			this.combustible = combustible;
		if (combustible.equalsIgnoreCase("super 95"))
			this.combustible = combustible;
		if (combustible.equalsIgnoreCase("gasoil"))
			this.combustible = combustible;
	}

	@Override
	public int compareTo(Vheicle o) {
		if (Main.ordenacion.equalsIgnoreCase("matricula")) {
			return this.matricula.compareTo(o.matricula);
		} else if (Main.ordenacion.equalsIgnoreCase("marca")) {
			return this.marcaModel.compareTo(o.marcaModel);
		}
		return 0;
	}
}

package ejercicio.ArrayList.Figuras;

public abstract class Figura {

	String color;
	double area;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void calcularArea(Figura f) {
		if (f.getClass().getSimpleName().equals("Cercle")) {
		}

	}
}

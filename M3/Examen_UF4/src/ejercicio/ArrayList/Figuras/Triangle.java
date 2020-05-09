package ejercicio.ArrayList.Figuras;

public class Triangle extends Figura{

	int base;
	int altura;

	public Triangle(int base, int altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Triangle [base=" + base + ", altura=" + altura + ", color=" + color + ", area=" + area + "]";
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
}

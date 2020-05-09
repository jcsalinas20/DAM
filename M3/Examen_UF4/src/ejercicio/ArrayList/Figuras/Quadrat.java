package ejercicio.ArrayList.Figuras;

public class Quadrat extends Figura{

	int costat;

	public Quadrat(int costat) {
		super();
		this.costat = costat;
	}

	@Override
	public String toString() {
		return "Quadrat [costat=" + costat + ", color=" + color + ", area=" + area + "]";
	}

	public int getCostat() {
		return costat;
	}

	public void setCostat(int costat) {
		this.costat = costat;
	}
	
}

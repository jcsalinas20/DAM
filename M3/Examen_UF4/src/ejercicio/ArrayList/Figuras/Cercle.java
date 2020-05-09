package ejercicio.ArrayList.Figuras;

public class Cercle extends Figura {

	int radi;

	public Cercle(int radi) {
		super();
		this.radi = radi;
	}

	@Override
	public String toString() {
		return "Cercle [radi=" + radi + ", color=" + color + ", area=" + area + "]";
	}

	public int getRadi() {
		return radi;
	}

	public void setRadi(int radi) {
		this.radi = radi;
	}

}

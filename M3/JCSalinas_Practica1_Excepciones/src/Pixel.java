
public class Pixel extends ColorRGB {
	protected int x;
	protected int y;
	ColorRGB color = new ColorRGB(r, g, b);

	public Pixel(int x, int y, int r, int g, int b) {
		super(r, g, b);
		this.x = x;
		this.y = y;
	}

	public void asignarPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void asignarPosicionX(int x) {
		this.x = x;
	}

	public void asignarPosicionY(int y) {
		this.y = y;
	}

	public int obtenerPosicion() {
		return x;
	}

	public int obtenerPosicionX() {
		return x;
	}

	public int obtenerPosicionY() {
		return y;
	}

}

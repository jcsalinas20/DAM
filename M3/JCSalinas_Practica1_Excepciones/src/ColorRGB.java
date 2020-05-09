import java.util.Arrays;

public class ColorRGB {
	int[] array = new int[3];
	int r;
	int g;
	int b;

	public ColorRGB(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public void asignarColor(int r, int g, int b) throws ColorRGBException {
		if ((r > 256 || r < 1) || (g > 256 || g < 1) || (b > 256 || b < 1)) {
			throw new ColorRGBException();
		}
		asignarColorR(r);
		asignarColorG(g);
		asignarColorB(b);

		this.array[0] = r;
		this.array[1] = g;
		this.array[2] = b;
	}

	public void asignarColorR(int r) throws ColorRGBException {
		if (r > 256 || r < 1) {
			throw new ColorRGBException();
		}
		this.r = r;
	}

	public void asignarColorG(int g) throws ColorRGBException {
		if (g > 256 || g < 1) {
			throw new ColorRGBException();
		}
		this.g = g;
	}

	public void asignarColorB(int b) throws ColorRGBException {
		if (b > 256 || b < 1) {
			throw new ColorRGBException();
		}
		this.b = b;
	}

	public String obtenerColor() {
		return Arrays.toString(array);
	}

	public int obtenerColorR() {
		return r;
	}

	public int obtenerColorG() {
		return g;
	}

	public int obtenerColorB() {
		return b;
	}

}

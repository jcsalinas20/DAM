package objetos;

public class AlmacenHerramientas {

	int maxUnidades;
	int unidades;

	public AlmacenHerramientas(int maxUnidades, int unidades) {
		this.maxUnidades = maxUnidades;
		this.unidades = unidades;
	}

	public int getMaxUnidades() {
		return maxUnidades;
	}

	public void setMaxUnidades(int maxUnidades) {
		this.maxUnidades = maxUnidades;
	}

	public int getUnidades() {
		return unidades;
	}

	public void sumarUnidad() {
		this.unidades++;
	}

	public void restarUnidad() {
		this.unidades -= 5;
	}
}

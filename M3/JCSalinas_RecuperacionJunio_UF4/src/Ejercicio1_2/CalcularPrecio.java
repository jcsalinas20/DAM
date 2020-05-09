package Ejercicio1_2;

public abstract class CalcularPrecio {
	static Conductor condu = new Conductor();
	static int contadorFurgo = 0;
	static int contadorTur = 0;
	static int contadorCam = 0;

	public static float calcularPrecio(float precio, Turisme t) {
		if (contadorTur == 0) {
			t = Main.t1;
		} else if (contadorTur == 1) {
			t = Main.t2;
		}
		if (t.km > 100) {
			if (t.combustible.equalsIgnoreCase("gasiol")) {
				precio += 0.1f;
			} else if (t.combustible.equalsIgnoreCase("super 98") || t.combustible.equalsIgnoreCase("super 95")) {
				precio += 0.15f;
			}
		}
		contadorTur++;
		return precio;
	}

	public static float calcularPrecio(float precio, Camio c) {
		if (contadorCam == 0) {
			c = Main.c1;
		} else if (contadorCam == 1) {
			c = Main.c2;
		}
		if (c.km > 100) {
			precio += 0.2f;
			precio += condu.getTarifa();
			precio += Mossos.mos.size() * 120;
			if (c.kg > 1000) {
				precio += (c.kg - 1000) * 0.2f;
			}
		}
		contadorCam++;
		return precio;
	}

	public static float calcularPrecio(float precio, Furgoneta f) {
		if (contadorFurgo == 0) {
			f = Main.f1;
		} else if (contadorFurgo == 1) {
			f = Main.f2;
		}
		if (f.km > 100) {
			if (f.combustible.equalsIgnoreCase("gasiol")) {
				precio += 0.15f;
			} else if (f.combustible.equalsIgnoreCase("super 98") || f.combustible.equalsIgnoreCase("super 95")) {
				precio += 0.2f;
			}
		}
		contadorFurgo++;
		return precio;
	}

}

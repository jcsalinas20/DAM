package vectores;

public class LetraDNI {

	public static void main(String[] args) {
		char[] letra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		String dni = "";
		int dniNumeros = 47894282;
		int numLetra = dniNumeros % 23;
		dni = "" + dniNumeros + letra[numLetra];

		System.out.println("DNI: " + dni);
	}

}

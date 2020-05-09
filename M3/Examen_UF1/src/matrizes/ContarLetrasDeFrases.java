package matrizes;

public class ContarLetrasDeFrases {

	public static void main(String[] args) {
		String frase = "Habia una vez un Dios que mato a toda su familia";
		System.out.println("Frase:  " + frase);

		System.out.println();
		String[] palabras = frase.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			char[] letras = palabras[i].toCharArray();
			System.out.println("Palabra \"" + palabras[i] + "\" tiene " + letras.length + " letras.");
		}
	}

}

package matrizes;

public class ContarVocales {

	public static void main(String[] args) {
		String frase = "Hola que tal, com estas?";
		System.out.println("FRASE: " + frase);
		System.out.println();

		int contadorA = 0, contadorE = 0, contadorI = 0, contadorO = 0, contadorU = 0;

		String[] caracteres = frase.split("");
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i].equalsIgnoreCase("a")) {
				contadorA++;
			} else if (caracteres[i].equalsIgnoreCase("e")) {
				contadorE++;
			} else if (caracteres[i].equalsIgnoreCase("i")) {
				contadorI++;
			} else if (caracteres[i].equalsIgnoreCase("o")) {
				contadorO++;
			} else if (caracteres[i].equalsIgnoreCase("u")) {
				contadorU++;
			}
		}
		System.out.println("Vocal A: " + contadorA);
		System.out.println("Vocal E: " + contadorE);
		System.out.println("Vocal I: " + contadorI);
		System.out.println("Vocal O: " + contadorO);
		System.out.println("Vocal U: " + contadorU);
	}

}

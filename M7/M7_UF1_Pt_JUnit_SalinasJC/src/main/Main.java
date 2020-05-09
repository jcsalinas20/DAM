package main;

public class Main {

	public String concatStrings(String str1, String str2) {
		return str1.concat(str2);
	}

	public int parImpar(int num) {
		return num % 2;
	}

	public int sumar(int num1, int num2) throws numeroNegativoException {
		if (num1 < 0 || num2 < 0) {
			throw new numeroNegativoException("No se pueden introducir numeros negativos.");
		}
		return num1 + num2;
	}
	
}

class numeroNegativoException extends Exception {
	private static final long serialVersionUID = 1L;

	public numeroNegativoException(String msg) {
		super(msg);
	}

}


public class Ejercicio6 {

	public static void main(String[] args) {
		int inici = 1, fi = 20;

		System.out.println(valors(inici, fi));

	}

	public static int valors(int inici, int fi) {
		if (inici >= fi) {
			return inici;
		} else {
			System.out.println(valors(inici, fi - 1));
			return fi;
		}
	}

}

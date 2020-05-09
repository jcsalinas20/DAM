package estructurasRepititivas;

public class DivisoresDe200 {

	public static void main(String[] args) {
		int num = 200;
		System.out.println("Numero dado: " + num);

		System.out.print("Els divisores de " + num + " son: ");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

}

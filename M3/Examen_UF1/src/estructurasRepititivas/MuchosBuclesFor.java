package estructurasRepititivas;

public class MuchosBuclesFor {

	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();

		for (int i = 2; i < 21; i++) {
			System.out.print(i + "\t");
			i++;
		}
		System.out.println();

		for (int i = 20; i < 39; i++) {
			System.out.print(i + "\t");
			i++;
		}
		System.out.println();

		for (int i = 10; i < 31; i++) {
			System.out.print(i + "\t");
			i += 3;
		}
		System.out.println();

		for (int i = 40; i >= 0; i--) {
			System.out.print(i + "\t");
			i -= 4;
		}
		System.out.println();
	}

}

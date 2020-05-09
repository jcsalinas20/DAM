package estructurasRepititivas;

public class DibujarRectangulo {

	public static void main(String[] args) {
		int amplada = 5, alsada = 4;
		for (int i = 0; i < alsada; i++) {
			if (i == 0 || i == alsada - 1) {
				for (int j = 0; j < amplada; j++) {
					System.out.print("*");
				}
			} else {
				System.out.print("*");
				for (int j = 0; j < amplada - 2; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

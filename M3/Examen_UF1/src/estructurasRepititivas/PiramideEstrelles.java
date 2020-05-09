package estructurasRepititivas;

public class PiramideEstrelles {

	public static void main(String[] args) {
		int alsada = 5;
		int asteriscos = 0;
//		int asteriscos = 1;
		int espacios = alsada - 1;
		for (int i = 1; i <= alsada; i++) {
			for (int j = 0; j < espacios; j++) {
				System.out.print(" ");
			}
			espacios -= 1;
			for (int j = 0; j < asteriscos; j++) {
				System.out.print("*");
			}
			if (asteriscos == 0) {
				asteriscos++;
			} else {
				asteriscos += 2;
			}
			System.out.println();
		}
	}

}

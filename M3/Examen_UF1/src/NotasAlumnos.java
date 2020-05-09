
public class NotasAlumnos {

	public static void main(String[] args) {
		String[] nom = { "Zeus", "Eren", "Odin", "Gaia", "Thor", "Abel", "Otto", "Ares", "Kyra", "Iris", "Hera", "Ymir",
				"Clio", "Neon", "Hebi", "Amon", "Sobk", "Apis", "Aton", "Isis" };
		float[][] notas = new float[5][5];

		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				notas[i][j] = (float) (Math.random() * 10);
			}
		}

		System.out.println("Noms\tDibuix\tCatala\tCaste\tMates\tAngles\tMediana");
		for (int i = 0; i < notas.length; i++) {
			float mediana = 0;
			System.out.println("********************************************************");
			int nombre = (int) (Math.random() * 19);
			System.out.print(nom[nombre] + "\t");
			for (int j = 0; j < notas[i].length; j++) {
				System.out.printf("%.2f\t", notas[i][j]);
			}
			for (int j = 0; j < notas.length; j++) {
				mediana += notas[i][j];
			}
			System.out.printf("%.2f\t", mediana / notas[i].length);
			System.out.println();
		}
	}

}

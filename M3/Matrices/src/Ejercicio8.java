

public class Ejercicio8 {

	public static void main(String[] args) {
		String[] nom = { "Dani", "Ana", "Juan", "Predo", "Jordi", "Jose", "Eric", "Oscar", "Maria", "Javi" };
		String[] assig = { "\tBiologi" + "\tHistori" + "\tEspanol" + "\tMates" + "\tAngles" };
		float[][] notas = new float[10][5];
		float[] media = new float[5];

		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				notas[i][j] = (float) (Math.random() * 10);
			}
		}

		System.out.println("Notas de Alumnos\n");
		for (int i =0;i<assig.length;i++) {
			System.out.print(assig[i]);
		}
		
		System.out.print("\n");
		for (int i = 0; i < notas.length; i++) {
			System.out.print(nom[i]+": ");
			for (int j = 0; j < notas[i].length; j++) {
				System.out.printf("\t%.1f  ",notas[i][j]);
			}
			System.out.println("\n");
		}
		
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				media[j]=media[j]+notas[i][j];
			}
		}
		
		for (int i =0;i<5;i++) {
			media[i]=media[i]/nom.length;
		}
		
		
		System.out.print("Media: ");
		for (int i = 0; i < media.length; i++) {
			System.out.printf("\t%.1f  ",media[i]);
		}
	}
}
import java.util.Arrays;

public class Ejercicio4 {

	public static void main(String[] args) {
		//HE UTILIZADO NOMBRES DE LOS ARRAYS A Y B DEL EXAMEN PARA QUE LO ENTIENDAS MEJOR.
		int[] a = new int[4];
		int[] b = new int[4];
		int[] discriminats = new int[3];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 11);
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = (int) (Math.random() * 11);
		}

		System.out.println("Array1");
		System.out.print(Arrays.toString(a));

		System.out.println("\nArray2");
		System.out.print(Arrays.toString(b));

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				discriminats[i]=Math.abs((a[i]*b[j+1])-(a[i+1]*b[j]));		
				discriminats[i+1]=Math.abs((a[i+1]*b[j+2])-(a[i+2]*b[j+1]));		
				discriminats[i+2]=Math.abs((a[i+2]*b[j+3])-(a[i+3]*b[j+2]));
			}
		}
		
		System.out.println("\nDiscriminats");
		System.out.print(Arrays.toString(discriminats));

	}

}

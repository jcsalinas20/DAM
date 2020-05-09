import java.util.Arrays;

public class CercaBinaria {

	public static void main(String[] args) {
		int[] v = new int[10];
		for (int i = 0; i < v.length; i++) {
			v[i] = (int) (Math.random() * 25 + 1);
		}

		int auxiliar = 0;
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length - 1; j++) {
				if (v[j] > v[j + 1]) {
					auxiliar = v[j];
					v[j] = v[j + 1];
					v[j + 1] = auxiliar;
				}
			}
		}
		
		int inf = 0, sup = v.length - 1, med, valor = 10;
		boolean trobat = false;
		while ((inf <= sup) && !trobat) {
			med = (sup + inf) / 2;
			if (v[med] == valor)
				trobat = true;
			if (valor < v[med])
				sup = med - 1;
			else
				inf = med + 1;
		}
		if (trobat) {
			System.out.println("S'ha trobat");
		} else {
			System.out.println("No s'ha trobat");
		}
		System.out.println(Arrays.toString(v));
	}

}

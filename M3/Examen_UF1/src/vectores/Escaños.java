package vectores;

import java.util.Arrays;

public class Escaños {

	public static void main(String[] args) {
		int[] vots = { 110, 50, 40 };
		int[] esc = { 0, 0, 0 };

		for (int i = 0; i < 7; i++) {
			int[] numMax = { 0, 0 };
			for (int j = 0; j < esc.length; j++) {
				if (vots[j] > numMax[0]) {
					numMax[0] = vots[j];
					numMax[1] = j;
				}
			}
			esc[numMax[1]] += 1;
			vots[numMax[1]] = vots[numMax[1]] / (esc[numMax[1]]);
		}
		System.out.println(Arrays.toString(vots));
		System.out.println(Arrays.toString(esc));
	}

}

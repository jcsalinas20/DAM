import java.util.Arrays;

public class MathRandom {

	public static void main(String[] args) {
		int[] array = new int[10];

//		DE 1 A 25
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
		}

		System.out.println(Arrays.toString(array));
	}

}

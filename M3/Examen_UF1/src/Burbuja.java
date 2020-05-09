
public class Burbuja {

	public static void main(String[] args) {
//		new HorizontalInteger();
//		new VerticalInteger();
//		new HorizontalString();
//		new VerticalString();
	}

}

class HorizontalInteger {

	public HorizontalInteger() {
		int[][] array = new int[5][5];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 20 + 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("**************************");

		int auxiliar = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				for (int k = 0; k < array[i].length - 1; k++) {
					if (array[j][k] > array[j][k + 1]) {
						auxiliar = array[j][k];
						array[j][k] = array[j][k + 1];
						array[j][k + 1] = auxiliar;
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
	}

}

class VerticalInteger {

	public VerticalInteger() {
		int[][] array = new int[5][5];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 20 + 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("**************************");

		int auxiliar = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				for (int k = 0; k < array[i].length - 1; k++) {
					if (array[k][j] > array[k + 1][j]) {
						auxiliar = array[k][j];
						array[k][j] = array[k + 1][j];
						array[k + 1][j] = auxiliar;
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
	}

}

class HorizontalString {

	public HorizontalString() {
		String[][] array = { { "zacarias", "carlos", "alba" }, { "maria", "eric", "raquel" },
				{ "miquel", "andrea", "elsa" } };

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("**************************");

		String auxiliar = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				for (int k = 0; k < array[i].length - 1; k++) {
					if (array[j][k].compareTo(array[j][k + 1]) > 0) {
						auxiliar = array[j][k];
						array[j][k] = array[j][k + 1];
						array[j][k + 1] = auxiliar;
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
	}

}

class VerticalString {

	public VerticalString() {
		String[][] array = { { "zacarias", "carlos", "alba" }, { "maria", "eric", "raquel" },
				{ "miquel", "andrea", "elsa" } };

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("**************************");

		String auxiliar = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				for (int k = 0; k < array[i].length - 1; k++) {
					if (array[k][j].compareTo(array[k + 1][j]) > 0) {
						auxiliar = array[k][j];
						array[k][j] = array[k + 1][j];
						array[k + 1][j] = auxiliar;
					}
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
	}

}

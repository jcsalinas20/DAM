package estructurasRepititivas;

public class BacteriaAsesina {

	public static void main(String[] args) {
		int bacteria = 1;
		int tiempo = 0;
		while (bacteria < 10000000) {
			bacteria *= 2;
			tiempo += 3;
			System.out.println("Bacterias: " + bacteria);
		}
		System.out.println("Tiempo: " + tiempo + "min,  Bacterias: " + bacteria);
	}

}

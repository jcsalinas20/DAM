import java.util.Scanner;

public class Main {
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		Pixel p = new Pixel(0, 0, 0, 0, 0);

		try {
			p.asignarColorR(500);
		} catch (ColorRGBException e) {
			e.printStackTrace();
		}
		
	}

}

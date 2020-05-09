import java.util.ArrayList;

public class Pruebas {

	public static void main(String[] args) {
		ArrayList<Integer> aa = new ArrayList<Integer>();

		aa.add(1);
		aa.add(2);
		aa.add(3);
		aa.add(4);
		aa.add(5);
		
		System.out.println(aa);
		
		aa.remove(2);

		System.out.println(aa);
		
		aa.add(2, 3);

		System.out.println(aa);
	}

}

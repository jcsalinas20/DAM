
public class RegionMatches {
	public static void main(String[] args) {
		String Str1 = new String("Manual de regionMatches");
		String Str2 = new String("MANUAL DE");

		System.out.print("Comprobacion: ");
		System.out.println(Str1.regionMatches(0, Str2, 0, 8));

		System.out.print("Comprobacion: ");
		System.out.println(Str1.regionMatches(7, "de", 0, 2));
	}
}

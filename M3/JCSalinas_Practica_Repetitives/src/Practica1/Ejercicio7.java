package Practica1;
import java.util.*;
public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner x=new Scanner (System.in);
		int altura=0;
		int anchura=0;
		int i=0;
		System.out.print("Introduce la altura: ");
        altura = x.nextInt();
        System.out.print("Introduce la anchura: ");
        anchura = x.nextInt();

        StringBuilder sbInterior = new StringBuilder();
        StringBuilder sbExterior = new StringBuilder();
        for (i = 0; i < anchura; i++) {
            sbExterior.append("*");
            sbInterior.append((i == 0 || i == anchura - 1) ? "*" : " ");
        }
        String exterior = sbExterior.toString();
        String interior = sbInterior.toString();

        for (i = 0; i < altura; i++) {
            System.out.println((i == 0 || i == altura - 1) ? exterior : interior);
        }
		x.close();
	}

}

package Practica1;
import java.util.*;
public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int bucle1=1;
		int bucle2=2;
		int bucle3=20;
		int bucle4=10;
		int bucle5=40;
		while (bucle1<=10) {
			System.out.print(bucle1+"	");
			bucle1++;
		}
		System.out.println("");
		while (bucle2<=20) {
			System.out.print(bucle2+"	");
			bucle2=bucle2+2;
		}
		System.out.println("");
		while (bucle3<=38) {
			System.out.print(bucle3+"	");
			bucle3=bucle3+2;
		}
		System.out.println("");
		while (bucle4<=30) {
			System.out.print(bucle4+"	");
			bucle4=bucle4+4;
		}
		System.out.println("");
		while (bucle5>=0) {
			System.out.print(bucle5+"	");
			bucle5=bucle5-5;
		}
		x.close();
	}

}

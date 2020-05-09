package Practica1;
import java.util.*;
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int min=3;
		int bacteria=1;
		while (bacteria<10000000) {
			bacteria=bacteria*2;
			min=min+3;
			System.out.println(bacteria);
		}
		System.out.println("Humano Muerto en "+min+" minutos");
		x.close();
	}

}

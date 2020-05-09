package Practica1;
import java.util.*;
public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int num=0;
		System.out.print("Introduce un numero: ");
		num=x.nextInt();
		if (num%7==0) {
			while (num>1) {
				num=num-7;
				if (num>=1 && num<=1000) {
					System.out.println(num);
				}
			}
				
		}
		else {
			System.out.println("Error");
		}
		x.close();
	}

}

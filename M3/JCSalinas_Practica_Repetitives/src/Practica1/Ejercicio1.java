package Practica1;

import java.util.*;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int num=0;
		int num1=0;
		int num2=0;
		int resultado=0;
		String opc = "s";
		while(!opc.equalsIgnoreCase("")){ 
		System.out.println(""
				+ "CALCULADORA\r"
				+ "Menu Principal\r"
				+ "\r"
				+ "1 - Sumar\r"
				+ "2 - Restar\r"
				+ "3 - Multiplicar\r"
				+ "4 - Dividir\r"
				+ "0 - Sortir\r"
				+ "\r"
				+ "Opcion: ");
		num=x.nextInt();       
		switch (num) {
		case 1:
			System.out.println("Introduce el primer numero: ");
			num1=x.nextInt();
			System.out.println("Introduce el segundo numero: ");
			num2=x.nextInt();
			resultado = num1+num2;
			System.out.println(num1+"+"+num2+"="+resultado);
		break;
		case 2:
			System.out.println("Introduce el primer numero: ");
			num1=x.nextInt();
			System.out.println("Introduce el segundo numero: ");
			num2=x.nextInt();
			resultado = num1-num2;
			System.out.println(num1+"-"+num2+"="+resultado);
		break;
		case 3:
			System.out.println("Introduce el primer numero: ");
			num1=x.nextInt();
			System.out.println("Introduce el segundo numero: ");
			num2=x.nextInt();
			resultado = num1*num2;
			System.out.println(num1+"*"+num2+"="+resultado);
		break;
		case 4:
			System.out.println("Introduce el primer numero: ");
			num1=x.nextInt();
			System.out.println("Introduce el segundo numero: ");
			num2=x.nextInt();
			resultado = num1/num2;
			System.out.println(num1+"/"+num2+"="+resultado);
		break;
		case 0:
			opc="";
		break;
		default: System.out.println("Error");
		break;
		}
		}
		x.close();
	}
}



package Practica2;
import java.util.Scanner;
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		float precio=0f;
		int hora=30;
		int horasTrabajadas=0;
		float cable=0.5f;
		float metrosInstalados=0f;
		System.out.println("Horas trabajadas:");
		horasTrabajadas=x.nextInt();
		System.out.println("Numero de metros instalados:");
		metrosInstalados=x.nextFloat();
		horasTrabajadas=horasTrabajadas*hora;
		metrosInstalados=metrosInstalados*cable;
		precio=horasTrabajadas+metrosInstalados;
		System.out.println("Precio: "+precio+"€");
		precio=precio*1.21f;
		System.out.println("Precio + IVA: "+precio+"€");
		x.close();
	}

}

import java.util.Scanner;
public class Practica2 {

	public static void main(String[] args) {
		//EXERCICI 1 
		/*
		int num=10;
		num=num*num;
		System.out.println("Resultado: "+ num);
		*/
		
		//EXERCICI 2
			//a)
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		String nombre = "";
        System.out.println ("Nombre:");
        nombre = entradaEscaner.nextLine (); 
        System.out.println ("Hola "+ nombre);
        */
		
			//b)
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		int num1=0;
		int num2=0;
        System.out.println ("Primer Numero:");
        num1 = entradaEscaner.nextInt ();
        System.out.println ("Segundo Numero:");
        num2 = entradaEscaner.nextInt (); 
        num1 = num1*num2;
        System.out.println ("Resultado: "+ num1);
        */
		
		//EXERCICI 3
			//a)
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		int L=0;
		int S=0;
		int b=0;
		int h=0;
        System.out.println ("Introducir Base:");
        b = entradaEscaner.nextInt ();
        System.out.println ("Introducir Altura:");
        h = entradaEscaner.nextInt (); 
        L = (2*b) + (2*h);
        System.out.println ("Resultado del Perimetro: "+ L);
        S  = b*h;
        System.out.println ("Resultado de la Area: "+ S);
        */
		
			//b)
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		double A=0;
		double P=0;
		double pi=3.14;
		double r=0;
        System.out.println ("Introducir Radio:");
        r = entradaEscaner.nextDouble ();
        A = pi*(r*r);
        System.out.println ("Resultado del Perimetro: "+ A);
        P  = 2*pi*r;
        System.out.println ("Resultado de la Area: "+ P);
        */
		
			//c)
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		double A=0;
		double pi=3.14;
		double r=0;
        System.out.println ("Introducir Radio:");
        r = entradaEscaner.nextDouble ();
        A = 4/3*pi*(r*r*r);
        System.out.println ("Resultado del Volumen: "+ A);
		*/
		
			//d)
		
		//EXERCICI 4
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		float Cn=0f;
		float c=0f;
		float x=20f;
		int n=0;
        System.out.println ("Introducir la Cantidad de Dinero: ");
        c = entradaEscaner.nextFloat ();
        System.out.println("Introducir en cuantos años quieres pagalo: ");
        n = entradaEscaner.nextInt ();
        Cn = c*(1+x/100);
        System.out.println("Dinero + Importe total que tendras que devolver: " +Cn);
        Cn = c*(1+x/100) /n;
        System.out.println("Dinero + Importe total que tendras que devolver en diferentes años: " +Cn);
		*/
		
		//EXERCICI 5
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		float F=0f;
		float C=0f;
        System.out.println ("Grados Fahrenheit: ");
        F = entradaEscaner.nextFloat ();
        C = (F-32)*5/9;
        System.out.println("Grados Celsius: " +C);
        */
		
		//EXERCICI 6
		/*
		Scanner entradaEscaner = new Scanner (System.in);
		int a=0;
		int b=0;
		int x=0;
        System.out.println ("Primer Numero: ");
        a = entradaEscaner.nextInt ();
        System.out.println("Segundo Numero: ");
        b = entradaEscaner.nextInt ();
        System.out.println("Elige un numero entre 1-4 { \r1 = Suma \r2 = Resta \r3 = Multiplicación \r4 = División \r}");
        x = entradaEscaner.nextInt ();
        System.out.println(x);
		if (x==1) {
			a+=b;
        }
		else if (x==2) {
			a-=b;
		}
		else if (x==3) {
			a*=b;
		}
		else if (x==4) {
			a/=b;
		}
		else {
			System.out.println("Error");
		}
		System.out.println("Resultado: " +a);
		*/
		
		
	}

}
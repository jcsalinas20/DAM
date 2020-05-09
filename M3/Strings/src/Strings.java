import java.util.Arrays;
import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int a=1;
		//FORMAS DE DECLARAR LA VARIABLE STRING
		String cadena = "Esto es un string";
		String cadena1= new String();
		String cadena2= new String("HOLA");
		//
		String[] array= {"String 1", " String 2", " String 3"};
		
		String S;
		while (a!=0) {
		// MOSTRAR UN CARACTER DE UN STRING
		System.out.println(cadena.charAt(5));

		// MOSTRAR TODO EL STRING
		for (int i = 0; i < cadena.length(); i++) {
			System.out.print(cadena.charAt(i));
		}
		
		//JUNTAR STRINGS SIN MACHACAR
		String cad1="Hola ";
		String cad2="mon";
		cad1.concat(cad2);
		System.out.println();
		System.out.println(cad1.concat(cad2));
		
		//MOSTRAR STRING DE ARRAYS
		for (int i=0; i<array.length;i++) {
			for (int j=0; j<array[i].length();j++) {
				System.out.print(array[i].charAt(j));
			}
		}
		
		System.out.println("\n"+cadena.indexOf("g"));
		System.out.println(cadena.lastIndexOf("es"));
		System.out.println(cadena.equals("Esto es un string"));
		System.out.println(cadena.equals("un string"));
		System.out.println(cadena.equalsIgnoreCase("ESTO ES UN STRING"));
		System.out.println(cadena.compareTo("Esto es un String"));
		System.out.println(cadena.compareToIgnoreCase("Esto es un string"));
		
		
		//EL 8 NO LO COGE
		String subcadena = cadena.substring(2, 8);
		System.out.println(subcadena);
		
		//SPLIT QUITA EL CARACTER INTRODUCIDO POR UN ESPACIO
		String[] cadenatosString = cadena.split("o");
		System.out.println(Arrays.toString(cadenatosString));
		
		//CAMBIAR DE INT A STRING
		int v=5;
		String V=String.valueOf(v);
		System.out.println(V);
		
		//CAMBIAR DE STRING A INT
		String numero="25";
		int numero1=Integer.parseInt(numero);
		System.out.println(numero1);
		
		System.out.print("\nQuieres salir del programa? 0 o 1: ");
		if (x.nextLine().equals(1)) {
			
		} else;
		
		
		
		}
		
		
		
	}

}

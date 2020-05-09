
import java.util.*;

public class OrdenacionString {

	public static void main(String[] args) {
		//VARIABLES
		String auxiliar;
        String[] ordenacion = {"b", "c", "z", "r", "a"};
        
        //ARRAY DESORDENADO
        System.out.println("Array Desordenado: ");
        for (int i = 0; i < ordenacion.length; i++) {
            System.out.println(ordenacion[i]);
        }

        //ORDENACION DEL ARRAY
        for (int i = 1; i <= ordenacion.length; i++) {
            for (int j = 0; j < ordenacion.length - i; j++) {
                if (ordenacion[j].compareTo(ordenacion[j + 1]) > 0) {
                	auxiliar = ordenacion[j];
                	ordenacion[j] = ordenacion[j + 1];
                	ordenacion[j + 1] = auxiliar;
                }
            }
        }
        
        //ARRAY DESORDENADO
        System.out.println("\nArray Ordenado: ");
        for (int i = 0; i < ordenacion.length; i++) {
            System.out.println(ordenacion[i]);
        }
	}

}

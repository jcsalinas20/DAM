import java.util.Scanner;

public class Main {
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		Empleado[] emp = new Empleado[3];
		emp[0] = new Cajero("Miquel", "Cornella", "Cajero", 8, 0);
		emp[1] = new Limpieza("Adrian", "Esparraguera", "Limpieza", 35);
		emp[2] = new Mostrador("Eric", "Martorell", "Mostrador", 10, 50);

		System.out.print("Quieres mostrar la informacion de los empleados: ");
		String opcion = lector.next();

		if (opcion.equalsIgnoreCase("si")) {
			System.out.println("Nombre \t\tResidencia \t\tPuesto");
			System.out.println("--------------------------------------------------");
			for (int i = 0; i < emp.length; i++) {
				Empleado.mostrarInfo(emp, i);
			}
		}
		
	}

}


public class Validaciones {
	static boolean validacion;

	public static int opcionMenu(int numMenu) {
		validacion = false;
		int opcion = 0;
		int maxOpcionMenu = 3;
		do {
			if (Main.lector.hasNextInt()) {
				opcion = Main.lector.nextInt();
				if (numMenu == 2)
					maxOpcionMenu = 4;
				if (opcion >= 1 && opcion <= maxOpcionMenu) {
					validacion = true;
				} else {
					Main.lector.nextLine();
					System.err.print("Introduce una numero del 1 al " + maxOpcionMenu + ".\n-> ");
				}
			} else {
				Main.lector.nextLine();
				System.err.print("Introduce una numero.\n-> ");
			}
		} while (!validacion);
		return opcion;
	}

	public static int idEmpleado() {
		validacion = false;
		int id = 0;
		System.out.print("Introduce el id del empleado: ");
		do {
			if (Main.lector.hasNextInt()) {
				id = Main.lector.nextInt();
				if(Selects.comprobarIdEmpleado(id))
					validacion = true;
			} else {
				Main.lector.nextLine();
				System.err.print("Introduce una numero.\n-> ");
			}
		} while (!validacion);
		return id;
	}

}


public class Validaciones {

//	Metodo para validar la opcion introducida
	public int validacionOpcionMenu() {
		int opcion = 0;
		boolean validacion = false;
		do {
			if (Main.lector.hasNextInt()) {
				opcion = Main.lector.nextInt();
				if (opcion > 0 && opcion < 5) {
					validacion = true;
				} else {
					Main.lector.nextLine();
				}
			} else {
				Main.lector.nextLine();
			}
		} while (!validacion == true);
		return opcion;
	}

}

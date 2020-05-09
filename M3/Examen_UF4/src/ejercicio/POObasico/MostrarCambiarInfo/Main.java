package ejercicio.POObasico.MostrarCambiarInfo;

public class Main {

	public static void main(String[] args) {

		Estudiants e1 = new Estudiants("Carlos", "Salinas", "14521452A", "AMS", 1);
		Estudiants e2 = new Estudiants("Juan", "Navarrete", "47854785D", "AWS", 2);

		Profesors p1 = new Profesors("Ricard", "Garcia", "69856985W", 1200, 200);

		Administratius a1 = new Administratius("Eric", "Samper", "14782364E", 1500);

		System.out.println("--------------------------------ESTUDIANTS--------------------------------");
		System.out.println("Nom: " + e1.nom + ", Cognom: " + e1.getCognoms() + ", NIF: " + e1.nif + ", CICLE: "
				+ e1.getNomCicle() + ", CURS: " + e1.curs);
		System.out.println(e2.toString());
		System.out.println();
		e1.setCurs(2);
		e2.setNomCicle("SIS");
		System.out.println("Nom: " + e1.nom + ", Cognom: " + e1.getCognoms() + ", NIF: " + e1.nif + ", CICLE: "
				+ e1.getNomCicle() + ", CURS: " + e1.curs);
		System.out.println(e2.toString());
		System.out.println("\n\n--------------------------------PROFESORS--------------------------------");
		System.out.println(p1.toString());
		System.out.println();
		p1.setNumHores(20000);
		System.out.println(p1.toString());
		System.out.println("\n\n--------------------------------ADMINISTRATIUS--------------------------------");
		System.out.println(a1.toString());
		System.out.println();
		a1.setSou(10.2f);
		System.out.println(a1.toString());
	}

}

package ejercicio.POObasico.Descuentos;

public class Main {

	public static void main(String[] args) {
		System.out.println("Pisos p = new Pisos(\"asdf\", 25, \"nou\", 10, 20000, 4);");
		Pisos p = new Pisos();
		p.setAdresa("asdf");
		p.setEstat("nou");
		p.setMetresQuadrats(25);
		p.setNumAnys(10);
		p.setNumPis(4);
		p.setPreu(20000);
		System.out.println(p.toString());
		System.out.println();
		System.out.println();
		System.out.println("Locals l = new Locals(\"qwer\", \"segona ma\", 60, 25, 9, 100000);");
		Locals l = new Locals();
		l.setAdresa("qwer");
		l.setEstat("segona ma");
		l.setMetresQuadrats(60);
		l.setNumAnys(25);
		l.setNumFinestres(9);
		l.setPreu(100000);
		System.out.println(l.toString());
	}

}

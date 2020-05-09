package Ejercicio4;

import java.util.ArrayList;

public class Main {
	static ArrayList<Emprat> emp = new ArrayList<Emprat>();

	public static void main(String[] args) {
		Emprat emprat = new Emprat();
		emp.add(new EAsalario("569587A", "Javier", "Gomez", 2008));
		emp.add(new EComision("695235B", "Eva", "Nieto", 2010));
//		otrosEmpleados(emprat);

		emprat.imprimir(emp);

	}

	private static void otrosEmpleados(Emprat emprat) {
		emprat = new EComision();
		emprat.setDni("741258C");
		emprat.setNom("Jose");
		emprat.setCognom("Ruiz");
		emprat.setAny(2012);
		emp.add(emprat);

		emprat = new EAsalario();
		emprat.setDni("896325D");
		emprat.setNom("Maria");
		emprat.setCognom("Nunez");
		emprat.setAny(2013);
		emp.add(emprat);
	}

}

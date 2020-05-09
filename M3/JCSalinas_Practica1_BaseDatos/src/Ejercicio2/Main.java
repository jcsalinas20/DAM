package Ejercicio2;

import java.io.File;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {
	static Scanner x = new Scanner(System.in);

	public static void main(String[] args) {
		new File("Datos.data").delete();

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Datos.data");

		try {
//			CREACION JUGADORES
			jugadores(db);
//			CREACION LEYENDAS
			leyendas(db);

//			MOSTRAR JUGADORES
			listarJugadores(db);
			System.out.println();
//			MOSTRAR LEYENDAS
			listarLeyendas(db);

			pressEnter();

//			ELIMINAR
			eliminacion(db);

//			MOSTRAR JUGADORES
			System.out.println("\nMostrar jugadores restantes:");
			listarJugadores(db);
		} finally {
			db.close();
		}
	}

	private static void pressEnter() {
		System.out.println("\n\nPress Enter...");
		x.nextLine();
	}

	private static void eliminacion(ObjectContainer db) {
		Jugador p1 = null;
		Jugador p2 = new Jugador("jcsalinas20", 0, 0, 0, 0, 0);
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				p1 = new Jugador("dchcobra", 0, 0, 0, 0, 0);
			} else if (i == 1) {
				p1 = new Jugador("akaBambooh", 0, 0, 0, 0, 0);
			} else if (i == 2) {
				p1 = new Jugador("Zell_zDark", 0, 0, 0, 0, 0);
			} else if (i == 3) {
				p1 = new Jugador("teixi15", 0, 0, 0, 0, 0);
			} else if (i == 4) {
				p1 = new Jugador("Roar_Marco", 0, 0, 0, 0, 0);
			}
			ObjectSet<Object> eliminar = db.queryByExample(p1);
			p1 = (Jugador) eliminar.next();
			db.delete(p1);
			System.out.println("El jugador " + p1.name + " ha sido eliminado por " + p2.name);
		}
	}

	private static void listarLeyendas(ObjectContainer db) {
		Llegenda l = new Llegenda(0, null, null, 0);
		ObjectSet<Object> result = db.queryByExample(l);
		for (Object o : result) {
			System.out.println(o);
		}
	}

	private static void listarJugadores(ObjectContainer db) {
		Jugador j = new Jugador(null, 0, 0, 0, 0, 0);
		ObjectSet<Object> result = db.queryByExample(j);
		for (Object o : result) {
			System.out.println(o);
		}
	}

	private static void leyendas(ObjectContainer db) {
		Llegenda l = null;
		for (int i = 0; i < 4; i++) {
			int id = (int) (Math.random() * 2000);
			int totalWins = (int) (Math.random() * 1000);
			if (i == 0) {
				l = new Llegenda(id, "Bangalore", "Healer", totalWins);
				db.store(l);
			} else if (i == 1) {
				l = new Llegenda(id, "Bloodhound", "Defensive", totalWins);
				db.store(l);
			} else if (i == 2) {
				l = new Llegenda(id, "Gibraltar", "Offensive", totalWins);
				db.store(l);
			} else if (i == 3) {
				l = new Llegenda(id, "Wraith", "Explorer", totalWins);
				db.store(l);
			}
		}
	}

	private static void jugadores(ObjectContainer db) {
		Jugador j = new Jugador();
		for (int i = 0; i < 6; i++) {
			int idLegend = (int) (Math.random() * 2000);
			int kills = (int) (Math.random() * 5000);
			int totalDamage = (int) (Math.random() * 7000 + 5000);
			int top3 = (int) (Math.random() * 500 + 500);
			int totalWins = (int) (Math.random() * 500);
			if (i == 0) {
				j = new Jugador("dchcobra", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 1) {
				j = new Jugador("jcsalinas20", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 2) {
				j = new Jugador("akaBambooh", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 3) {
				j = new Jugador("Zell_zDark", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 4) {
				j = new Jugador("teixi15", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 5) {
				j = new Jugador("Roar_Marco", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			}
		}
	}

}

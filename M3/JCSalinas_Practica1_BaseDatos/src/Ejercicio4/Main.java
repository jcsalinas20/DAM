package Ejercicio4;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import Ejercicio3.Jugador;

public class Main {
	static boolean totalDamage = false;
	static Scanner x = new Scanner(System.in);

	public static void main(String[] args) {
		new File("Datos.data").delete();

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Datos.data");
		int valor = 0;
		try {
			System.out.print("Jugadores con mas de 10000 de damage.");

			while (!totalDamage) {
				if (valor == 1) {
					eliminacionTodosLosJugadores(db);
				}
//			CREACION JUGADORES
				jugadores(db);

//			ELIMINAR JUGADORES CON MENOS DE 10000 DAMAGES
				eliminar(db);
				System.out.println();
				valor = 1;
			}

			mostrar(db);

		} finally {
			db.close();
		}
	}

	private static void eliminacionTodosLosJugadores(ObjectContainer db) {
		Jugador p1 = null;
		for (int i = 0; i < 9; i++) {
			if (i == 0) {
				p1 = new Jugador("dchcobra", 0, 0, 0, 0, 0);
			} else if (i == 1) {
				p1 = new Jugador("jcsalinas20", 0, 0, 0, 0, 0);
			} else if (i == 2) {
				p1 = new Jugador("Zell_zLight", 0, 0, 0, 0, 0);
			} else if (i == 3) {
				p1 = new Jugador("teixi15", 0, 0, 0, 0, 0);
			} else if (i == 4) {
				p1 = new Jugador("Roar_Marco", 0, 0, 0, 0, 0);
			} else if (i == 5) {
				p1 = new Jugador("Zell_zDark", 0, 0, 0, 0, 0);
			} else if (i == 6) {
				p1 = new Jugador("akaBambooh", 0, 0, 0, 0, 0);
			} else if (i == 7) {
				p1 = new Jugador("iDarky", 0, 0, 0, 0, 0);
			} else if (i == 8) {
				p1 = new Jugador("ThePride115", 0, 0, 0, 0, 0);
			}
			ObjectSet<Object> eliminar = db.queryByExample(p1);
			p1 = (Jugador) eliminar.next();
			db.delete(p1);
		}

	}

	private static void mostrar(ObjectContainer db) {
		Jugador p = new Jugador(null, 0, 0, 0, 0, 0);
		List<Jugador> result = db.queryByExample(p);
		for (Jugador o : result) {
			System.out.println(o);
		}
	}

	private static void eliminar(ObjectContainer db) {
		List<Jugador> result = db.query(new Predicate<Jugador>() {
			@Override
			public boolean match(Jugador p) {
				return p.getTotalDamage() < 10000;
			}
		});
		if (result.size() > 2) {
			for (Object o : result) {
				totalDamage = true;
				db.delete(o);
			}
		} else {
			System.out.print("\nMenos de 3 jugadores con el damage por de bajo de 10000. Reboot.");
		}
	}

	private static void jugadores(ObjectContainer db) {
		Jugador j = new Jugador();
		for (int i = 0; i < 9; i++) {
			int idLegend = (int) (Math.random() * 2000);
			int kills = (int) (Math.random() * 13);
			int totalDamage = (int) (Math.random() * 10000 + 5000);
			int top3 = (int) (Math.random() * 500 + 500);
			int totalWins = (int) (Math.random() * 500);
			if (i == 0) {
				j = new Jugador("dchcobra", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 1) {
				j = new Jugador("jcsalinas20", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 2) {
				j = new Jugador("Zell_zLight", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 3) {
				j = new Jugador("teixi15", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 4) {
				j = new Jugador("Roar_Marco", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 5) {
				j = new Jugador("Zell_zDark", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 6) {
				j = new Jugador("akaBambooh", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 7) {
				j = new Jugador("iDarky", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 8) {
				j = new Jugador("ThePride115", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			}
		}
	}

}

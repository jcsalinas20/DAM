package Ejercicio3;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class Main {
	static boolean masDe10Kills = false;
	static int contador = 0;
	static Scanner x = new Scanner(System.in);

	public static void main(String[] args) {
		new File("Datos.data").delete();

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Datos.data");

		System.out.println("Jugadores con mas de 10 kills.");
		Jugador j = null;
		int vuelta = 0;
		while (!masDe10Kills) {
			if (vuelta == 1) {
				eliminacion(db);
			}
//			CREACION JUGADORES
			j = jugadores(db);

//			MOSTRAR JUGADORES CON MAS DE 10 KILLS
			listarJugadores(db);
			System.out.println();
			vuelta = 1;

		}

		pressEnter();

		System.out.println("Ordenacion Top 3 Ascendente.");
//		ORDENACION TOP3
		String valorAOrdenar = "top3";
		ordenar(db, j, valorAOrdenar);

		pressEnter();

		System.out.println("Ordenacion por mas de 10 Kills.");
//		ORDENACION KILLS
		valorAOrdenar = "kills";
		ordenar(db, j, valorAOrdenar);

		db.close();

	}

	private static void ordenar(ObjectContainer db, Jugador j, String valorAOrdenar) {
		Query q = db.query();
		q.constrain(Jugador.class);
		q.descend(valorAOrdenar);
		q.sortBy(new Comparator<Jugador>() {
			@Override
			public int compare(Jugador o1, Jugador o2) {
				int valor = 0;
				if (valorAOrdenar.equalsIgnoreCase("top3")) {
					valor = o1.top3 - o2.top3;
					return valor;
				} else if (valorAOrdenar.equalsIgnoreCase("kills")) {
					if (o2.kills > 10) {
						valor = o2.kills - o1.kills;
						return valor;
					}
				}
				return 0;
			}
		});
		ObjectSet<Jugador> result = q.execute();
		if (valorAOrdenar.equalsIgnoreCase("kills")) {
			for (int i = 0; i < contador; i++) {
				System.out.println(result.get(i));
			}
			System.out.println("\nSuma de kill + posicion:");
			for (int i = 0; i < contador; i++) {
				result.get(i).setKills(i + 1);
				System.out.println(result.next());
			}
		} else {
			while (result.hasNext()) {
				System.out.println(result.next());
			}
		}

	}

	private static void pressEnter() {
		System.out.println("\n\nPress Enter...");
		x.nextLine();
	}

	private static void eliminacion(ObjectContainer db) {
		Jugador p1 = null;
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				p1 = new Jugador("dchcobra", 0, 0, 0, 0, 0);
			} else if (i == 1) {
				p1 = new Jugador("akaBambooh", 0, 0, 0, 0, 0);
			} else if (i == 2) {
				p1 = new Jugador("teixi15", 0, 0, 0, 0, 0);
			} else if (i == 3) {
				p1 = new Jugador("Roar_Marco", 0, 0, 0, 0, 0);
			} else if (i == 4) {
				p1 = new Jugador("jcsalinas20", 0, 0, 0, 0, 0);
			}
			ObjectSet<Object> eliminar = db.queryByExample(p1);
			p1 = (Jugador) eliminar.next();
			db.delete(p1);
		}
	}

	private static void listarJugadores(ObjectContainer db) {
		List<Jugador> result = db.query(new Predicate<Jugador>() {
			@Override
			public boolean match(Jugador p) {
				return p.getKills() > 10;
			}
		});
		if (result.size() > 0) {
			for (Object o : result) {
				masDe10Kills = true;
				System.out.println(o);
				contador++;
			}
		} else {
			System.out.print("Ningun jugador a conseguido mas de 10 kills. Reboot.");
		}
	}

	private static Jugador jugadores(ObjectContainer db) {
		Jugador j = new Jugador();
		for (int i = 0; i < 5; i++) {
			int idLegend = (int) (Math.random() * 2000);
			int kills = (int) (Math.random() * 20);
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
				j = new Jugador("teixi15", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			} else if (i == 4) {
				j = new Jugador("Roar_Marco", idLegend, kills, totalDamage, top3, totalWins);
				db.store(j);
			}
		}
		return j;
	}

}

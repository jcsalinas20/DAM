package Ejercicio1;
import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {

	public static void main(String[] args) {
		new File("Datos.data").delete();

		BaseDeDatos player = new BaseDeDatos();
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Datos.data");

		try {
//			INTRODUCCION DE 5 JUGADORES
			introPlayer(player, db);

//			MOSTRAR JUGADORES
			listarJugadores(player, db);

		} finally {
			db.close();
		}
	}

	private static void listarJugadores(BaseDeDatos player, ObjectContainer db) {
		player = new BaseDeDatos(null, 0, 0, 0, 0);
		ObjectSet<Object> result = db.queryByExample(player);
		for (Object o : result) {
			System.out.println(o);
		}
	}

	private static void introPlayer(BaseDeDatos player, ObjectContainer db) {
		player = new BaseDeDatos("dchcobra", 251, 327, 3284, 2989);
		db.store(player);
		player = new BaseDeDatos("akaBambooh", 20, 52, 878, 544);
		db.store(player);
		player = new BaseDeDatos("jcsalinas20", 521, 2486, 12516, 6551);
		db.store(player);
	}

}

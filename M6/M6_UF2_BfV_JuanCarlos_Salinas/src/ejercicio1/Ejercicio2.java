package ejercicio1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import objetos.Bfplayer;
import util.HibernateUtil;

public class Ejercicio2 {

	private static Session session;
	private static Transaction transaction;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();// comienzo de sesion
		transaction = session.beginTransaction();

		List<Bfplayer> players = session.createCriteria(Bfplayer.class).list();
		for (Bfplayer player : players) {
			System.out.println(player.listarPlayers());
		}

		transaction.commit();// guardar todos los cambios
		session.close();
		System.exit(0);// cerrar el programa
	}

}

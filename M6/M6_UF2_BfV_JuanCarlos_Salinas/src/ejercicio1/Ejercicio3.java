package ejercicio1;
import org.hibernate.Session;
import org.hibernate.Transaction;

import objetos.Weapon;
import util.HibernateUtil;

public class Ejercicio3 {

	private static Session session;
	private static Transaction transaction;

	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();// comienzo de sesion
		transaction = session.beginTransaction();

		Weapon weapon = new Weapon(11, "KE7", "Light Machine Gun", 23, 65);
		session.save(weapon);
		System.out.println("\n Insertado correctamente.");

		transaction.commit();// guardar todos los cambios
		session.close();
		System.exit(0);// cerrar el programa
	}

}

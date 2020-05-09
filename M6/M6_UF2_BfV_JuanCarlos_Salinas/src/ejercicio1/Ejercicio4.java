package ejercicio1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import objetos.Bfplayer;
import objetos.Device;
import objetos.Weapon;
import util.HibernateUtil;

public class Ejercicio4 {

	private static Session session;
	private static Transaction transaction;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();// comienzo de sesion
		transaction = session.beginTransaction();

		Bfplayer player = new Bfplayer("Zell_zDark", 2, 10, 4, 777, 1);
		session.save(player);

		List<Bfplayer> players = session.createCriteria(Bfplayer.class).add(Restrictions.ilike("userId", "Zell_zDark"))
				.list();
		for (Bfplayer play : players) {
			System.out.println(play.toString());

			List<objetos.Class> classes = session.createCriteria(objetos.Class.class)
					.add(Restrictions.eq("classId", play.getClassId())).list();
			for (objetos.Class clazz : classes) {
				System.out.println(clazz.toString());
			}
			List<Weapon> weapons = session.createCriteria(Weapon.class).add(Restrictions.eq("weaponId", play.getPrimaryWeapon())).list();
			for (Weapon weapon : weapons) {
				System.out.println(weapon.toString());
			}
			List<Device> devices = session.createCriteria(Device.class).add(Restrictions.eq("deviceId", play.getDevice1())).list();
			for (Device device : devices) {
				System.out.println(device.toString());
			}
		}

		System.out.println("\nInsertado correctamente.");

		transaction.commit();// guardar todos los cambios
		session.close();
		System.exit(0);// cerrar el programa
	}

}

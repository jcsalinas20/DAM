package ejercicio1;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import objetos.Bfplayer;
import util.HibernateUtil;

public class Ejercicio5 {

	private static Session session;
	private static Transaction transaction;

	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().openSession();// comienzo de sesion
//		transaction = session.beginTransaction();

		StoredProcedureQuery call = session.createStoredProcedureQuery("eliminarJugadores", Bfplayer.class);
		call.execute();

		System.out.println("\n Eliminado correctamente.");

//		transaction.commit();// guardar todos los cambios
		session.close();
		System.exit(0);// cerrar el programa
	}

}

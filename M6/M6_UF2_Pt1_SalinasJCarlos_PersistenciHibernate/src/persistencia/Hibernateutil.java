package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {

	private static SessionFactory session;
	
	static {
		session = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return session;
	}
}

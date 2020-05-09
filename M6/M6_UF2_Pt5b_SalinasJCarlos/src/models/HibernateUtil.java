package models;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory session;
	
	static {
		session = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return session;
	}
}
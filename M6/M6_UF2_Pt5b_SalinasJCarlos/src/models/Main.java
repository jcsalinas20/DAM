package models;

import org.hibernate.SessionFactory;

public class Main {
	public static void main(String[] args) {
		SessionFactory session = HibernateUtil.getSessionFactory();
		session.close();
		System.exit(0);
	}
}

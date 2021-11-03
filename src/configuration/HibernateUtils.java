package configuration;

import java.io.File;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	static { 
		// sessionFactory = new Configuration().configure("/HibernateTutorial/hibernate.cfg.xml").buildSessionFactory();
		// sessionFactory= new Configuration().configure().buildSessionFactory();
		sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}

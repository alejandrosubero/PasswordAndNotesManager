package configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Categories;
import model.Data;
import model.Gestion;
import model.OldPassword;
import model.User;
import model.UserConfiguration;



public class HibernateUtils {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (null == sessionFactory) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/gestorpass");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "admin");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "false");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Categories.class);
				configuration.addAnnotatedClass(OldPassword.class);
				configuration.addAnnotatedClass(Data.class);
				configuration.addAnnotatedClass(UserConfiguration.class);
				configuration.addAnnotatedClass(Gestion.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	    
}
	
	
	

//private static SessionFactory sessionFactory;
//private static StandardServiceRegistry standardServiceRegistry;
//static { 
//	try {
//		standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
//		MetadataSources metadataSource = new MetadataSources(standardServiceRegistry);
//		Metadata metadata = metadataSource.getMetadataBuilder().build();
//		sessionFactory = metadata.getSessionFactoryBuilder().build();
//	} catch (Exception e) {
//		if (standardServiceRegistry != null) {
//			StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
//		}
//	}	
//	Configuration conf = new Configuration(); 
//	sessionFactory = conf.configure().buildSessionFactory();
// sessionFactory = new Configuration().configure().buildSessionFactory();
//File file=new File(Constant.barra+System.getProperty("user.dir")+Constant.barra+"src"+Constant.barra+"hibernate.cfg.xml");
//sessionFactory = new Configuration().configure(file).buildSessionFactory();
//}
//public static SessionFactory getSessionFactory() {
//	return sessionFactory;
//}
	



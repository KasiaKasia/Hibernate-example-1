package pl.kasia;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

// konfiguracja bez pliku xml
public class HibernateUtil {
	private static final SessionFactory sessionFactory = loadSessionFactory();

	private static SessionFactory loadSessionFactory() {
		Map<String, Object> SETTINGS = new HashMap<>();
		SETTINGS.put("hibernate.connection.driver_class", "org.postgresql.Driver");
		SETTINGS.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/db");
		SETTINGS.put("hibernate.connection.username", "postgres");
		SETTINGS.put("hibernate.connection.password", "postgres");
		SETTINGS.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
 		SETTINGS.put(Environment.HBM2DDL_AUTO, "none");
 		SETTINGS.put(Environment.SHOW_SQL, true); // pokaż zapytania Hibernate
		SETTINGS.put(Environment.FORMAT_SQL, false);
		try {

			ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(SETTINGS)
					.build();
			Metadata metadata = new MetadataSources(standardRegistry).addAnnotatedClass(Person.class)
					.getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
 
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	static void closeSessionFactory() {
		try {
			sessionFactory.close();
		} catch (Throwable error) {
			System.err.println("Exception while closing SessionFactory: " + error);
		}
	}

	static Session getSession() {
		try {
			return sessionFactory.openSession();
		} catch (Throwable error) {
			System.err.println("Exception while getting Session: " + error);
		}
		return null;
	}
}

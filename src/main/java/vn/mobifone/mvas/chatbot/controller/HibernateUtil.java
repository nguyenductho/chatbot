package vn.mobifone.mvas.chatbot.controller;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
public class HibernateUtil {
    private static SessionFactory sessionFactory;
     
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
    		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    				.configure() // configures settings from hibernate.cfg.xml
    				.build();
    		try {
    			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    		}
    		catch (Exception e) {
    			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
    			// so destroy it manually.
    			e.printStackTrace();
    			StandardServiceRegistryBuilder.destroy( registry );
    		}            
        
        }
        
         
        return sessionFactory;
    }
    
	protected void setUp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
}
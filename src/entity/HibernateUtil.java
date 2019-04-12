package entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author: Iman
 * date   : 2019/4/8
 */
public class HibernateUtil {

    private  static SessionFactory sessionFactory=null;
    static {
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();

        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

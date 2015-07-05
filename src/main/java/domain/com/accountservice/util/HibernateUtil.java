package domain.com.accountservice.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.internal.StandardServiceRegistryImpl;

/**
 * @Author Илья
 * @Created 05.07.2015.
 */
public class HibernateUtil {

    //Logger

    private static final String PATH_TO_HIBERNATE_CFG = "C:\\Users\\Илья\\Desktop\\AccountService\\src\\main\\resources\\hibernate.cfg.xml";

    private static SessionFactory sessionFacroty;

    static {
        initSessionFactory();
    }

    public static SessionFactory getSessionFacroty() {
        if (sessionFacroty.isClosed()) {
            initSessionFactory();
        }

        return sessionFacroty;
    }

    private static void initSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        sessionFacroty = configuration.buildSessionFactory(serviceRegistry);
    }
}

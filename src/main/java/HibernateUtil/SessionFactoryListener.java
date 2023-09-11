package HibernateUtil;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class SessionFactoryListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.getSessionFactory();
        System.out.println("open Session");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.closeSessionFactory();
        System.out.println("closed Session");
    }
}

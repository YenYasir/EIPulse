package HibernateUtil;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class OpenSeesionViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            System.out.println("begin");

            filterChain.doFilter(servletRequest,servletResponse);

            session.getTransaction().commit();
            System.out.println("commit");
        }catch (Exception e){
            session.getTransaction().commit();
            System.out.println("rolback");
            e.printStackTrace();
        }finally {
            System.out.println("closed");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

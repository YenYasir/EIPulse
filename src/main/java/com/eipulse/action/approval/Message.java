package com.eipulse.action.approval;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.eipulse.bean.NotificationField;

import HibernateUtil.HibernateUtil;
@WebServlet("/message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Message() {  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Query<NotificationField> query = session.createQuery("from NotificationField where empId = ?1 ORDER BY createdAt", NotificationField.class);
        query.setParameter(1, 1001);
        request.setAttribute("message", query.list());
        request.getRequestDispatcher("formview.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

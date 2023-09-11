package com.eipulse.action.permission;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.eipulse.bean.Employee;
import com.eipulse.bean.Permission;

import HibernateUtil.HibernateUtil;
@WebServlet("/PermissionEmp")
public class PermissionEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PermissionEmp() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Employee";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        request.setAttribute("emps", query.list());
        String hql1 = "from Permission";
        Query<Permission> query1 = session.createQuery(hql1, Permission.class);
        request.setAttribute("per", query1.list());
        request.setAttribute("jspOpen", 1);
        request.getRequestDispatcher("permissionindex.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

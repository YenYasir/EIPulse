package com.eipulse.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import HibernateUtil.HibernateUtil;
//@WebServlet("/PermissionEmp")
public class PermissionEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PermissionEmp() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        String hql = "from PerissionEmp";

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

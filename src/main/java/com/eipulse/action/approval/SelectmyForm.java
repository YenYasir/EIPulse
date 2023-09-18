package com.eipulse.action.approval;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.eipulse.bean.FormRecord;

import HibernateUtil.HibernateUtil;
@WebServlet("/selectmyform")
public class SelectmyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectmyForm() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session1 = factory.getCurrentSession();
		Query<FormRecord> query = session1.createQuery("from FormRecord where empId=?1", FormRecord.class);
		query.setParameter(1,session.getAttribute("EmpId"));
		request.setAttribute("myForms", query.list());
		request.getRequestDispatcher("myform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

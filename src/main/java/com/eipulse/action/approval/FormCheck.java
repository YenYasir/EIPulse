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

import com.eipulse.bean.FormAuditEventLog;
import com.eipulse.bean.FormRecord;

import HibernateUtil.HibernateUtil;

@WebServlet("/formCheck")
public class FormCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		HttpSession sess = request.getSession();
        int empId = (int) sess.getAttribute("EmpId");
		String hql = "from FormAuditEventLog join formRecord where auditor = ?1 and formRecord.formId=?2";
		Query<FormAuditEventLog> query = session.createQuery(hql, FormAuditEventLog.class);
		query.setParameter(1, empId);
		query.setParameter(2, request.getParameter("formId"));
		FormRecord formrec = query.uniqueResult().getFormRecord();
		switch (formrec.getTypeId()) {
		case 1: {
			request.setAttribute("content", formrec.getOverTime());
			break;
		}
		case 2: {
			request.setAttribute("content", formrec.getLeaveTable());
			break;
		}
		default:
			break;
		}
		request.setAttribute("formrec", formrec);
		request.getRequestDispatcher("formaudit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

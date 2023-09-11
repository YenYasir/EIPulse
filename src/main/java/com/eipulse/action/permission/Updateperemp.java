package com.eipulse.action.permission;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.eipulse.bean.Employee;
import com.eipulse.bean.EmployeePermission;

import HibernateUtil.HibernateUtil;

@WebServlet("/updateperemp")
public class Updateperemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Updateperemp() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		int id = Integer.valueOf(request.getParameter("id"));
//		int id =1002;
		Employee emp = session.get(Employee.class, id);
		List<EmployeePermission> list = new ArrayList<>();
		int a = Integer.valueOf(request.getParameter("num"));
		int b = 0;
		
		for (int i = 1; i <= a + 1; i++) {
			if (request.getParameter("per" + i) != null) {
				EmployeePermission empper = new EmployeePermission();
				empper.setEmpId(id);
				empper.setPermissionId(i);
				list.add(empper);
				b++;
			}
		}
//		System.out.println(1000);
		if (b != 0) {
//			System.out.println(2000);
			String hql = "DELETE FROM EmployeePermission WHERE empId=?1";
			Query query = session.createQuery(hql);
			query.setParameter(1, id);
			query.executeUpdate();
//			System.out.println(3000);
			emp.setPermissions(list);
			session.persist(emp);
//			System.out.println(4000);
		}
//		System.out.println(5000);
		request.setAttribute("result", 1);
		request.getRequestDispatcher("selectemppermission.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

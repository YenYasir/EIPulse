package com.eipulse.action.permission;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.eipulse.bean.Employee;
import com.eipulse.bean.EmployeeInfo;
import com.eipulse.bean.Permission;

import HibernateUtil.HibernateUtil;
@WebServlet("/permissionEmp")
public class PermissionEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PermissionEmp() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        HttpSession sess = request.getSession();
        Employee emp =session.get(Employee.class, sess.getAttribute("EmpId"));
//        Employee emp =session.get(Employee.class, 1000);
        System.out.println(sess.getAttribute("EmpId"));
        String hql = "FROM EmployeeInfo eif JOIN eif.employee e WHERE eif.deptId = ?1 AND e.empId != ?2 AND eif.titleId < ?3";
        Query<EmployeeInfo> query = session.createQuery(hql, EmployeeInfo.class);
		query.setParameter(1, emp.getEmployeeInfo().getDeptId());
		query.setParameter(2, emp.getEmpId());
		query.setParameter(3, emp.getEmployeeInfo().getTitleId());
		List<Employee> emps = new ArrayList<>();
		for(EmployeeInfo e : query.list())
			emps.add(e.getEmployee());
		request.setAttribute("emps", emps);
        request.setAttribute("jspOpen", 1);
        request.getRequestDispatcher("permissionindex.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

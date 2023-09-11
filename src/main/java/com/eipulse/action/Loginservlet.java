package com.eipulse.action;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.eipulse.bean.Dept;
import com.eipulse.bean.Employee;
import com.eipulse.bean.EmployeePermission;
import com.eipulse.bean.Login;
import com.eipulse.bean.Title;

import HibernateUtil.HibernateUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

  String EmpId = request.getParameter("EmpId");
  String PassWord = request.getParameter("PassWord");
  HttpSession session = request.getSession();
  SessionFactory factory = HibernateUtil.getSessionFactory();
  Session session1 = factory.getCurrentSession();
  RequestDispatcher dispatcher = null;
  String hql = "from Login where id = :empId and passWord = :password";
  Query<Login> query = session1.createQuery(hql, Login.class);
  query.setParameter("empId", EmpId);
  query.setParameter("password", PassWord);
  Login newlogin = query.uniqueResult();
  if (newlogin != null) {
	   session.setAttribute("EmpId", newlogin.getEmpId());
	   Employee emp = newlogin.getEmployee();
		for(EmployeePermission ps : emp.getPermissions()) {
			switch (ps.getPermissionId()) {
			case 1: {
				session.setAttribute("insertEmp", 1);
				Query<Dept> querydept = session1.createQuery("from Dept");
				session.setAttribute("dept", querydept.list());
				Query<Title> querytitle = session1.createQuery("from Title");
				session.setAttribute("title", querytitle.list());
				break;
			}
			case 2:{
				session.setAttribute("selectEmp", 1);
				break;
			}
			case 3:{
				session.setAttribute("selectperEmp", 1);
				break;
			}
//			case 4:{
//				session.setAttribute("selectEmp", 1);
//			}
			default:
				break;
			}
		}
	   dispatcher = request.getRequestDispatcher("index.jsp");
	  } else
	   dispatcher = request.getRequestDispatcher("loginerror.jsp");


  dispatcher.forward(request, response);

 }
}
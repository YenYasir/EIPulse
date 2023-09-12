package com.eipulse.action;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eipulse.bean.Login;

import HibernateUtil.HibernateUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/newpassword")
public class NewPassword extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  HttpSession session = request.getSession();
  SessionFactory factory = HibernateUtil.getSessionFactory();
  Session session1 = factory.getCurrentSession();
  String NewPwd = request.getParameter("NewPwd");
  String NewPwdCk = request.getParameter("NewPwdCk");
  RequestDispatcher dispatcher = null;
  if (NewPwd != null && NewPwdCk != null && NewPwd.equals(NewPwdCk)) {
   Login newlogin = new Login();
   newlogin.setEmpId((int)session.getAttribute("emailcon"));
   newlogin.setPassWord(NewPwd);
   Login uplogin = session1.merge(newlogin);
   if(uplogin!=null) {
    request.setAttribute("status", "resetSuccess");
   }else
    request.setAttribute("status", "resetFailed");
   dispatcher = request.getRequestDispatcher("login.jsp");
   dispatcher.forward(request, response);
  }
 }
}
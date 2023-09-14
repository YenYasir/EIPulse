package com.eipulse.action;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eipulse.dao.EmpDaoService;

import HibernateUtil.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmp")
public class DeleteEmpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        int empId = Integer.parseInt(req.getParameter("id"));
        System.out.println(empId+"-----------------");
        EmpDaoService empDaoService = new EmpDaoService(session);
        boolean result = empDaoService.deleteEmp(empId);

        req.getRequestDispatcher("SelectAllEmp").forward(req,resp);
    }
}

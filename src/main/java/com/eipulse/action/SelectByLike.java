package com.eipulse.action;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eipulse.bean.Employee;
import com.eipulse.dao.EmpDaoService;

import HibernateUtil.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SelectByLike")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class SelectByLike extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        String keywordGet = req.getParameter("keyword");


        EmpDaoService empDaoService = new EmpDaoService(session);
        List<Employee> emp = empDaoService.selectByLike(keywordGet);
        System.out.println(emp);

        req.setAttribute("emp",emp);
        req.getRequestDispatcher("selectbylike.jsp").forward(req,resp);
    }
}

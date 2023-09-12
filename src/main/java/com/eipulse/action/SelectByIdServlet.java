package com.eipulse.action;

import java.io.IOException;
import java.util.Base64;

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

@WebServlet("/SelectById")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class SelectByIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        int idGet = Integer.parseInt(req.getParameter("id"));


        EmpDaoService empDaoService = new EmpDaoService(session);
        Employee emp = empDaoService.selectById(idGet);
        System.out.println(emp);

        byte[] pictureData = emp.getPhoto();
        String base64Picture = Base64.getEncoder().encodeToString(pictureData);
        req.setAttribute("emp",emp);
        req.setAttribute("base64Picture", base64Picture);
        req.getRequestDispatcher("selectbyid.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        int idGet = Integer.parseInt(req.getParameter("id"));
//
//
//        EmpDaoService empDaoService = new EmpDaoService(session);
//        Employee emp = empDaoService.selectById(idGet);
//        System.out.println(emp);
//
//        byte[] pictureData = emp.getPhoto();
//
//        // Convert the byte array to Base64
//        String base64Picture = Base64.getEncoder().encodeToString(pictureData);
//
//        // Set the Base64 image data as an attribute in the request
//        req.setAttribute("base64Picture", base64Picture);
//
//
//        req.setAttribute("emp",emp);
//        req.getRequestDispatcher("/jsp/SelectById.jsp").forward(req,resp);
    }
}

package com.eipulse.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eipulse.bean.Contact;
import com.eipulse.bean.Emergency;
import com.eipulse.bean.Employee;
import com.eipulse.dao.EmpDaoService;

import HibernateUtil.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/UpdateEmp")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class UpdateEmpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Part photoPart = req.getPart("photo");
        byte[] photoDate=null;
        int idGet = Integer.parseInt(req.getParameter("id"));
        if(photoPart!=null && photoPart.getSize()>0) {
        	InputStream inputStreamPhoto = photoPart.getInputStream();
            photoDate = inputStreamPhoto.readAllBytes();
            System.out.println("有圖片"+photoDate);
        }else {
			Employee employee = session.get(Employee.class, idGet);
			photoDate = employee.getPhoto();
			System.out.println("沒圖片"+photoDate);
		}
        
//        InputStream inputStreamPhoto = photoPart.getInputStream();
//        byte[] photoDate = inputStreamPhoto.readAllBytes();
        
        Employee empid = new Employee();
        empid.setEmpId(idGet);
        Contact contactGet = new Contact(empid, req.getParameter("phone"), req.getParameter("tel"), req.getParameter("address"), req.getParameter("email"));

        // 處理多個緊急聯絡人
        List<Emergency> emergencyGet = new ArrayList<>();
        int count = Integer.parseInt(req.getParameter("emergencyCount")); // 從表單中獲取緊急聯絡人的總數
        Employee empGet = new Employee(Integer.parseInt(req.getParameter("id")), req.getParameter("idNumber"), req.getParameter("empName"), req.getParameter("gender"),
                req.getParameter("birth"), photoDate);
        for (int i = 0; i < count; i++) {
            int emergencyId = Integer.parseInt(req.getParameter("emergencyId" + i));
            String emergencyName = req.getParameter("emergencyName" + i);
            String emergencyPhone = req.getParameter("emergencyPhone" + i);
            String emergencyRelationship = req.getParameter("emergencyRelationship" + i);

            Emergency emergency = new Emergency(emergencyId, emergencyName, emergencyPhone, emergencyRelationship,empGet);
            emergencyGet.add(emergency);
            System.out.println(emergency);
        }
        empGet.setContact(contactGet);
        empGet.setEmergencies(emergencyGet);
        EmpDaoService empDaoService = new EmpDaoService(session);

        try {
            Employee emp = empDaoService.updateEmp(empGet);
            req.setAttribute("emp", emp);
            req.getRequestDispatcher("updatesuccess.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
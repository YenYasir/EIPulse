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
import com.eipulse.bean.Login;
import com.eipulse.dao.EmpDao;

import HibernateUtil.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/InsertEmp")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class InsertEmpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.getCurrentSession();
		String idnumber = req.getParameter("idNumber");
		String empName = req.getParameter("empName");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		Part photoPart = req.getPart("photo");
     InputStream fileInputStream = photoPart.getInputStream();
     byte[] binaryData = new byte[fileInputStream.available()];
     fileInputStream.read(binaryData);
		Employee newemp=new Employee(idnumber,empName,gender,birth,binaryData);
		String phone = req.getParameter("phone");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		Contact ct = new Contact(phone,tel,address,email);
		String emeName = req.getParameter("emergencyName");
		String emePhone = req.getParameter("emergencyPhone");
		String emeRel = req.getParameter("emergencyRelationship");
		Emergency eme = new Emergency(emeName,emePhone,emeRel);
		EmpDao empDao = new EmpDao(session);
		List<Emergency> emergencys = new ArrayList<>();
		eme.setEmployee(newemp);
		emergencys.add(eme);
		ct.setEmployee(newemp);
		newemp.setContact(ct);
		newemp.setEmergencies(emergencys);
		Employee empout=empDao.insertEmp(newemp);
	    String lastSixDigitsOfBirth = birth.substring(2, 4) + birth.substring(5, 7) + birth.substring(8, 10);
	    String password = lastSixDigitsOfBirth; 
	    Login newLogin = new Login();
	    newLogin.setEmpId(empout.getEmpId()); 
	    newLogin.setPassWord(password); 
	    session.persist(newLogin);
	    session.getTransaction().commit();
		req.setAttribute("emp",empout);
        req.getRequestDispatcher("insertempsuccess.jsp").forward(req,resp);
    }
}

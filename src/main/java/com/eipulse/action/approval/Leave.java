package com.eipulse.action.approval;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eipulse.bean.FormAuditEventLog;
import com.eipulse.bean.FormEventLog;
import com.eipulse.bean.FormRecord;
import com.eipulse.bean.LeaveTable;
import com.eipulse.bean.NotificationField;

import HibernateUtil.HibernateUtil;
@WebServlet("/leave")
public class Leave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Leave() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        HttpSession sess = request.getSession();
        String text = request.getParameter("text");
        FormRecord form = new FormRecord();
        int employeeId = (int) sess.getAttribute("EmpId");
        form.setEmpId(employeeId);
        form.setStartDate(String.valueOf(LocalDateTime.now()));
        //設定不同表單
        form.setTypeId(2);
        LeaveTable leaveTable = new LeaveTable();
        leaveTable.setTextle(text);
        List<FormAuditEventLog> list = new ArrayList<>();
        String[] audit = request.getParameterValues("selectEmp");
        NotificationField notification = new NotificationField();
        if(audit!=null) {
        	for(String empId : audit) {
        		FormAuditEventLog formAudit = new FormAuditEventLog();
        		formAudit.setAuditor(Integer.valueOf(empId));
        		formAudit.setFormRecord(form);
        		formAudit.setFormStatus("待審核");
        		list.add(formAudit);
        		notification.setEmpId(Integer.valueOf(empId));
        	}
        }
        form.setFormAuditEventLog(list);
        List<FormEventLog> list1 = new ArrayList<>();
        FormEventLog fel = new FormEventLog();
        fel.setFormRecord(form);
        fel.setSequence(0);
        fel.setFormStatus("待審核");
        fel.setStartDate(String.valueOf(LocalDateTime.now()));
        list1.add(fel);
        form.setFormAuditEventLog(list);
        form.setFormEventLog(list1);
        LeaveTable leave = new LeaveTable();
        leave.setTextle(text);
        leave.setFormRecord(form);
        form.setLeaveTable(leaveTable);
        session.persist(form);
        notification.setCreatedAt(String.valueOf(LocalDateTime.now()));
        notification.setMessage("員工"+employeeId+"有一份文件需要您簽核");
        session.persist(notification);
        
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.eipulse.action;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.eipulse.bean.Contact;

import HibernateUtil.HibernateUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session1 = factory.getCurrentSession();
		String Email = request.getParameter("Email");
		RequestDispatcher dispatcher = null;
		int otpvalue = 0;
		HttpSession mySession = request.getSession();
		String hql = "from Contact where email = ?1";
		Query<Contact> query = session1.createQuery(hql,Contact.class);
		query.setParameter(1, Email);
		Contact con = query.uniqueResult();
		
		if (con != null) {
			mySession.setAttribute("emailcon", con.getEmployee().getEmpId());
			if (Email != null || !Email.equals("")) {

				Random rand = new Random();
				otpvalue = rand.nextInt(1255650);

				String to = Email;
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "587");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.ssl.protocols", "TLSv1.2");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "587");

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("blueyykai@gmail.com", "vqxckedkbiujufvm");
					}
				});

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(Email));// change accordingly
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					message.setSubject("你好");
					message.setText("你的驗證碼是: " + otpvalue);
					// send message

					Transport.send(message);
					System.out.println("成功送出");
					
				}
				
				catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				dispatcher = request.getRequestDispatcher("enterotp.jsp");
				request.setAttribute("message", "驗證碼已寄至信箱");

				mySession.setAttribute("Otp", otpvalue);
				mySession.setAttribute("Email", Email);
				dispatcher.forward(request, response);

			}
		}else {
			request.setAttribute("err", "沒有此信箱");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
			

	}
}



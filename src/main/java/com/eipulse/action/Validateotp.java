package com.eipulse.action;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/validateotp")
public class Validateotp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int value=Integer.parseInt(request.getParameter("Otp"));
		HttpSession session=request.getSession();
		int otp=(Integer)session.getAttribute("Otp");
		
		
		
		RequestDispatcher dispatcher=null;
		
		
		if (value==otp) 
		{
			
				request.setAttribute("Email", request.getParameter("Email"));
				request.setAttribute("status", "success");
			  dispatcher=request.getRequestDispatcher("newpassword.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			request.setAttribute("message","驗證碼錯誤");
			
		   dispatcher=request.getRequestDispatcher("enterotp.jsp");
			dispatcher.forward(request, response);
		
		}
		
	}

}
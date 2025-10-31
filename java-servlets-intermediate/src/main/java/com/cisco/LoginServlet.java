package com.cisco;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body>");
		if(user.equals(pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			pw.print("<h4 style='color:red'>Invalid credentials</h4>");
			rd.include(request,response);
		}
		pw.print("</body></html>");
	}

}

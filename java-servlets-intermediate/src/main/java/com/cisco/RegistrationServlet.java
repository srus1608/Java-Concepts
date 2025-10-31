package com.cisco;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(
		urlPatterns = { "/RegistrationServlet" }, 
		initParams = { 
				@WebInitParam(name = "companyUrl", value = "www.cisco.com"), 
				@WebInitParam(name = "password", value = "Welcome123")
		})
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String pass = config.getInitParameter("password");
		String url = config.getInitParameter("companyUrl");
		String name = request.getParameter("name");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		String gender = request.getParameter("gender");
		String[] skills = request.getParameterValues("skills");
		PrintWriter pw = response.getWriter();
		pw.println("""
				<html><body>
				
				""");
		pw.print("<h3> Password = " + pass + ",Company URL = " + url+ "</br>");
		pw.print("Name = " + name + ",Dob = "+ dob + ", Gender = " + gender + "</br>");
		pw.print("Skills = " + Arrays.toString(skills) + "</h3>");
		pw.print("</body></html>");
	}

}

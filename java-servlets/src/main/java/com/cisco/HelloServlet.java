package com.cisco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.cisco.beans.Profile;
import com.cisco.dao.ProfileDao;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String username = "Alex";
		writer.print("<html><body>");
		writer.print("<h2>Hello "+username+"</h2>");
		writer.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfileDao dao = new ProfileDao();
		PrintWriter out = response.getWriter();
		// read the input parameters name and dob
		// String name = request.getParameter("name");
		//LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		Profile profile = new Profile();
		profile.setName(request.getParameter("name")); // profile.setName(request.getParameter("name"))
		profile.setDob(LocalDate.parse(request.getParameter("dob")));
		Profile createdProfile = dao.save(profile);
		out.print("<html><body>");
		out.print("<h2>Profile created with an id = "+createdProfile.getId()+"</h2>");
		out.print("<h3>"+createdProfile+"</h3>");
		out.print("</body></html>");
	}

}
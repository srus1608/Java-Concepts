package com.cisco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
		HttpSession session = request.getSession();
		session.setAttribute("key1", item);
		PrintWriter pw = response.getWriter();
		pw.print("""
					<html>
					<body>
						<form action="SecondServlet" method="post">
							<label>Enter item2</label>
							<input type="text" name="item2"/>
							<input type ="submit" value="Add" />
				
						</form>""");
		pw.print("<h3> Selected items: " + item + "</h3></body></html>");
						
				
}

}

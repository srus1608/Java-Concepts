package com.cisco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; // Import ArrayList
import java.util.List;      // Import List

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cartservlet")
public class Cartservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        
        HttpSession session = request.getSession();
        
        // Retrieve the cart from the session. It's a List of String arrays (name, price).
        List<String[]> cartItems = (List<String[]>) session.getAttribute("cartItems");
        
        // If cart doesn't exist in the session, create a new one
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }
        
        // Add the new item to the cart
        cartItems.add(new String[]{name, price});
        
        // Store the updated cart back in the session
        session.setAttribute("cartItems", cartItems);
        
        response.setContentType("text/html"); // Set content type for proper rendering
        PrintWriter pw = response.getWriter();
        
        pw.print("<html><body>");
        pw.print("<h2>Your Shopping Cart</h2>");
        
        if (cartItems.isEmpty()) {
            pw.print("<p>Your cart is empty.</p>");
        } else {
            pw.print("<h3>Items in Cart:</h3>");
            pw.print("<ul>");
            for (String[] item : cartItems) {
                pw.print("<li>" + item[0] + " - $" + item[1] + "</li>");
            }
            pw.print("</ul>");
        }
        
        // Form to proceed to checkout
        pw.print("<form action='CheckoutServlet' method='post'>");
        pw.print("<input type='submit' value='Proceed to Checkout'>");
        pw.print("</form>");
        
        // Link back to the product adding page
        pw.print("<p><a href='addProduct.html'>Add more items</a></p>"); 
        
        pw.print("</body></html>");
    }

}
package com.cisco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List; // Import List

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Retrieve the cart from the session
        List<String[]> cartItems = (List<String[]>) session.getAttribute("cartItems");
        
        response.setContentType("text/html"); // Set content type
        PrintWriter pw = response.getWriter();
        
        pw.print("<html><body>");
        pw.print("<h2 style='color:blue'>Checkout Summary</h2>");
        
        double totalPrice = 0.0;
        
        if (cartItems == null || cartItems.isEmpty()) {
            pw.print("<p>Your cart is empty. No items to checkout.</p>");
        } else {
            pw.print("<h3 style='color:green'>Selected Items:</h3>");
            pw.print("<ul>");
            for (String[] item : cartItems) {
                String name = item[0];
                String priceStr = item[1];
                double itemPrice = 0.0;
                try {
                    itemPrice = Double.parseDouble(priceStr);
                } catch (NumberFormatException e) {
                    // Handle cases where price is not a valid number
                    System.err.println("Invalid price format for item: " + name + " - " + priceStr);
                }
                
                pw.print("<li>" + name + " - $" + String.format("%.2f", itemPrice) + "</li>");
                totalPrice += itemPrice;
            }
            pw.print("</ul>");
            pw.print("<h3 style='color:green'>Total Price: $" + String.format("%.2f", totalPrice) + "</h3>");
        }
        
        pw.print("<p><a href='addProduct.html'>Continue Shopping</a></p>"); // Link back to add product page
        pw.print("</body></html>");
    }

}
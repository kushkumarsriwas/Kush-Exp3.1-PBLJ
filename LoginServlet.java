package com.example.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get values from the HTML form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple hardcoded check
        if ("admin".equals(username) && "12345".equals(password)) {
            // Valid login → forward to welcome page
            request.setAttribute("username", username);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            // Invalid login → show error
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Invalid username or password!</h3>");
            out.println("<a href='index.html'>Try again</a>");
            out.println("</body></html>");
        }
    }
}

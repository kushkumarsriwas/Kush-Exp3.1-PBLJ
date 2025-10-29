package com.example.employee;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASS = "your_mysql_password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empidParam = request.getParameter("empid");

        out.println("<html><body>");
        out.println("<h2>Employee Records</h2>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs;

            if (empidParam != null && !empidParam.isEmpty()) {
                // search by EmpID
                rs = stmt.executeQuery("SELECT * FROM employee WHERE EmpID=" + empidParam);
            } else {
                // display all
                rs = stmt.executeQuery("SELECT * FROM employee");
            }

            out.println("<table border='1' cellpadding='8'>");
            out.println("<tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");

            boolean found = false;
            while (rs.next()) {
                found = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("EmpID") + "</td>");
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getDouble("Salary") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            if (!found) {
                out.println("<p>No employee found with ID: " + empidParam + "</p>");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }

        out.println("<br><a href='index.html'>Back to Search</a>");
        out.println("</body></html>");
    }
}

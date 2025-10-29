package com.example.attendance;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASS = "your_mysql_password"; // <-- change this

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String query = "INSERT INTO attendance (StudentID, Date, Status) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("success.jsp");
            } else {
                out.println("<h3>Failed to record attendance.</h3>");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Attendance Portal</title>
</head>
<body>
    <h2>Student Attendance Form</h2>
    <form action="attendance" method="post">
        <label>Student ID:</label>
        <input type="text" name="studentId" required><br><br>

        <label>Date (YYYY-MM-DD):</label>
        <input type="date" name="date" required><br><br>

        <label>Status:</label>
        <select name="status" required>
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>

        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>

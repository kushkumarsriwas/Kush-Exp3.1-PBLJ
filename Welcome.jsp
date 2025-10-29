<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String user = (String) request.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome</title>
</head>
<body>
  <h2>Welcome, <%= user %>!</h2>
  <p>You have successfully logged in.</p>
  <a href="index.html">Logout</a>
</body>
</html>

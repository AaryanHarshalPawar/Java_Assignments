<%@ page contentType="text/html; charset=UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String password = request.getParameter("password");

    // Never show the real password back; display one '*' per character instead
    String maskedPassword = "*".repeat(password.length());
%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
    <h2>Registration Successful</h2>
    <p>Welcome, <b><%= name %></b>! Your details are:</p>
    <table border="1" cellpadding="6">
        <tr><th>Name</th><td><%= name %></td></tr>
        <tr><th>Email</th><td><%= email %></td></tr>
        <tr><th>Phone Number</th><td><%= phone %></td></tr>
        <tr><th>Password</th><td><%= maskedPassword %></td></tr>
    </table>
    <p><a href="register.jsp">Register another user</a></p>
</body>
</html>

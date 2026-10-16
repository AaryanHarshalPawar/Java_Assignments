<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="registerResult.jsp" method="post">
        <table>
            <tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
            <tr><td>Email:</td><td><input type="email" name="email" required></td></tr>
            <tr><td>Phone Number:</td><td><input type="tel" name="phone" pattern="[0-9]{10}" title="10 digit number" required></td></tr>
            <tr><td>Password:</td><td><input type="password" name="password" minlength="6" required></td></tr>
            <tr><td></td><td><input type="submit" value="Register"></td></tr>
        </table>
    </form>
</body>
</html>

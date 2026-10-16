<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information Form</title>
</head>
<body>
    <h2>Enter Student Information</h2>
    <form action="studentDetails.jsp" method="post">
        <table>
            <tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
            <tr><td>Roll No:</td><td><input type="number" name="rollNo" required></td></tr>
            <tr><td>Course:</td><td><input type="text" name="course" required></td></tr>
            <tr><td>Semester:</td>
                <td>
                    <select name="semester">
                        <% for (int i = 1; i <= 8; i++) { %>
                            <option value="<%= i %>"><%= i %></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr><td>Marks (%):</td><td><input type="number" name="marks" min="0" max="100" step="0.01" required></td></tr>
            <tr><td></td><td><input type="submit" value="Submit"></td></tr>
        </table>
    </form>
</body>
</html>

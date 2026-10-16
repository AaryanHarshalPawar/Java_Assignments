<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*" %>
<%!
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");

    Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
%>
<%
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    String message = "";

    // Values used to pre-fill the form when "Edit" is clicked
    String editId = "", editName = "", editDept = "", editDesig = "", editSalary = "";

    try (Connection connection = getConnection()) {
        if ("add".equals(action)) {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO employees (name, department, designation, salary) VALUES (?, ?, ?, ?)");
            ps.setString(1, request.getParameter("name"));
            ps.setString(2, request.getParameter("department"));
            ps.setString(3, request.getParameter("designation"));
            ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));
            ps.executeUpdate();
            message = "Employee added successfully";
        } else if ("update".equals(action)) {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE employees SET name = ?, department = ?, designation = ?, salary = ? WHERE emp_id = ?");
            ps.setString(1, request.getParameter("name"));
            ps.setString(2, request.getParameter("department"));
            ps.setString(3, request.getParameter("designation"));
            ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));
            ps.setInt(5, Integer.parseInt(request.getParameter("empId")));
            int rows = ps.executeUpdate();
            message = rows > 0 ? "Employee updated successfully" : "Employee not found";
        } else if ("delete".equals(action)) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM employees WHERE emp_id = ?");
            ps.setInt(1, Integer.parseInt(request.getParameter("empId")));
            int rows = ps.executeUpdate();
            message = rows > 0 ? "Employee deleted successfully" : "Employee not found";
        } else if ("edit".equals(action)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM employees WHERE emp_id = ?");
            ps.setInt(1, Integer.parseInt(request.getParameter("empId")));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                editId = String.valueOf(rs.getInt("emp_id"));
                editName = rs.getString("name");
                editDept = rs.getString("department");
                editDesig = rs.getString("designation");
                editSalary = String.valueOf(rs.getDouble("salary"));
            }
        }
    } catch (Exception e) {
        message = "Error: " + e.getMessage();
    }
    boolean editing = !editId.isEmpty();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
    <h2>Employee Management System</h2>
    <p style="color: green;"><b><%= message %></b></p>

    <h3><%= editing ? "Update Employee" : "Add Employee" %></h3>
    <form action="employees.jsp" method="post">
        <input type="hidden" name="action" value="<%= editing ? "update" : "add" %>">
        <input type="hidden" name="empId" value="<%= editId %>">
        <table>
            <tr><td>Name:</td><td><input type="text" name="name" value="<%= editName %>" required></td></tr>
            <tr><td>Department:</td><td><input type="text" name="department" value="<%= editDept %>" required></td></tr>
            <tr><td>Designation:</td><td><input type="text" name="designation" value="<%= editDesig %>" required></td></tr>
            <tr><td>Salary:</td><td><input type="number" name="salary" step="0.01" value="<%= editSalary %>" required></td></tr>
            <tr><td></td>
                <td>
                    <input type="submit" value="<%= editing ? "Update" : "Add" %>">
                    <a href="employees.jsp">Clear</a>
                </td>
            </tr>
        </table>
    </form>

    <h3>Employee List</h3>
    <table border="1" cellpadding="6">
        <tr><th>ID</th><th>Name</th><th>Department</th><th>Designation</th><th>Salary</th><th>Actions</th></tr>
<%
    try (Connection connection = getConnection();
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery("SELECT * FROM employees ORDER BY emp_id")) {
        while (rs.next()) {
            int id = rs.getInt("emp_id");
%>
        <tr>
            <td><%= id %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getString("designation") %></td>
            <td><%= rs.getDouble("salary") %></td>
            <td>
                <a href="employees.jsp?action=edit&empId=<%= id %>">Edit</a> |
                <a href="employees.jsp?action=delete&empId=<%= id %>"
                   onclick="return confirm('Delete this employee?');">Delete</a>
            </td>
        </tr>
<%
        }
    } catch (Exception e) {
        out.println("<tr><td colspan='6'>Error: " + e.getMessage() + "</td></tr>");
    }
%>
    </table>
</body>
</html>

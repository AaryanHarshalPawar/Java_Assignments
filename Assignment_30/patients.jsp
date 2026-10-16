<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*" %>
<%!
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");
    static final String[] STATUSES = {"Admitted", "Under Treatment", "Recovered", "Discharged"};

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
    String editId = "", editName = "", editAge = "", editDisease = "", editStatus = "";

    try (Connection connection = getConnection()) {
        if ("add".equals(action)) {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO patients (name, age, disease, treatment_status) VALUES (?, ?, ?, ?)");
            ps.setString(1, request.getParameter("name"));
            ps.setInt(2, Integer.parseInt(request.getParameter("age")));
            ps.setString(3, request.getParameter("disease"));
            ps.setString(4, request.getParameter("status"));
            ps.executeUpdate();
            message = "Patient record added successfully";
        } else if ("update".equals(action)) {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE patients SET name = ?, age = ?, disease = ?, treatment_status = ? WHERE patient_id = ?");
            ps.setString(1, request.getParameter("name"));
            ps.setInt(2, Integer.parseInt(request.getParameter("age")));
            ps.setString(3, request.getParameter("disease"));
            ps.setString(4, request.getParameter("status"));
            ps.setInt(5, Integer.parseInt(request.getParameter("patientId")));
            int rows = ps.executeUpdate();
            message = rows > 0 ? "Patient record updated successfully" : "Patient not found";
        } else if ("delete".equals(action)) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM patients WHERE patient_id = ?");
            ps.setInt(1, Integer.parseInt(request.getParameter("patientId")));
            int rows = ps.executeUpdate();
            message = rows > 0 ? "Patient record deleted successfully" : "Patient not found";
        } else if ("edit".equals(action)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM patients WHERE patient_id = ?");
            ps.setInt(1, Integer.parseInt(request.getParameter("patientId")));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                editId = String.valueOf(rs.getInt("patient_id"));
                editName = rs.getString("name");
                editAge = String.valueOf(rs.getInt("age"));
                editDisease = rs.getString("disease");
                editStatus = rs.getString("treatment_status");
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
    <title>Patient Records</title>
</head>
<body>
    <h2>Hospital Patient Record System</h2>
    <p style="color: green;"><b><%= message %></b></p>

    <h3><%= editing ? "Update Patient" : "Add Patient" %></h3>
    <form action="patients.jsp" method="post">
        <input type="hidden" name="action" value="<%= editing ? "update" : "add" %>">
        <input type="hidden" name="patientId" value="<%= editId %>">
        <table>
            <tr><td>Name:</td><td><input type="text" name="name" value="<%= editName %>" required></td></tr>
            <tr><td>Age:</td><td><input type="number" name="age" min="0" max="120" value="<%= editAge %>" required></td></tr>
            <tr><td>Disease:</td><td><input type="text" name="disease" value="<%= editDisease %>" required></td></tr>
            <tr><td>Treatment Status:</td>
                <td>
                    <select name="status">
                        <% for (String status : STATUSES) { %>
                            <option <%= status.equals(editStatus) ? "selected" : "" %>><%= status %></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr><td></td>
                <td>
                    <input type="submit" value="<%= editing ? "Update" : "Add" %>">
                    <a href="patients.jsp">Clear</a>
                </td>
            </tr>
        </table>
    </form>

    <h3>Patient List</h3>
    <table border="1" cellpadding="6">
        <tr><th>Patient ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th><th>Actions</th></tr>
<%
    try (Connection connection = getConnection();
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery("SELECT * FROM patients ORDER BY patient_id")) {
        while (rs.next()) {
            int id = rs.getInt("patient_id");
%>
        <tr>
            <td><%= id %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
            <td>
                <a href="patients.jsp?action=edit&patientId=<%= id %>">Edit</a> |
                <a href="patients.jsp?action=delete&patientId=<%= id %>"
                   onclick="return confirm('Delete this patient record?');">Delete</a>
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

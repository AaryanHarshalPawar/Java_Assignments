<%@ page contentType="text/html; charset=UTF-8" %>
<%!
    // Declaration: a method available to the whole page
    String getGrade(double marks) {
        if (marks >= 75) return "Distinction";
        if (marks >= 60) return "First Class";
        if (marks >= 50) return "Second Class";
        if (marks >= 40) return "Pass";
        return "Fail";
    }
%>
<%
    // Scriptlet: read the submitted form values
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String rollNo = request.getParameter("rollNo");
    String course = request.getParameter("course");
    String semester = request.getParameter("semester");
    double marks = Double.parseDouble(request.getParameter("marks"));
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h2>Student Details</h2>
    <table border="1" cellpadding="6">
        <tr><th>Name</th><td><%= name %></td></tr>
        <tr><th>Roll No</th><td><%= rollNo %></td></tr>
        <tr><th>Course</th><td><%= course %></td></tr>
        <tr><th>Semester</th><td><%= semester %></td></tr>
        <tr><th>Marks</th><td><%= marks %> %</td></tr>
        <tr><th>Grade</th><td><%= getGrade(marks) %></td></tr>
    </table>
    <p><a href="studentForm.jsp">Enter another student</a></p>
</body>
</html>

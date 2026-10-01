import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDataModification {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");

    static void displayEmployees(Connection connection, String heading) throws SQLException {
        System.out.println(heading);
        System.out.printf("%-6s %-14s %-10s %s%n", "ID", "Name", "Dept", "Salary");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
        while (resultSet.next()) {
            System.out.printf("%-6d %-14s %-10s %.2f%n", resultSet.getInt("emp_id"), resultSet.getString("emp_name"),
                    resultSet.getString("department"), resultSet.getDouble("salary"));
        }
        resultSet.close();
        statement.close();
        System.out.println();
    }

    static void insertEmployee(Connection connection, int empId, String empName, String department, double salary)
            throws SQLException {
        PreparedStatement insert = connection.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?)");
        insert.setInt(1, empId);
        insert.setString(2, empName);
        insert.setString(3, department);
        insert.setDouble(4, salary);
        int rowsAffected = insert.executeUpdate();
        System.out.println("INSERT -> " + empName + " added (" + rowsAffected + " row affected)");
        insert.close();
    }

    static void updateSalary(Connection connection, int empId, double newSalary) throws SQLException {
        PreparedStatement update = connection.prepareStatement("UPDATE employees SET salary = ? WHERE emp_id = ?");
        update.setDouble(1, newSalary);
        update.setInt(2, empId);
        int rowsAffected = update.executeUpdate();
        System.out.println("UPDATE -> salary of employee " + empId + " set to " + newSalary + " (" + rowsAffected + " row affected)");
        update.close();
    }

    static void deleteEmployee(Connection connection, int empId) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("DELETE FROM employees WHERE emp_id = ?");
        delete.setInt(1, empId);
        int rowsAffected = delete.executeUpdate();
        if (rowsAffected == 0) {
            System.out.println("DELETE -> no employee found with ID " + empId + " (0 rows affected)");
        } else {
            System.out.println("DELETE -> employee " + empId + " removed (" + rowsAffected + " row affected)");
        }
        delete.close();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database: " + connection.getCatalog() + "\n");

            displayEmployees(connection, "Employees before modification:");
            insertEmployee(connection, 204, "Pooja Nair", "Finance", 47000);
            insertEmployee(connection, 205, "Arjun Singh", "IT", 51000);
            updateSalary(connection, 202, 41500);
            deleteEmployee(connection, 201);
            deleteEmployee(connection, 999);
            System.out.println();
            displayEmployees(connection, "Employees after modification:");

            connection.close();
            System.out.println("Connection closed.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRecordRetrieval {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");

    static void selectStudents(Statement statement, String heading, String query) throws SQLException {
        System.out.println(heading);
        System.out.printf("%-8s %-16s %-8s %s%n", "Roll No", "Name", "Course", "Marks");
        ResultSet resultSet = statement.executeQuery(query);
        int recordCount = 0;
        while (resultSet.next()) {
            System.out.printf("%-8d %-16s %-8s %d%n", resultSet.getInt("roll_no"), resultSet.getString("student_name"),
                    resultSet.getString("course"), resultSet.getInt("marks"));
            recordCount++;
        }
        resultSet.close();
        System.out.println("Records retrieved: " + recordCount + "\n");
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database: " + connection.getCatalog() + "\n");
            Statement statement = connection.createStatement();

            selectStudents(statement, "1. All students", "SELECT * FROM students");
            selectStudents(statement, "2. Students scoring above 80", "SELECT * FROM students WHERE marks > 80");
            selectStudents(statement, "3. BCA students ordered by marks",
                    "SELECT * FROM students WHERE course = 'BCA' ORDER BY marks DESC");

            ResultSet summary = statement.executeQuery("SELECT COUNT(*), AVG(marks), MAX(marks) FROM students");
            if (summary.next()) {
                System.out.println("4. Summary of students table");
                System.out.println("Total students : " + summary.getInt(1));
                System.out.printf("Average marks  : %.2f%n", summary.getDouble(2));
                System.out.println("Highest marks  : " + summary.getInt(3));
            }
            summary.close();
            statement.close();
            connection.close();
            System.out.println("\nConnection closed.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

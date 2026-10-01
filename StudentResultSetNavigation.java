import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentResultSetNavigation {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");

    static void showRow(String method, ResultSet resultSet) throws SQLException {
        System.out.printf("%-14s -> row %d : %d  %-16s %-7s %d%n", method, resultSet.getRow(), resultSet.getInt("roll_no"),
                resultSet.getString("student_name"), resultSet.getString("course"), resultSet.getInt("marks"));
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            System.out.println("Forward navigation using next():");
            while (resultSet.next()) {
                showRow("next()", resultSet);
            }

            System.out.println("\nBackward navigation using previous():");
            resultSet.afterLast();
            while (resultSet.previous()) {
                showRow("previous()", resultSet);
            }

            System.out.println("\nDirect positioning:");
            resultSet.first();
            showRow("first()", resultSet);
            System.out.println("isFirst()      -> " + resultSet.isFirst());
            resultSet.last();
            showRow("last()", resultSet);
            System.out.println("isLast()       -> " + resultSet.isLast() + ", total rows = " + resultSet.getRow());
            resultSet.absolute(3);
            showRow("absolute(3)", resultSet);
            resultSet.relative(2);
            showRow("relative(2)", resultSet);
            resultSet.relative(-3);
            showRow("relative(-3)", resultSet);
            resultSet.absolute(-2);
            showRow("absolute(-2)", resultSet);
            resultSet.beforeFirst();
            System.out.println("beforeFirst()  -> isBeforeFirst() = " + resultSet.isBeforeFirst());
            resultSet.afterLast();
            System.out.println("afterLast()    -> isAfterLast() = " + resultSet.isAfterLast());

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class JdbcCoreClassesDemo {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static void main(String[] args) {
        try {
            System.out.println("===== DriverManager =====");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                System.out.println("Registered driver : " + driver.getClass().getName() + " (version "
                        + driver.getMajorVersion() + "." + driver.getMinorVersion() + ")");
            }
            DriverManager.setLoginTimeout(10);
            System.out.println("Login timeout     : " + DriverManager.getLoginTimeout() + " seconds");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("\n===== Connection =====");
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database          : " + metaData.getDatabaseProductName() + " " + metaData.getDatabaseProductVersion());
            System.out.println("Driver name       : " + metaData.getDriverName());
            System.out.println("Catalog           : " + connection.getCatalog());
            System.out.println("Connection valid  : " + connection.isValid(5));
            System.out.println("Auto-commit       : " + connection.getAutoCommit());

            System.out.println("\n===== Statement =====");
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS courses");
            boolean hasResultSet = statement.execute(
                    "CREATE TABLE courses (course_id INT PRIMARY KEY, course_name VARCHAR(40), credits INT)");
            System.out.println("execute(CREATE TABLE) returned a ResultSet : " + hasResultSet);
            int rowsInserted = statement.executeUpdate("INSERT INTO courses VALUES (1, 'Programming with Java', 4)");
            System.out.println("executeUpdate(INSERT) rows affected        : " + rowsInserted);

            statement.addBatch("INSERT INTO courses VALUES (2, 'Data Structures', 4)");
            statement.addBatch("INSERT INTO courses VALUES (3, 'Computer Networks', 3)");
            statement.addBatch("INSERT INTO courses VALUES (4, 'Web Technologies', 2)");
            int[] batchResults = statement.executeBatch();
            System.out.println("executeBatch() statements executed         : " + batchResults.length);

            connection.setAutoCommit(false);
            int rowsChanged = statement.executeUpdate("UPDATE courses SET credits = 0");
            connection.rollback();
            connection.setAutoCommit(true);
            System.out.println("UPDATE changed " + rowsChanged + " rows, then Connection.rollback() undid it");

            System.out.println("\nexecuteQuery(SELECT * FROM courses):");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
            while (resultSet.next()) {
                System.out.printf("%-3d %-24s %d credits%n", resultSet.getInt("course_id"),
                        resultSet.getString("course_name"), resultSet.getInt("credits"));
            }
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("\nConnection closed : " + connection.isClosed());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

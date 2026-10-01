import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ProductInventoryQuery {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");

    static void printProducts(ResultSet resultSet) throws SQLException {
        int productCount = 0;
        while (resultSet.next()) {
            System.out.printf("%-5d %-18s %-12s %8.2f %5d%n", resultSet.getInt("product_id"),
                    resultSet.getString("product_name"), resultSet.getString("category"),
                    resultSet.getDouble("price"), resultSet.getInt("stock"));
            productCount++;
        }
        if (productCount == 0) {
            System.out.println("No matching products found");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement byCategory = connection.prepareStatement("SELECT * FROM products WHERE category = ?");
            for (String category : new String[] {"Electronics", "Stationery"}) {
                byCategory.setString(1, category);
                System.out.println("Products in category '" + category + "':");
                ResultSet resultSet = byCategory.executeQuery();
                printProducts(resultSet);
                resultSet.close();
            }

            PreparedStatement byPriceRange = connection.prepareStatement(
                    "SELECT * FROM products WHERE price BETWEEN ? AND ? ORDER BY price");
            byPriceRange.setDouble(1, 100);
            byPriceRange.setDouble(2, 1500);
            System.out.println("Products priced between 100 and 1500:");
            ResultSet priceResult = byPriceRange.executeQuery();
            ResultSetMetaData metaData = priceResult.getMetaData();
            printProducts(priceResult);
            priceResult.close();

            System.out.println("ResultSetMetaData: " + metaData.getColumnCount() + " columns");
            for (int column = 1; column <= metaData.getColumnCount(); column++) {
                System.out.println("  " + metaData.getColumnName(column) + " -> " + metaData.getColumnTypeName(column));
            }

            PreparedStatement updateStock = connection.prepareStatement("UPDATE products SET stock = ? WHERE product_id = ?");
            updateStock.setInt(1, 35);
            updateStock.setInt(2, 303);
            System.out.println("\nStock of product 303 set to 35 (" + updateStock.executeUpdate() + " row updated)\n");

            PreparedStatement byName = connection.prepareStatement("SELECT * FROM products WHERE product_name = ?");
            String maliciousInput = "' OR '1'='1";
            byName.setString(1, maliciousInput);
            System.out.println("Search by name with input: " + maliciousInput);
            ResultSet injectionResult = byName.executeQuery();
            printProducts(injectionResult);
            System.out.println("PreparedStatement treated the input as plain text, so SQL injection failed.");

            injectionResult.close();
            byCategory.close();
            byPriceRange.close();
            updateStock.close();
            byName.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

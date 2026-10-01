import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookManagementGUI {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = System.getenv("DB_PASSWORD");
    static final Color SUCCESS_COLOR = new Color(0, 128, 0);

    static JTextField bookIdField = new JTextField();
    static JTextField titleField = new JTextField();
    static JTextField authorField = new JTextField();
    static JTextField priceField = new JTextField();
    static DefaultTableModel tableModel = new DefaultTableModel(new String[] {"Book ID", "Title", "Author", "Price"}, 0);
    static JLabel statusLabel = new JLabel(" ");

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void showStatus(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setForeground(color);
    }

    static void loadBooks() {
        tableModel.setRowCount(0);
        try (Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM books ORDER BY book_id")) {
            while (resultSet.next()) {
                tableModel.addRow(new Object[] {resultSet.getInt("book_id"), resultSet.getString("title"),
                        resultSet.getString("author"), resultSet.getDouble("price")});
            }
        } catch (SQLException e) {
            showStatus("Error: " + e.getMessage(), Color.RED);
        }
    }

    static boolean fieldsAreEmpty() {
        return titleField.getText().trim().isEmpty() || authorField.getText().trim().isEmpty();
    }

    static void addBook() {
        if (fieldsAreEmpty()) {
            showStatus("Title and Author cannot be empty", Color.RED);
            return;
        }
        try (Connection connection = getConnection();
                PreparedStatement insert = connection.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?)")) {
            insert.setInt(1, Integer.parseInt(bookIdField.getText().trim()));
            insert.setString(2, titleField.getText().trim());
            insert.setString(3, authorField.getText().trim());
            insert.setDouble(4, Double.parseDouble(priceField.getText().trim()));
            insert.executeUpdate();
            showStatus("Book added successfully", SUCCESS_COLOR);
            loadBooks();
        } catch (NumberFormatException e) {
            showStatus("Book ID and Price must be numbers", Color.RED);
        } catch (SQLException e) {
            showStatus("Error: " + e.getMessage(), Color.RED);
        }
    }

    static void updateBook() {
        if (fieldsAreEmpty()) {
            showStatus("Title and Author cannot be empty", Color.RED);
            return;
        }
        try (Connection connection = getConnection();
                PreparedStatement update = connection.prepareStatement(
                        "UPDATE books SET title = ?, author = ?, price = ? WHERE book_id = ?")) {
            update.setString(1, titleField.getText().trim());
            update.setString(2, authorField.getText().trim());
            update.setDouble(3, Double.parseDouble(priceField.getText().trim()));
            update.setInt(4, Integer.parseInt(bookIdField.getText().trim()));
            int rowsUpdated = update.executeUpdate();
            showStatus(rowsUpdated > 0 ? "Book updated successfully" : "No book found with that ID",
                    rowsUpdated > 0 ? SUCCESS_COLOR : Color.RED);
            loadBooks();
        } catch (NumberFormatException e) {
            showStatus("Book ID and Price must be numbers", Color.RED);
        } catch (SQLException e) {
            showStatus("Error: " + e.getMessage(), Color.RED);
        }
    }

    static void deleteBook() {
        try (Connection connection = getConnection();
                PreparedStatement delete = connection.prepareStatement("DELETE FROM books WHERE book_id = ?")) {
            delete.setInt(1, Integer.parseInt(bookIdField.getText().trim()));
            int rowsDeleted = delete.executeUpdate();
            showStatus(rowsDeleted > 0 ? "Book deleted successfully" : "No book found with that ID",
                    rowsDeleted > 0 ? SUCCESS_COLOR : Color.RED);
            loadBooks();
        } catch (NumberFormatException e) {
            showStatus("Enter a valid Book ID to delete", Color.RED);
        } catch (SQLException e) {
            showStatus("Error: " + e.getMessage(), Color.RED);
        }
    }

    static void clearFields() {
        bookIdField.setText("");
        titleField.setText("");
        authorField.setText("");
        priceField.setText("");
        showStatus(" ", Color.BLACK);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Book Management System");
        frame.setSize(620, 440);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 8));
        formPanel.add(new JLabel("  Book ID:"));
        formPanel.add(bookIdField);
        formPanel.add(new JLabel("  Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("  Author:"));
        formPanel.add(authorField);
        formPanel.add(new JLabel("  Price:"));
        formPanel.add(priceField);

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JTable bookTable = new JTable(tableModel);
        bookTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = bookTable.getSelectedRow();
            if (selectedRow >= 0) {
                bookIdField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                titleField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                authorField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                priceField.setText(tableModel.getValueAt(selectedRow, 3).toString());
            }
        });

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        clearButton.addActionListener(e -> clearFields());

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(bookTable), BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        loadBooks();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

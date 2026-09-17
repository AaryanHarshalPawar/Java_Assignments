import javax.swing.*;
import java.awt.*;

public class EmployeeRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Registration Form");
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField employeeIdField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField departmentField = new JTextField();
        JTextField salaryField = new JTextField();
        JButton submitButton = new JButton("Submit");

        frame.add(new JLabel("  Employee ID:"));
        frame.add(employeeIdField);
        frame.add(new JLabel("  Name:"));
        frame.add(nameField);
        frame.add(new JLabel("  Department:"));
        frame.add(departmentField);
        frame.add(new JLabel("  Salary:"));
        frame.add(salaryField);
        frame.add(new JLabel(""));
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String details = "Employee ID: " + employeeIdField.getText()
                    + "\nName: " + nameField.getText()
                    + "\nDepartment: " + departmentField.getText()
                    + "\nSalary: " + salaryField.getText();
            JOptionPane.showMessageDialog(frame, details, "Employee Details", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

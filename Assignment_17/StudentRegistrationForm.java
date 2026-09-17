import javax.swing.*;
import java.awt.*;

public class StudentRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField rollNumberField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField emailField = new JTextField();
        JButton registerButton = new JButton("Register");

        frame.add(new JLabel("  Name:"));
        frame.add(nameField);
        frame.add(new JLabel("  Roll Number:"));
        frame.add(rollNumberField);
        frame.add(new JLabel("  Course:"));
        frame.add(courseField);
        frame.add(new JLabel("  Email:"));
        frame.add(emailField);
        frame.add(new JLabel(""));
        frame.add(registerButton);

        registerButton.addActionListener(e -> {
            String details = "Name: " + nameField.getText()
                    + "\nRoll Number: " + rollNumberField.getText()
                    + "\nCourse: " + courseField.getText()
                    + "\nEmail: " + emailField.getText();
            JOptionPane.showMessageDialog(frame, details, "Student Registered", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(350, 220);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JTextField firstNumberField = new JTextField();
        JTextField secondNumberField = new JTextField();
        JButton addButton = new JButton("Add (+)");
        JButton subtractButton = new JButton("Subtract (-)");
        JLabel resultLabel = new JLabel("0");

        frame.add(new JLabel("  First Number:"));
        frame.add(firstNumberField);
        frame.add(new JLabel("  Second Number:"));
        frame.add(secondNumberField);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(new JLabel("  Result:"));
        frame.add(resultLabel);

        addButton.addActionListener(e -> {
            double first = Double.parseDouble(firstNumberField.getText());
            double second = Double.parseDouble(secondNumberField.getText());
            resultLabel.setText(String.valueOf(first + second));
        });

        subtractButton.addActionListener(e -> {
            double first = Double.parseDouble(firstNumberField.getText());
            double second = Double.parseDouble(secondNumberField.getText());
            resultLabel.setText(String.valueOf(first - second));
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;

public class BankBalanceCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Balance Calculator");
        frame.setSize(380, 220);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JTextField initialBalanceField = new JTextField();
        JTextField transactionAmountField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JLabel updatedBalanceLabel = new JLabel("0.0");

        frame.add(new JLabel("  Initial Balance:"));
        frame.add(initialBalanceField);
        frame.add(new JLabel("  Transaction Amount:"));
        frame.add(transactionAmountField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(new JLabel("  Updated Balance:"));
        frame.add(updatedBalanceLabel);

        depositButton.addActionListener(e -> {
            double balance = Double.parseDouble(initialBalanceField.getText());
            double amount = Double.parseDouble(transactionAmountField.getText());
            updatedBalanceLabel.setText(String.valueOf(balance + amount));
        });

        withdrawButton.addActionListener(e -> {
            double balance = Double.parseDouble(initialBalanceField.getText());
            double amount = Double.parseDouble(transactionAmountField.getText());
            if (amount > balance) {
                updatedBalanceLabel.setText("Insufficient balance");
            } else {
                updatedBalanceLabel.setText(String.valueOf(balance - amount));
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

package oop.BankManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import oop.BankManagementsystem.UserDetails; 

public class BankManagementUI extends JFrame {

    private JTextField nameField;
    private JTextField initialBalanceField;
    private JLabel accNumLabel;
    private JLabel holderLabel;
    private JLabel balanceLabel;

    private JTextField depositField;
    private JTextField withdrawField;

    private UserDetails currentUser;

    public BankManagementUI() {
        setTitle("Bank Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center

        initComponents();
    }

    private void initComponents() {
        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Account creation
        panel.add(new JLabel("Account Holder Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Initial Balance:"));
        initialBalanceField = new JTextField();
        panel.add(initialBalanceField);

        JButton createBtn = new JButton("Create Account");
        panel.add(createBtn);
        panel.add(new JLabel("")); // empty placeholder

        // Account info labels
        panel.add(new JLabel("Account Number:"));
        accNumLabel = new JLabel("-");
        panel.add(accNumLabel);

        panel.add(new JLabel("Holder Name:"));
        holderLabel = new JLabel("-");
        panel.add(holderLabel);

        panel.add(new JLabel("Current Balance:"));
        balanceLabel = new JLabel("0.0");
        panel.add(balanceLabel);

        // Deposit
        panel.add(new JLabel("Deposit Amount:"));
        depositField = new JTextField();
        panel.add(depositField);

        JButton depositBtn = new JButton("Deposit");
        panel.add(depositBtn);
        panel.add(new JLabel(""));

        // Withdraw
        panel.add(new JLabel("Withdraw Amount:"));
        withdrawField = new JTextField();
        panel.add(withdrawField);

        JButton withdrawBtn = new JButton("Withdraw");
        panel.add(withdrawBtn);
        panel.add(new JLabel(""));

        add(panel);

        // Button actions

        // Create account
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String balText = initialBalanceField.getText().trim();

                if (name.isEmpty() || balText.isEmpty()) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Enter name and initial balance",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double initialBal = Double.parseDouble(balText);
                    if (initialBal < 0) {
                        JOptionPane.showMessageDialog(BankManagementUI.this,
                                "Initial balance cannot be negative",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    currentUser = new UserDetails(name, initialBal);
                    accNumLabel.setText(String.valueOf(currentUser.getNumber()));
                    holderLabel.setText(currentUser.getAccHolder());
                    balanceLabel.setText(String.valueOf(currentUser.getBalance()));

                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Account created successfully!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Enter a valid number for balance",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Deposit button
        depositBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Create an account first!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String amountText = depositField.getText().trim();
                if (amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Enter deposit amount",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double amount = Double.parseDouble(amountText);
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(BankManagementUI.this,
                                "Amount must be positive",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    currentUser.deposit(amount);
                    balanceLabel.setText(String.valueOf(currentUser.getBalance()));
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Deposited: " + amount);
                    depositField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Enter a valid number",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Withdraw button
        withdrawBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Create an account first!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String amountText = withdrawField.getText().trim();
                if (amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Enter withdrawal amount",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double amount = Double.parseDouble(amountText);
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(BankManagementUI.this,
                                "Amount must be positive",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double before = currentUser.getBalance();
                    currentUser.withdraw(amount);
                    double after = currentUser.getBalance();

                    if (after < before) {
                        JOptionPane.showMessageDialog(BankManagementUI.this,
                                "Withdrawn: " + amount);
                    } else {
                        JOptionPane.showMessageDialog(BankManagementUI.this,
                                "Withdrawal failed (check console)",
                                "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    balanceLabel.setText(String.valueOf(currentUser.getBalance()));
                    withdrawField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BankManagementUI.this,
                            "Enter a valid number",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankManagementUI().setVisible(true);
        });
    }
}

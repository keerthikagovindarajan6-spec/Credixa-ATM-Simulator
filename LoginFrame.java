import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public static String currentPin = "1234";

    JTextField accountField;
    JPasswordField pinField;
    JButton loginButton;

    public LoginFrame() {

        setTitle("CREDIXA ATM");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(15, 23, 42));

        // Bank Title
        JLabel bankTitle = new JLabel("CREDIXA BANK");
        bankTitle.setForeground(Color.WHITE);
        bankTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
        bankTitle.setBounds(300, 30, 350, 50);
        panel.add(bankTitle);

        JLabel slogan = new JLabel("Secure Digital Banking System");
        slogan.setForeground(new Color(180, 190, 210));
        slogan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        slogan.setBounds(310, 75, 300, 30);
        panel.add(slogan);

        // Login Card
        JPanel card = new JPanel(null);
        card.setBackground(Color.WHITE);
        card.setBounds(250, 130, 400, 330);
        card.setBorder(new LineBorder(new Color(220,220,220), 2, true));

        JLabel welcome = new JLabel("Welcome Back 👋");
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcome.setBounds(90, 20, 250, 40);
        card.add(welcome);

        JLabel accLabel = new JLabel("Account Number");
        accLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        accLabel.setBounds(40, 90, 150, 25);
        card.add(accLabel);

        accountField = new JTextField();
        accountField.setBounds(40, 120, 320, 40);
        accountField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        card.add(accountField);

        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pinLabel.setBounds(40, 180, 150, 25);
        card.add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(40, 210, 320, 40);
        pinField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        card.add(pinField);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(100, 275, 200, 45);
        loginButton.setBackground(new Color(59,130,246));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        card.add(loginButton);

        panel.add(card);

        // Footer
        JLabel footer = new JLabel("© 2026 CREDIXA BANK - Secure Banking");
        footer.setForeground(Color.WHITE);
        footer.setBounds(320, 520, 300, 30);
        panel.add(footer);

        loginButton.addActionListener(e -> {

            String account = accountField.getText();
            String pin = new String(pinField.getPassword());

            if(account.equals("1001") && pin.equals(currentPin)) {

                new DashboardFrame("Kiruthika");
                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Account Number or PIN"
                );
            }
        });

        add(panel);
        setVisible(true);
    }
}
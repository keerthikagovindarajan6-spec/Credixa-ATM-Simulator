import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DashboardFrame extends JFrame {

    double balance = 5000;
    String statement = "";
    JLabel balanceAmount;

    public DashboardFrame(String userName) {

        setTitle("CREDIXA DIGITAL BANKING");
        setSize(1280, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(new Color(236,242,248));

        JPanel sidebar = new JPanel(null);
        sidebar.setBackground(new Color(13,27,42));
        sidebar.setBounds(0,0,250,820);

        JLabel logo = new JLabel("CREDIXA");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        logo.setBounds(45,30,180,40);
        sidebar.add(logo);

        String[] items = {"Dashboard","Transactions","Statement","Security","Logout"};
        int y = 120;
        for(String item : items){
            JButton b = new JButton(item);
            b.setBounds(20,y,200,45);
            b.setFocusPainted(false);
            b.setBackground(new Color(31,41,55));
            b.setForeground(Color.WHITE);
            sidebar.add(b);
            y += 70;
        }

        JPanel header = new JPanel(null);
        header.setBackground(Color.WHITE);
        header.setBounds(250,0,1030,90);

        JLabel welcomeTop = new JLabel("Welcome Back, " + userName + " 👋");
        welcomeTop.setFont(new Font("Segoe UI", Font.BOLD, 28));
        welcomeTop.setBounds(30,20,500,40);
        header.add(welcomeTop);

        

        JPanel welcomeCard = new JPanel(null);
        welcomeCard.setBackground(Color.WHITE);
        welcomeCard.setBorder(new LineBorder(new Color(220,220,220),1,true));
        welcomeCard.setBounds(290,120,930,140);
        JLabel subText = new JLabel("Premium Banking Dashboard • Secure Session Active");
subText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
subText.setForeground(Color.GRAY);
subText.setBounds(30,75,500,25);
welcomeCard.add(subText);

        JLabel msg = new JLabel("Manage your banking activities securely");
        msg.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        msg.setBounds(30,40,500,30);
        welcomeCard.add(msg);

        JPanel balanceCard = new JPanel(null);
        balanceCard.setBackground(new Color(37,99,235));
        balanceCard.setBounds(290,290,450,210);
        
        JLabel active = new JLabel("● Active Account");
active.setForeground(Color.WHITE);
active.setFont(new Font("Segoe UI", Font.PLAIN, 16));
active.setBounds(25,150,200,25);
balanceCard.add(active);

        JLabel balTitle = new JLabel("Current Balance");
        balTitle.setForeground(Color.WHITE);
        balTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        balTitle.setBounds(25,20,250,40);

        balanceAmount = new JLabel("₹ " + balance);
        balanceAmount.setForeground(Color.WHITE);
        balanceAmount.setFont(new Font("Segoe UI", Font.BOLD, 42));
        balanceAmount.setBounds(25,80,300,50);

        balanceCard.add(balTitle);
        balanceCard.add(balanceAmount);

        JPanel depositCard = new JPanel(null);
        depositCard.setBackground(new Color(16,185,129));
        depositCard.setBounds(780,280,200,180);

        JLabel dep = new JLabel("DEPOSIT");
        dep.setForeground(Color.WHITE);
        dep.setFont(new Font("Segoe UI", Font.BOLD, 18));
        dep.setBounds(50,20,120,30);
        depositCard.add(dep);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(35,90,120,40);
        depositCard.add(depositBtn);

        depositBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this,"Enter Deposit Amount");
            if(input != null && !input.isEmpty()){
                double amount = Double.parseDouble(input);
                balance += amount;
            statement += "✓ Deposit  ₹" + amount + "\n";
                balanceAmount.setText("₹ " + balance);
                JOptionPane.showMessageDialog(
    this,
    "₹ " + amount + " Deposited Successfully!"
);
            }
        });

        JPanel withdrawCard = new JPanel(null);
        withdrawCard.setBackground(new Color(220,38,38));
        withdrawCard.setBounds(1020,280,200,180);

        JLabel wd = new JLabel("WITHDRAW");
        wd.setForeground(Color.WHITE);
        wd.setFont(new Font("Segoe UI", Font.BOLD, 18));
        wd.setBounds(40,20,120,30);
        withdrawCard.add(wd);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(35,90,120,40);
        withdrawCard.add(withdrawBtn);

        withdrawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this,"Enter Withdraw Amount");
            if(input != null && !input.isEmpty()){
                double amount = Double.parseDouble(input);
                if(amount <= balance){
                    balance -= amount;
                    statement += "✓ Withdraw ₹" + amount + "\n";
                    balanceAmount.setText("₹ " + balance);
                    JOptionPane.showMessageDialog(
    this,
    "₹ " + amount + " Withdrawn Successfully!"
);
                }
            }
        });

        JPanel statementCard = new JPanel(null);
        statementCard.setBackground(new Color(124,58,237));
        statementCard.setBounds(290,530,450,140);

        JButton statementBtn = new JButton("Mini Statement");
        statementBtn.setBounds(130,70,180,50);
        statementCard.add(statementBtn);

        statementBtn.addActionListener(e -> {

    JFrame historyFrame = new JFrame("Transaction History");
    historyFrame.setSize(500,400);
    historyFrame.setLocationRelativeTo(this);

    JTextArea area = new JTextArea();
    area.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    area.setEditable(false);

    if(statement.isEmpty()) {
        area.setText("No Transactions Yet");
    } else {
        area.setText(statement);
    }

    JScrollPane scrollPane = new JScrollPane(area);

    historyFrame.add(scrollPane);
    historyFrame.setVisible(true);
});

        JPanel pinCard = new JPanel(null);
       pinCard.setBackground(new Color(245,158,11));
        pinCard.setBounds(780,500,200,180);

        JButton pinBtn = new JButton("Change PIN");
        pinBtn.setBounds(30,70,130,50);
        pinCard.add(pinBtn);

        pinBtn.addActionListener(e -> {
            String newPin = JOptionPane.showInputDialog(this,"Enter New PIN");
            if(newPin != null && !newPin.isEmpty()){
                LoginFrame.currentPin = newPin;
                JOptionPane.showMessageDialog(this,"PIN Changed Successfully");
            }
        });

        JPanel logoutCard = new JPanel(null);
        logoutCard.setBackground(new Color(107,114,128));
        logoutCard.setBounds(1020,500,200,180);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(40,70,120,50);
        logoutCard.add(logoutBtn);

        logoutBtn.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        mainPanel.add(sidebar);
        mainPanel.add(header);
        mainPanel.add(welcomeCard);
        mainPanel.add(balanceCard);
        JPanel accountCard = new JPanel(null);
accountCard.setBackground(Color.WHITE);
accountCard.setBorder(new LineBorder(new Color(220,220,220),1,true));
accountCard.setBounds(850,120,370,120);

JLabel accTitle = new JLabel("Account Information");
JLabel accType = new JLabel("Savings Account");
accType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
accType.setBounds(20,50,200,25);

accountCard.add(accType);
accTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
accTitle.setBounds(20,15,250,30);

JLabel holder = new JLabel("Account Holder : Kiruthika");
holder.setFont(new Font("Segoe UI", Font.PLAIN, 16));
holder.setBounds(20,60,300,25);

JLabel accNo = new JLabel("Account Number : ********1");
accNo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
accNo.setBounds(20,90,300,25);

JLabel type = new JLabel("Account Type : Savings");
type.setFont(new Font("Segoe UI", Font.PLAIN, 16));
type.setBounds(20,120,300,25);

accountCard.add(accTitle);

mainPanel.add(accountCard);
        mainPanel.add(depositCard);
        mainPanel.add(withdrawCard);
        mainPanel.add(statementCard);
        mainPanel.add(pinCard);
        mainPanel.add(logoutCard);

        add(mainPanel);
        setVisible(true);
    }
}

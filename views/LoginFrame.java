package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import entity.Customer;
import classes.*;

public class LoginFrame extends JFrame implements ActionListener {

    private JPanel jp1, jp2;
    private JLabel usernameLabel, passwordLabel, titleLabel, registerLabel, forgotpasswordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginBtn, registerBtn, forgotpasswordBtn;
    private Font headingFont, normalFont;

    public LoginFrame() {
        super("First Page");
        super.setSize(1600, 900);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headingFont = new Font("Cambria", Font.PLAIN, 50);
        normalFont = new Font("Cambria", Font.PLAIN, 28);

        jp1 = new JPanel();
        jp1.setBackground(Color.GREEN);
        jp1.setBounds(0, 0, 800, 900);

        jp2 = new JPanel();
        jp2.setBackground(Color.CYAN);
        jp2.setBounds(800, 0, 800, 900);
        jp2.setLayout(null);

        titleLabel = new JLabel("LOGIN");
        titleLabel.setFont(headingFont);
        titleLabel.setBounds(300, 100, 200, 46);
        jp2.add(titleLabel);

        usernameLabel = new JLabel("User Name");
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(50, 200, 200, 20);
        jp2.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(50, 250, 650, 30);
        jp2.add(usernameTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(normalFont);
        passwordLabel.setBounds(50, 300, 200, 20);
        jp2.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 350, 650, 30);
        jp2.add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setFont(normalFont);
        loginBtn.setBounds(350, 400, 150, 35);
        loginBtn.addActionListener(this);
        jp2.add(loginBtn);

        forgotpasswordLabel = new JLabel("Forgot Password");
        forgotpasswordLabel.setFont(normalFont);
        forgotpasswordLabel.setBounds(50, 700, 250, 35);
        jp2.add(forgotpasswordLabel);

        forgotpasswordBtn = new JButton("Reset");
        forgotpasswordBtn.setFont(normalFont);
        forgotpasswordBtn.setBounds(270, 700, 150, 35);
        // forgotpasswordBtn.addActionListener(this);
        jp2.add(forgotpasswordBtn);

        registerLabel = new JLabel("No Account");
        registerLabel.setFont(normalFont);
        registerLabel.setBounds(50, 750, 250, 20);
        jp2.add(registerLabel);

        registerBtn = new JButton("Register");
        registerBtn.setFont(normalFont);
        registerBtn.setBounds(270, 750, 150, 35);
        registerBtn.addActionListener(this);
        jp2.add(registerBtn);

        super.add(jp1);
        super.add(jp2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Register")) {
            RegisterFrame rf = new RegisterFrame();
            rf.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("Login")) {
            String username = usernameTextField.getText();
            String password = passwordField.getText();

            UserRepository ur = new UserRepository();
            int flag = ur.validateCredentials(username, password);

            if (flag == 1) {
                UserDashboardFrame udf = new UserDashboardFrame(username, password);
                udf.setVisible(true);
                this.setVisible(false);
            } else if (flag == 0) {

                AdminDashboardFrame udf = new AdminDashboardFrame(username, password);
                udf.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid ID or Password");
            }
        }
    }
}
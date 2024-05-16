package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;

import classes.*;

public class RegisterFrame extends JFrame implements ActionListener {

    private JPanel jp1, jp2;
    private JLabel usernameLabel, passwordLabel, titleLabel, loginLabel, emaiLabel, questionanswerLabel, leftLabel;
    private JTextField usernameTextField, emailTextField, questionsnanswerTextField;
    private JPasswordField passwordField;
    private JButton loginBtn, registerBtn;
    private Font headingFont, normalFont;
    private JComboBox securityQsn;

    public RegisterFrame() {
        super("First Page");
        super.setSize(1600, 900);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headingFont = new Font("Cambria", Font.PLAIN, 50);
        normalFont = new Font("Cambria", Font.PLAIN, 28);

        jp1 = new JPanel();
        jp1.setBackground(Color.GREEN);
        jp1.setLayout(null);
        jp1.setBounds(0, 0, 800, 900);

        leftLabel = new JLabel(new ImageIcon("images/registration.png"));
        leftLabel.setBounds(0,0,800,900);
        jp1.add(leftLabel);

        jp2 = new JPanel();
        jp2.setBackground(Color.CYAN);
        jp2.setLayout(null);
        jp2.setBounds(800, 0, 800, 900);

        titleLabel = new JLabel("SIGN UP");
        titleLabel.setFont(headingFont);
        titleLabel.setBounds(300, 100, 200, 46);
        jp2.add(titleLabel);

        usernameLabel = new JLabel("User Name ");
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(50, 200, 200, 20);
        jp2.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(50, 250, 650, 30);
        jp2.add(usernameTextField);

        passwordLabel = new JLabel("Password ");
        passwordLabel.setFont(normalFont);
        passwordLabel.setBounds(50, 300, 200, 20);
        jp2.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 350, 650, 30);
        jp2.add(passwordField);

        emaiLabel = new JLabel("Email ");
        emaiLabel.setFont(normalFont);
        emaiLabel.setBounds(50, 400, 200, 20);
        jp2.add(emaiLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(50, 450, 650, 30);
        jp2.add(emailTextField);

        String[] secQsn = { "Choose a Security Question...", "what's your father's name?", "what's your mother's name?",
                 "whats your favourite pet name?", "what's your favorite sports?", "what's your favourite movie?" };
         securityQsn = new JComboBox(secQsn);
         securityQsn.setBounds(50, 505, 250, 25);
         securityQsn.setSelectedIndex(0);
         securityQsn.setBackground(Color.white);
         jp2.add(securityQsn);

        questionanswerLabel = new JLabel("What is your Answer");
        questionanswerLabel.setFont(normalFont);
        questionanswerLabel.setBounds(50, 560, 500, 35);
        jp2.add(questionanswerLabel);

        questionsnanswerTextField = new JTextField();
        questionsnanswerTextField.setBounds(50, 600, 650, 30);
        jp2.add(questionsnanswerTextField);

        registerBtn = new JButton("Register");
        registerBtn.setFont(normalFont);
        registerBtn.setBounds(350, 650, 150, 35);
        registerBtn.addActionListener(this);
        jp2.add(registerBtn);

        loginLabel = new JLabel("Have Account");
        loginLabel.setFont(normalFont);
        loginLabel.setBounds(50, 750, 250, 20);
        jp2.add(loginLabel);

        loginBtn = new JButton("Login");
        loginBtn.setFont(normalFont);
        loginBtn.setBounds(230, 745, 150, 35);
        loginBtn.addActionListener(this);
        jp2.add(loginBtn);

        super.add(jp1);
        super.add(jp2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Login")) {
            LoginFrame lf = new LoginFrame();
            lf.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("Register")) {
    String username = usernameTextField.getText();
    String password = passwordField.getText();
    String email = emailTextField.getText();
    String question = String.valueOf(securityQsn.getSelectedItem());
    String answer = questionsnanswerTextField.getText();

    if (username.isEmpty() || password.isEmpty() || email.isEmpty() || question.isEmpty() || answer.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out.");
    } else {
        UserRepository ur = new UserRepository();
        int flag = ur.validateUsernameEmail(username, email);
        System.out.println(flag);
        if (flag == 1) {
            ur.registerUser(username, password, email, answer, question);
            LoginFrame lf = new LoginFrame();
            lf.setVisible(true);
            this.setVisible(false);
        } else if (flag == 0) {
            JOptionPane.showMessageDialog(this, "Duplicate Username or Email");
        }
    }
}
 else {
           System.exit(0);
        }
    }
}
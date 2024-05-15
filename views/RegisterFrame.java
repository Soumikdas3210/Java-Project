package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.*;

import classes.*;

public class RegisterFrame extends JFrame implements ActionListener {

    private JPanel jp1, jp2;
    private JLabel usernameLabel, passwordLabel, titleLabel, loginLabel, emaiLabel;
    private JTextField usernameTextField, emailTextField;
    private JPasswordField passwordField;
    private JButton loginBtn, registerBtn;
    private Font headingFont, normalFont;

    public RegisterFrame() {
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

        registerBtn = new JButton("Register");
        registerBtn.setFont(normalFont);
        registerBtn.setBounds(350, 500, 150, 35);
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

            File f = new File("data/user.txt");

            FileReader fr = null;
            BufferedReader br = null;

            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {

                    String words[] = line.split("\t");
                    if (words[0].equals(username)) {
                        JOptionPane.showMessageDialog(this, "Invalid ID or Password");
                        break;
                    } else {
                        UserRepository ur = new UserRepository();
                        System.out.println(username);
                        ur.registerUser(username, password, email);
                        LoginFrame lf = new LoginFrame();
                        lf.setVisible(true);
                        this.setVisible(false);
                        break;

                    }
                }

            } catch (Exception ex3) {
                System.out.println(ex3.getMessage());
            }

        } else {
            System.exit(0);
        }
    }
}
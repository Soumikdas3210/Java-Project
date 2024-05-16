package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Admin;
import javax.swing.*;
import classes.*;

public class AddAdminFrame extends JFrame implements ActionListener {

    private JPanel jp1, jp2;
    private JLabel usernameLabel, passwordLabel, titleLabel, backLabel, emaiLabel;
    private JTextField usernameTextField, emailTextField;
    private JPasswordField passwordField;
    private JButton backBtn, registerBtn;
    private Font headingFont, normalFont;
    private Admin a1;

    public AddAdminFrame(Admin a1) {
        super("First Page");
        super.setSize(1600, 900);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.a1= a1;

        headingFont = new Font("Cambria", Font.PLAIN, 40);
        normalFont = new Font("Cambria", Font.PLAIN, 28);

        jp1 = new JPanel();
        jp1.setBackground(Color.GREEN);
        jp1.setBounds(0, 0, 800, 900);

        jp2 = new JPanel();
        jp2.setBackground(Color.CYAN);
        jp2.setBounds(800, 0, 800, 900);
        jp2.setLayout(null);

        titleLabel = new JLabel("Register Admin");
        titleLabel.setFont(headingFont);
        titleLabel.setBounds(280, 100, 400, 46);
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

        backLabel = new JLabel("Go Back");
        backLabel.setFont(normalFont);
        backLabel.setBounds(50, 750, 250, 20);
        jp2.add(backLabel);

        backBtn = new JButton("Back");
        backBtn.setFont(normalFont);
        backBtn.setBounds(230, 745, 150, 35);
        backBtn.addActionListener(this);
        jp2.add(backBtn);

        super.add(jp1);
        super.add(jp2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Back")) {
            AdminDashboardFrame adf = new AdminDashboardFrame(a1);
            adf.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("Register")) {
            String username = usernameTextField.getText();
            String password = passwordField.getText();
            String email = emailTextField.getText();
            UserRepository ur = new UserRepository();
            int flag = ur.validateUsernameEmail(username,email);
            System.out.println(flag);
            if(flag == 1){
                ur.registerAdmin(username, password, email);
                LoginFrame lf = new LoginFrame();
                lf.setVisible(true);
                this.setVisible(false);
            } else if(flag == 0){
                JOptionPane.showMessageDialog(this, "Duplicate Username or Email");
            }
        } else {
            System.exit(0);
        }
    }

}

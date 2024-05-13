package views;
import java.awt.*;
import javax.swing.*;


public class RegisterFrame extends JFrame  {

	JPanel jp1,jp2;
	JLabel usernameLabel, passwordLabel, signupLabel, loginLabel, emaiLabel;
	JTextField usernameTextField, emailTextField;
	JPasswordField passwordField;
	JButton loginBtn, registerBtn;
    Font headingFont, normalFont;

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

        signupLabel = new JLabel("SIGN UP");
        signupLabel.setFont(headingFont);
        signupLabel.setBounds(300, 100, 200, 46);
        jp2.add(signupLabel);

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

        usernameTextField = new JTextField();
        usernameTextField.setBounds(50, 450, 650, 30);
        jp2.add(usernameTextField);

        registerBtn = new JButton("Register");
        registerBtn.setFont(normalFont);
        registerBtn.setBounds(350, 500, 150, 35);
        jp2.add(registerBtn);

       

        loginLabel = new JLabel("Have Account");
        loginLabel.setFont(normalFont);
        loginLabel.setBounds(50, 750, 250, 20);
        jp2.add(loginLabel);

        loginBtn = new JButton("Login");
        loginBtn.setFont(normalFont);
        loginBtn.setBounds(230, 745, 150, 35);
        jp2.add(loginBtn);

        super.add(jp1);
        super.add(jp2);
	}
}
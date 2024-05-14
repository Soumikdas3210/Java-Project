import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class profileFrame extends JFrame {
    final int width = 1600, height = 900;
    Font bigFont, normalFont, hugefont;
    JPanel mainPanel, leftPanel, rightPanel;
    ImageIcon userImage;
    JLabel userLabel, usernameLabel, userEmailLabel, passwordLabel, confirmPasswordLabel, titleLabel;
    //JTextField passwordField, confirmPasswordField;
    JPasswordField passwordField, confirmPasswordField;
    JButton changePasswordButton;


    public profileFrame() {
        super("Profile");
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, width, height);
        this.add(mainPanel);
        this.setSize(width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hugefont = new Font("Roboto", Font.BOLD, 40);
        bigFont = new Font("Roboto", Font.BOLD, 24);
        normalFont = new Font("Roboto", Font.PLAIN, 18);


        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 800, 900);
        leftPanel.setLayout(null);
        mainPanel.add(leftPanel);

        userImage = new ImageIcon("images/avatar.png");
        userLabel = new JLabel(userImage);
        userLabel.setBounds(150, 0, 500, 500);
        leftPanel.add(userLabel);

        usernameLabel = new JLabel("User_name");
        usernameLabel.setFont(bigFont);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setBounds(150, 500, 400, 80);
        leftPanel.add(usernameLabel);

        userEmailLabel = new JLabel("User_email");
        userEmailLabel.setFont(bigFont);
        userEmailLabel.setBounds(150, 580, 400, 80);
        userEmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(userEmailLabel);


        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.decode("#9dade1"));
        rightPanel.setBounds(800, 0, 800, 900);
        mainPanel.add(rightPanel);

        titleLabel = new JLabel("Change Password");
        titleLabel.setFont(bigFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(150, 100, 400, 80);
        rightPanel.add(titleLabel);

        passwordLabel = new JLabel("New Password");
        passwordLabel.setFont(bigFont);
        passwordLabel.setBounds(150, 300, 400, 50);
        rightPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(bigFont);
        passwordField.setBounds(150, 350, 400, 50);
        rightPanel.add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setFont(bigFont);
        confirmPasswordLabel.setBounds(150, 400, 400, 50);
        rightPanel.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(bigFont);
        confirmPasswordField.setBounds(150, 450, 400, 50);
        rightPanel.add(confirmPasswordField);

        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(250,600, 250, 60);
        changePasswordButton.setFont(new Font("Roboto", Font.BOLD, 20));
        //changePasswordButton.setHorizontalAlignment(SwingConstants.CENTER);
        //changePasswordButton.setBackground(Color.decode("#9dade1"));
        changePasswordButton.setBackground(Color.decode("#617ee6"));
        rightPanel.add(changePasswordButton);


    }
}
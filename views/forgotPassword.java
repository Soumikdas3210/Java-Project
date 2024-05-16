package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class forgotPassword extends JFrame implements ActionListener {

	private JLabel titleLabel, passwordLabel, userNameLabel, emailLabel, securityQuestionLabel, answerLabel;
	private JTextField userNameText, emailText, answerText;
	private JPasswordField passwordField;
	private JComboBox securityQuestionComboBox;
	private JButton backButton, resetButton;
	private JPanel leftPanel, rightPanel;

	final int width = 1600, height = 900;

	public forgotPassword() {
		super("Forgot Password");
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon img;
		titleLabel = new JLabel("Forgot Password");
		userNameLabel = new JLabel("User Name");
		emailLabel = new JLabel("Email");
		securityQuestionLabel = new JLabel("Security Question");
		answerLabel = new JLabel("Answer");
		userNameText = new JTextField();
		emailText = new JTextField();
		answerText = new JTextField();

		String items[] = { "Choose a Security Question...", "What's your father's name?", "What's your mother's name?",
				"What's your favourite pet name?", "What's your favorite sports?", "What's your favourite movie?" };
		securityQuestionComboBox = new JComboBox<>(items);
		backButton = new JButton("Back");
		resetButton = new JButton("Reset Password");

		final int leftWidth = (width / 2) + 100;
		final int topHeight = 150;
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, width / 2, 900);

		img = new ImageIcon("forgotPassword.png");
		JLabel imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, leftWidth, 900);
		leftPanel.add(imgLabel);

		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBackground(Color.decode("#9dade1"));
		rightPanel.setBounds(800, 0, width / 2, 900);

		titleLabel.setBounds((leftWidth + 200), topHeight - 25, 300, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		userNameLabel.setBounds(leftWidth + 100, topHeight + 100, 100, 30);
		emailLabel.setBounds(leftWidth + 100, topHeight + 150, 100, 30);
		securityQuestionLabel.setBounds(leftWidth + 100, topHeight + 200, 200, 30);
		answerLabel.setBounds(leftWidth + 100, topHeight + 250, 100, 30);

		userNameText.setBounds(leftWidth + 200, topHeight + 100, 250, 30);
		userNameText.setEditable(true);
		emailText.setBounds(leftWidth + 200, topHeight + 150, 250, 30);
		emailText.setEditable(true);
		securityQuestionComboBox.setBounds(leftWidth + 200, topHeight + 200, 250, 30);
		answerText.setBounds(leftWidth + 200, topHeight + 250, 250, 30);
		answerText.setEditable(true);

		passwordLabel = new JLabel("Password ");
		passwordLabel.setBounds(leftWidth + 100, topHeight + 300, 100, 30);
		rightPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(leftWidth + 200, topHeight + 300, 250, 30);
		rightPanel.add(passwordField);

		backButton.setBounds(leftWidth + 100, topHeight + 50, 100, 30);
		backButton.setBackground(Color.decode("#bad69f"));

		backButton.addActionListener(this);
		resetButton.setBounds(leftWidth + 150, topHeight + 400, 250, 50);
		resetButton.setFont(new Font("Arial", Font.BOLD, 18));
		resetButton.setBackground(Color.decode("#617ee6"));

		rightPanel.add(titleLabel);
		rightPanel.add(userNameLabel);
		rightPanel.add(userNameText);
		rightPanel.add(emailLabel);
		rightPanel.add(emailText);
		rightPanel.add(securityQuestionLabel);
		rightPanel.add(securityQuestionComboBox);
		rightPanel.add(answerLabel);
		rightPanel.add(answerText);
		rightPanel.add(backButton);
		rightPanel.add(resetButton);

		this.add(leftPanel);
		this.add(rightPanel);

	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==backButton){
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
	}
}

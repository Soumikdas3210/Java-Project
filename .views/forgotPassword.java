import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class forgotPassword extends JFrame implements ActionListener {

	JLabel titleLabel, userNameLabel, emailLabel, nidLabel, SecurityQuestionLabel, AnswerLabel;
	TextField userNameText, emailText, nidText, answerText;
	JComboBox securityQuestionComboBox;
	JButton backButton, resetButton;
	JPanel leftPanel, rightPanel;

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
		nidLabel = new JLabel("NID Number");
		SecurityQuestionLabel = new JLabel("Security Question");
		AnswerLabel = new JLabel("Answer");
		userNameText = new TextField();
		emailText = new TextField();
		nidText = new TextField();
		answerText = new TextField();

		String items[] = { "Security Question 1", "Security Question 2", "Security Question 3", "Security Question 4", "Security Question 5" };
		securityQuestionComboBox = new JComboBox(items);
		backButton = new JButton("Back");
		resetButton = new JButton("Reset Password");


		final int leftWidth = (width / 2)+100;
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

		titleLabel.setBounds((leftWidth+200), topHeight-25, 300, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		userNameLabel.setBounds(leftWidth + 100, topHeight+100, 100, 30);
		emailLabel.setBounds(leftWidth + 100, topHeight+150, 100, 30);
		nidLabel.setBounds(leftWidth + 100, topHeight+200, 100, 30);
		SecurityQuestionLabel.setBounds(leftWidth + 100, topHeight+250, 200, 30);

		userNameText.setBounds(leftWidth + 200, topHeight+100, 250, 30);
		userNameText.setEditable(true);
		emailText.setBounds(leftWidth + 200, topHeight+150, 250, 30);
		emailText.setEditable(true);
		nidText.setBounds(leftWidth + 200, topHeight+200, 250, 30);
		nidText.setEditable(true);
		securityQuestionComboBox.setBounds(leftWidth + 100, topHeight+300, 200, 30);

		AnswerLabel.setBounds(leftWidth + 100, topHeight+350, 100, 30);
		answerText.setBounds(leftWidth + 200, topHeight+350, 250, 30);
		answerText.setEditable(true);

		backButton.setBounds(leftWidth + 100, topHeight+50, 100, 30);
		backButton.setBackground(Color.decode("#bad69f"));
		resetButton.setBounds(leftWidth + 150, topHeight+450, 250, 50);
		resetButton.setFont(new Font("Arial", Font.BOLD, 18));
		resetButton.setBackground(Color.decode("#617ee6"));


		rightPanel.add(titleLabel);
		rightPanel.add(userNameLabel);
		rightPanel.add(userNameText);
		rightPanel.add(emailLabel);
		rightPanel.add(emailText);
		rightPanel.add(nidLabel);
		rightPanel.add(nidText);
		rightPanel.add(SecurityQuestionLabel);
		rightPanel.add(securityQuestionComboBox);
		rightPanel.add(AnswerLabel);
		rightPanel.add(answerText);
		rightPanel.add(backButton);
		rightPanel.add(resetButton);

		this.add(leftPanel);
		this.add(rightPanel);

	}

	public void actionPerformed(ActionEvent ae) {
	}
}

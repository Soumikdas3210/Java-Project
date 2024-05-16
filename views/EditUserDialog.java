package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUserDialog extends JDialog {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField questionField;
    private JTextField answerField;
    private boolean okPressed = false;

    public EditUserDialog(Frame parent, String username, String password, String email, String question, String answer) {
        super(parent, "Edit User", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField(username);
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(password);
        panel.add(passwordField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField(email);
        panel.add(emailField);

        panel.add(new JLabel("Question:"));
        questionField = new JTextField(question);
        panel.add(questionField);

        panel.add(new JLabel("Answer:"));
        answerField = new JTextField(answer);
        panel.add(answerField);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okPressed = true;
                dispose();
            }
        });
        panel.add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(cancelButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getQuestion() {
        return questionField.getText();
    }

    public String getAnswer() {
        return answerField.getText();
    }

    public boolean isOkPressed() {
        return okPressed;
    }
}

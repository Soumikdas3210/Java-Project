package views;

import entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class paymentFrame extends JFrame {
    final int width = 1600, height = 900;
    private Font bigFont, normalFont, hugefont;
    private JPanel mainPanel, leftPanel, rightPanel;
    private JLabel cardHolderLabel, titleLabel, paymentMethodLabel, phoneNumberLabel, pinLabel, otpLabel, itemLabel,
            priceLabel, userNameLabel, leftTitelLabel, skuLabel;
    private JTextField phoneField, pinField, otpField;
    private JButton payButton, backButton;
    private JRadioButton bkashRadioButton, rocketRadioButton, nagadRadioButton;
    private ButtonGroup paymentMethodGroup;

    void setVisibility(boolean visible) {
        this.setVisible(visible);
    }

    public paymentFrame(Product product, Customer c1, String address) {
        super("Payment");
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

        leftTitelLabel = new JLabel("Order Summary");
        leftTitelLabel.setFont(bigFont);
        leftTitelLabel.setBounds(250, 150, 200, 60);
        leftPanel.add(leftTitelLabel);

        itemLabel = new JLabel("Item: " + product.getProductName());
        itemLabel.setFont(bigFont);
        itemLabel.setBounds(100, 250, 500, 50);
        leftPanel.add(itemLabel);

        skuLabel = new JLabel("SKU: " + product.getProductSku());
        skuLabel.setFont(bigFont);
        skuLabel.setBounds(100, 300, 200, 50);
        leftPanel.add(skuLabel);

        priceLabel = new JLabel("Total: " + product.getProductPrice());
        priceLabel.setFont(bigFont);
        priceLabel.setBounds(100, 350, 200, 50);
        leftPanel.add(priceLabel);

        userNameLabel = new JLabel("Buyer: " + c1.getUsername());
        userNameLabel.setFont(bigFont);
        userNameLabel.setBounds(100, 400, 200, 50);
        leftPanel.add(userNameLabel);

        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.decode("#9dade1"));
        rightPanel.setBounds(800, 0, 800, 900);
        mainPanel.add(rightPanel);

        backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE);
        backButton.setBounds(800 - 160, 25, 120, 50);
        backButton.setFont(bigFont);
        rightPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserDashboardFrame udf = new UserDashboardFrame(c1);
                udf.setVisible(true);
                setVisibility(false);
            }
        });

        titleLabel = new JLabel("Online Payment");
        titleLabel.setFont(bigFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(150, 100, 400, 80);
        rightPanel.add(titleLabel);

        paymentMethodLabel = new JLabel("Select payment method:");
        paymentMethodLabel.setFont(normalFont);
        paymentMethodLabel.setBounds(150, 200, 200, 30);
        rightPanel.add(paymentMethodLabel);

        bkashRadioButton = new JRadioButton("Bkash");
        bkashRadioButton.setFont(normalFont);
        bkashRadioButton.setBounds(150, 240, 100, 30);
        rightPanel.add(bkashRadioButton);

        rocketRadioButton = new JRadioButton("Rocket");
        rocketRadioButton.setFont(normalFont);
        rocketRadioButton.setBounds(250, 240, 100, 30);
        rightPanel.add(rocketRadioButton);

        nagadRadioButton = new JRadioButton("Nagad");
        nagadRadioButton.setFont(normalFont);
        nagadRadioButton.setBounds(350, 240, 100, 30);
        rightPanel.add(nagadRadioButton);

        paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(bkashRadioButton);
        paymentMethodGroup.add(rocketRadioButton);
        paymentMethodGroup.add(nagadRadioButton);

        phoneNumberLabel = new JLabel("Phone number:");
        phoneNumberLabel.setFont(normalFont);
        phoneNumberLabel.setBounds(150, 290, 200, 30);
        rightPanel.add(phoneNumberLabel);

        phoneField = new JTextField();
        phoneField.setFont(normalFont);
        phoneField.setBounds(150, 330, 200, 30);
        rightPanel.add(phoneField);

        pinLabel = new JLabel("PIN number:");
        pinLabel.setFont(normalFont);
        pinLabel.setBounds(150, 380, 200, 30);
        rightPanel.add(pinLabel);

        pinField = new JPasswordField();
        pinField.setFont(normalFont);
        pinField.setBounds(150, 420, 200, 30);
        rightPanel.add(pinField);

        otpLabel = new JLabel("Enter OTP:");
        otpLabel.setFont(normalFont);
        otpLabel.setBounds(150, 470, 200, 30);
        rightPanel.add(otpLabel);

        otpField = new JTextField();
        otpField.setFont(normalFont);
        otpField.setBounds(150, 510, 200, 30);
        rightPanel.add(otpField);

        payButton = new JButton("Pay");
        payButton.setFont(normalFont);
        payButton.setBounds(150, 560, 200, 40);
        rightPanel.add(payButton);

        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get selected payment method
                String paymentMethod = "";
                if (bkashRadioButton.isSelected()) {
                    paymentMethod = "Bkash";
                } else if (rocketRadioButton.isSelected()) {
                    paymentMethod = "Rocket";
                } else if (nagadRadioButton.isSelected()) {
                    paymentMethod = "Nagad";
                }

                // Get entered phone number, PIN, and OTP
                String phoneNumber = phoneField.getText();
                String pin = pinField.getText();
                String otp = otpField.getText();

                // Check if any field is empty
                if (phoneNumber.isEmpty() || pin.isEmpty() || otp.isEmpty()) {
                    // Show dialog box prompting the user to fill all details
                    JOptionPane.showMessageDialog(null, "Please fill all details", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Write data to file
                    try (FileWriter writer = new FileWriter("data/payment.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                        // Construct the data string
                        String data = product.getProductName() + "\t" + product.getProductPrice() + "\t" +
                                c1.getUsername() + "\t" + paymentMethod + "\t" + phoneNumber + "\t" + address + "\n";
                        // Write data to file
                        bufferedWriter.write(data);
                        // Notify user
                        JOptionPane.showMessageDialog(null, "Payment successful!");
                        UserDashboardFrame udf = new UserDashboardFrame(c1);
                        udf.setVisible(true);
                        setVisibility(false);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error writing to file: " + ex.getMessage());
                    }
                }
            }
        });

    }
}

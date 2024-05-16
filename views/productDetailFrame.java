package views;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class productDetailFrame extends JFrame {
    final int width = 1600, height = 900;
    private Font bigFont, normalFont, hugefont;
    private JPanel mainPanel, leftPanel, rightPanel;
    private JLabel productImageLabel, productNameLabel, productPriceLabel, productSkuLabel, productDetailsLabel;
    private JLabel districtLabel, cityLabel, postalCodeLabel, houseNumberLabel, roadNumberLabel, addressLabel;
    private JTextField districtTextField, cityTextField, postalCodeTextField, houseNumberTextField, roadNumberTextField;
    private JButton payOnlineButton, backButton;

    void setVisibility(boolean visible) {
        this.setVisible(visible);
    }

    public productDetailFrame(Product product, Customer c1) {
        super(product.getProductName());

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

        productImageLabel = new JLabel(new ImageIcon(product.getProductImage()));
        productImageLabel.setBounds(150, 0, 500, 500);
        leftPanel.add(productImageLabel);

        productNameLabel = new JLabel(product.getProductName());
        productNameLabel.setFont(bigFont);
        productNameLabel.setBounds(100, 550, 500, 50);
        leftPanel.add(productNameLabel);

        productPriceLabel = new JLabel(product.getProductPrice() + "$");
        productPriceLabel.setFont(bigFont);
        productPriceLabel.setBounds(100, 600, 300, 50);
        leftPanel.add(productPriceLabel);

        productSkuLabel = new JLabel(product.getProductSku());
        productSkuLabel.setFont(bigFont);
        productSkuLabel.setBounds(100, 650, 300, 50);
        leftPanel.add(productSkuLabel);

        productDetailsLabel = new JLabel(product.getProductDetails());
        productDetailsLabel.setFont(bigFont);
        productDetailsLabel.setBounds(100, 700, 700, 50);
        leftPanel.add(productDetailsLabel);
        // Add labels and other components to the leftPanel

        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.decode("#9dade1"));
        rightPanel.setBounds(800, 0, 800, 900);
        mainPanel.add(rightPanel);

        // back button
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

        addressLabel = new JLabel("Add Address");
        addressLabel.setFont(hugefont);
        addressLabel.setBounds(100, 100, 600, 100);
        addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightPanel.add(addressLabel);

        // Add labels, text fields, and button to the rightPanel
        districtLabel = new JLabel("District:");
        districtLabel.setFont(normalFont);
        districtLabel.setBounds(150, 250, 100, 30);
        rightPanel.add(districtLabel);

        districtTextField = new JTextField();
        districtTextField.setBounds(300, 250, 200, 30);
        rightPanel.add(districtTextField);

        cityLabel = new JLabel("City:");
        cityLabel.setFont(normalFont);
        cityLabel.setBounds(150, 300, 550, 30);
        rightPanel.add(cityLabel);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 300, 200, 30);
        rightPanel.add(cityTextField);

        postalCodeLabel = new JLabel("Postal Code:");
        postalCodeLabel.setFont(normalFont);
        postalCodeLabel.setBounds(150, 350, 150, 30);
        rightPanel.add(postalCodeLabel);

        postalCodeTextField = new JTextField();
        postalCodeTextField.setBounds(300, 350, 200, 30);
        rightPanel.add(postalCodeTextField);

        houseNumberLabel = new JLabel("House Number:");
        houseNumberLabel.setFont(normalFont);
        houseNumberLabel.setBounds(150, 400, 150, 30);
        rightPanel.add(houseNumberLabel);

        houseNumberTextField = new JTextField();
        houseNumberTextField.setBounds(300, 400, 200, 30);
        rightPanel.add(houseNumberTextField);

        roadNumberLabel = new JLabel("Road Number:");
        roadNumberLabel.setFont(normalFont);
        roadNumberLabel.setBounds(150, 450, 150, 30);
        rightPanel.add(roadNumberLabel);

        roadNumberTextField = new JTextField();
        roadNumberTextField.setBounds(300, 450, 200, 30);
        rightPanel.add(roadNumberTextField);

        payOnlineButton = new JButton("Pay Online");
        payOnlineButton.setBounds(400 - 125, 550, 250, 80);
        payOnlineButton.setFont(bigFont);
        payOnlineButton.setForeground(Color.WHITE);
        payOnlineButton.setBackground(Color.BLACK);
        rightPanel.add(payOnlineButton);
        payOnlineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String district = districtTextField.getText();
                String city = cityTextField.getText();
                String postalCode = postalCodeTextField.getText();
                String houseNumber = houseNumberTextField.getText();
                String roadNumber = roadNumberTextField.getText();
                if (district.isEmpty() || city.isEmpty() || postalCode.isEmpty() || houseNumber.isEmpty()
                        || roadNumber.isEmpty()) {
                    // Show dialog box prompting the user to fill all details
                    JOptionPane.showMessageDialog(null, "Please fill all details", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    // Combine the data to form the address string
                    String address = houseNumber + ", Road " + roadNumber + ", " + district + ", " + city + ", "
                            + postalCode;

                    // Print the address string in the console
                    System.out.println("Address: " + address);
                    paymentFrame pf = new paymentFrame(product, c1, address);
                    pf.setVisible(true);
                    setVisibility(false);
                }
            }
        });

    }
}

package views;

import entity.Customer;
import entity.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static entity.Product.loadProductsFromFile;

public class UserDashboardFrame extends JFrame implements ActionListener {

    private Customer c1;

    final int width = 1600, height = 940;

    private JPanel headerPanel, itemsPanel, pro1Panel, pro2Panel, pro3Panel, pro4Panel, pro5Panel, pro6Panel, pro7Panel,
            pro8Panel;
    private JLabel logoutLabel, userNameLabel,
            pro1Label, pro2Label, pro3Label, pro4Label, pro5Label, pro6Label, pro7Label, pro8Label,
            pro1PriceLabel, pro2PriceLabel, pro3PriceLabel, pro4PriceLabel, pro5PriceLabel, pro6PriceLabel,
            pro7PriceLabel, pro8PriceLabel;
    private JButton logoutButton, userButton,
            pro1img, pro2img, pro3img, pro4img, pro5img, pro6img, pro7img, pro8img,
            pro1BuyButton, pro2BuyButton, pro3BuyButton, pro4BuyButton, pro5BuyButton, pro6BuyButton, pro7BuyButton,
            pro8BuyButton;
    private Font catagoryFont, normalFont, priceFont;
    private ImageIcon userImageIcon;

    private void setVisibility(boolean visible) {
        this.setVisible(visible);
    }

    Product[] products = loadProductsFromFile("data/productData.txt");

    public UserDashboardFrame(Customer c1) {
        super("User Dashboard");
        this.setSize(width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.c1 = c1;

        // fonts sizes
        catagoryFont = new Font("Roboto", Font.BOLD, 24);
        normalFont = new Font("Roboto", Font.PLAIN, 18);
        priceFont = new Font("Roboto", Font.BOLD, 20);

        // header Panel
        headerPanel = new JPanel();
        headerPanel.setLayout(null);
        // headerPanel.setBackground(Color.RED);
        headerPanel.setBounds(0, 0, width, 100);
        this.add(headerPanel);

        // Logout button
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.decode("#9dade1"));
        logoutButton.setBounds(width - 160, 25, 120, 50);
        logoutButton.setFont(catagoryFont);
        logoutButton.addActionListener(this);
        headerPanel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame lf = new LoginFrame();
                lf.setVisible(true);
                setVisibility(false);
            }
        });

        // username
        userNameLabel = new JLabel(c1.getUsername());
        userNameLabel.setFont(catagoryFont);
        userNameLabel.setBounds(140, 10, 300, 80);
        headerPanel.add(userNameLabel);

        // user avater button
        userImageIcon = new ImageIcon("images/mini_avatar.png");
        userButton = new JButton(userImageIcon);
        userButton.setBounds(25, 10, 80, 80); // Set preferred size for circular button
        userButton.setOpaque(false);
        userButton.setFocusPainted(true);
        userButton.setBorder(BorderFactory.createEmptyBorder());
        userButton.setBackground(Color.BLACK);
        headerPanel.add(userButton);
        userButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserProfileFrame upf = new UserProfileFrame(c1);
                upf.setVisible(true);
                setVisibility(false);
            }
        });

        // items Panel
        itemsPanel = new JPanel();
        // itemsPanel.setBackground(Color.GREEN);
        itemsPanel.setLayout(null);
        itemsPanel.setBounds(0, 100, width, height);
        this.add(itemsPanel);

        // for (int i = 0; i < products.length; i++) {
        // Product product = products[i];
        // if (product != null) {
        // System.out.println("Product Name: " + product.getProductName());
        // System.out.println("Product Price: $" + product.getProductPrice());
        // System.out.println("Product SKU: " + product.getProductSku());
        // System.out.println("Product Image: " + product.getProductImage());
        // System.out.println("Product Details: " + product.getProductDetails());
        // System.out.println();
        // }
        //
        // }

        // product 1
        pro1Panel = new JPanel();
        pro1Panel.setLayout(null);
        pro1Panel.setBounds(0, 100, 400, 400);
        itemsPanel.add(pro1Panel);
        // product1 image
        pro1img = new JButton();
        pro1img.setIcon(new ImageIcon(products[0].getProductImage()));
        pro1img.setBounds(15, 15, 350 + 25, 250);
        pro1img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro1img.setBackground(Color.WHITE);
        pro1img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("image clicked");
                productDetailFrame pdf = new productDetailFrame(products[0], c1);
                pdf.setVisible(true);
                setVisibility(false);

            }
        });
        pro1Panel.add(pro1img);
        // product1 name
        pro1Label = new JLabel(products[0].getProductName());
        pro1Label.setBounds(15, (15 + 250), 200, 30);
        pro1Label.setFont(normalFont);
        pro1Label.setForeground(Color.BLACK);
        pro1Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro1Panel.add(pro1Label);
        pro1Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[0], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product1 price
        pro1PriceLabel = new JLabel(products[0].getProductPrice() + "$");
        pro1PriceLabel.setBounds(15, (250 + 45), 100, 50);
        pro1PriceLabel.setFont(priceFont);
        pro1PriceLabel.setForeground(Color.BLUE);
        pro1PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro1Panel.add(pro1PriceLabel);
        pro1PriceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 price clicked!");
                productDetailFrame pdf = new productDetailFrame(products[0], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product1 buy
        pro1BuyButton = new JButton("Buy");
        pro1BuyButton.setBackground(Color.decode("#9dade1"));
        pro1BuyButton.setBounds(300, 340, 80, 40);
        pro1BuyButton.setFont(normalFont);
        pro1BuyButton.setForeground(Color.WHITE);
        pro1BuyButton.setBackground(Color.BLACK);
        pro1BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro1Panel.add(pro1BuyButton);
        pro1BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[0], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product 2
        pro2Panel = new JPanel();
        // pro2Panel.setBackground(Color.CYAN);
        pro2Panel.setLayout(null);
        pro2Panel.setBounds(400, 100, 400, 400);
        itemsPanel.add(pro2Panel);
        // product2 image
        pro2img = new JButton();
        pro2img.setIcon(new ImageIcon(products[1].getProductImage()));
        pro2img.setBounds(15, 15, 350 + 25, 250);
        pro2img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro2img.setBackground(Color.WHITE);
        pro2Panel.add(pro2img);
        pro2img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("image clicked");
                productDetailFrame pdf = new productDetailFrame(products[1], c1);
                pdf.setVisible(true);
                setVisibility(false);

            }
        });
        // product2 name
        pro2Label = new JLabel(products[1].getProductName());
        pro2Label.setBounds(15, (15 + 250), 300, 30);
        pro2Label.setFont(normalFont);
        pro2Label.setForeground(Color.BLACK);
        pro2Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro2Panel.add(pro2Label);
        pro2Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 price clicked!");
                productDetailFrame pdf = new productDetailFrame(products[1], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product2 price
        pro2PriceLabel = new JLabel(products[1].getProductPrice() + "$");
        pro2PriceLabel.setBounds(15, (250 + 45), 150, 50);
        pro2PriceLabel.setFont(priceFont);
        pro2PriceLabel.setForeground(Color.BLUE);
        pro2PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro2Panel.add(pro2PriceLabel);
        pro2PriceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 price clicked!");
                productDetailFrame pdf = new productDetailFrame(products[1], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product2 buy
        pro2BuyButton = new JButton("Buy");
        pro2BuyButton.setBackground(Color.decode("#9dade1"));
        pro2BuyButton.setBounds(300, 340, 80, 40);
        pro2BuyButton.setFont(normalFont);
        pro2BuyButton.setForeground(Color.WHITE);
        pro2BuyButton.setBackground(Color.BLACK);
        pro2BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro2Panel.add(pro2BuyButton);
        pro2BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[1], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product 3
        pro3Panel = new JPanel();
        // pro3Panel.setBackground(Color.ORANGE);
        pro3Panel.setLayout(null);
        pro3Panel.setBounds(800, 100, 400, 400);
        itemsPanel.add(pro3Panel);
        // product3 image
        pro3img = new JButton();
        pro3img.setIcon(new ImageIcon(products[2].getProductImage()));
        pro3img.setBounds(15, 15, 350 + 25, 250);
        pro3img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro3img.setBackground(Color.WHITE);
        pro3Panel.add(pro3img);
        pro3img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[2], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product3 name
        pro3Label = new JLabel(products[2].getProductName());
        pro3Label.setBounds(15, (15 + 250), 300, 30);
        pro3Label.setFont(normalFont);
        pro3Label.setForeground(Color.BLACK);
        pro3Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro3Panel.add(pro3Label);
        pro3Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[2], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product3 price
        pro3PriceLabel = new JLabel(products[2].getProductPrice() + "$");
        pro3PriceLabel.setBounds(15, (250 + 45), 150, 50);
        pro3PriceLabel.setFont(priceFont);
        pro3PriceLabel.setForeground(Color.BLUE);
        pro3PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro3PriceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[2], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        pro3Panel.add(pro3PriceLabel);

        // product3 buy
        pro3BuyButton = new JButton("Buy");
        pro3BuyButton.setBackground(Color.decode("#9dade1"));
        pro3BuyButton.setBounds(300, 340, 80, 40);
        pro3BuyButton.setFont(normalFont);
        pro3BuyButton.setForeground(Color.WHITE);
        pro3BuyButton.setBackground(Color.BLACK);
        pro3BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro3Panel.add(pro3BuyButton);
        pro3BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[2], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product 4
        pro4Panel = new JPanel();
        // pro4Panel.setBackground(Color.DARK_GRAY);
        pro4Panel.setLayout(null);
        pro4Panel.setBounds(1200, 100, 400, 400);
        itemsPanel.add(pro4Panel);
        // product4 image
        pro4img = new JButton();
        pro4img.setIcon(new ImageIcon(products[3].getProductImage()));
        pro4img.setBounds(15, 15, 350, 250);
        pro4img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro4img.setBackground(Color.WHITE);
        pro4Panel.add(pro4img);
        pro4img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[3], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product4 name
        pro4Label = new JLabel(products[3].getProductName());
        pro4Label.setBounds(15, (15 + 250), 300, 30);
        pro4Label.setFont(normalFont);
        pro4Label.setForeground(Color.BLACK);
        pro4Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro4Panel.add(pro4Label);
        pro4Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[3], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product4 price
        pro4PriceLabel = new JLabel(products[3].getProductPrice() + "$");
        pro4PriceLabel.setBounds(15, (250 + 45), 150, 50);
        pro4PriceLabel.setFont(priceFont);
        pro4PriceLabel.setForeground(Color.BLUE);
        pro4PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro4Panel.add(pro4PriceLabel);
        pro4PriceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[3], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product4 buy
        pro4BuyButton = new JButton("Buy");
        pro4BuyButton.setBackground(Color.decode("#9dade1"));
        pro4BuyButton.setBounds(300 - 25, 340, 80, 40);
        pro4BuyButton.setFont(normalFont);
        pro4BuyButton.setForeground(Color.WHITE);
        pro4BuyButton.setBackground(Color.BLACK);
        pro4BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro4Panel.add(pro4BuyButton);
        pro4BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[3], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product 5
        pro5Panel = new JPanel();
        // pro5Panel.setBackground(Color.YELLOW);
        pro5Panel.setLayout(null);
        pro5Panel.setBounds(0, 500, 400, 400);
        itemsPanel.add(pro5Panel);
        // product5 image
        pro5img = new JButton();
        pro5img.setIcon(new ImageIcon(products[4].getProductImage()));
        pro5img.setBounds(15, 15, 350 + 25, 250);
        pro5img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro5img.setBackground(Color.WHITE);
        pro5Panel.add(pro5img);
        pro5img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[4], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product5 name
        pro5Label = new JLabel(products[4].getProductName());
        pro5Label.setBounds(15, (15 + 250), 300, 30);
        pro5Label.setFont(normalFont);
        pro5Label.setForeground(Color.BLACK);
        pro5Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro5Panel.add(pro5Label);
        pro4Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[4], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product5 price
        pro5PriceLabel = new JLabel(products[4].getProductPrice() + "$");
        pro5PriceLabel.setBounds(15, (250 + 45), 150, 50);
        pro5PriceLabel.setFont(priceFont);
        pro5PriceLabel.setForeground(Color.BLUE);
        pro5PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro5Panel.add(pro5PriceLabel);
        pro5PriceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[4], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product5 buy
        pro5BuyButton = new JButton("Buy");
        pro5BuyButton.setBackground(Color.decode("#9dade1"));
        pro5BuyButton.setBounds(300, 340, 80, 40);
        pro5BuyButton.setFont(normalFont);
        pro5BuyButton.setForeground(Color.WHITE);
        pro5BuyButton.setBackground(Color.BLACK);
        pro5BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro5Panel.add(pro5BuyButton);
        pro5BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[4], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product 6
        pro6Panel = new JPanel();
        // pro6Panel.setBackground(Color.BLUE);
        pro6Panel.setLayout(null);
        pro6Panel.setBounds(400, 500, 400, 400);
        itemsPanel.add(pro6Panel);
        // product6 image
        pro6img = new JButton();
        pro6img.setIcon(new ImageIcon(products[5].getProductImage()));
        pro6img.setBounds(15, 15, 350 + 25, 250);
        pro6img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro6img.setBackground(Color.WHITE);
        pro6Panel.add(pro6img);
        pro6img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[5], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product6 name
        pro6Label = new JLabel(products[5].getProductName());
        pro6Label.setBounds(15, (15 + 250), 300, 30);
        pro6Label.setFont(normalFont);
        pro6Label.setForeground(Color.BLACK);
        pro6Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro6Panel.add(pro6Label);
        pro6Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[5], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product6 price
        pro6PriceLabel = new JLabel(products[5].getProductPrice() + "$");
        pro6PriceLabel.setBounds(15, (250 + 45), 150, 50);
        pro6PriceLabel.setFont(priceFont);
        pro6PriceLabel.setForeground(Color.BLUE);
        pro6PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro6Panel.add(pro6PriceLabel);
        pro6PriceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[5], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product6 buy
        pro6BuyButton = new JButton("Buy");
        pro6BuyButton.setBackground(Color.decode("#9dade1"));
        pro6BuyButton.setBounds(300, 340, 80, 40);
        pro6BuyButton.setFont(normalFont);
        pro6BuyButton.setForeground(Color.WHITE);
        pro6BuyButton.setBackground(Color.BLACK);
        pro6BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro6Panel.add(pro6BuyButton);
        pro6BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[5], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product 7
        pro7Panel = new JPanel();
        // pro7Panel.setBackground(Color.GREEN);
        pro7Panel.setLayout(null);
        pro7Panel.setBounds(800, 500, 400, 400);
        itemsPanel.add(pro7Panel);
        // product7 image
        pro7img = new JButton();
        pro7img.setIcon(new ImageIcon(products[6].getProductImage()));
        pro7img.setBounds(15, 15, 350 + 25, 250);
        pro7img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro7img.setBackground(Color.WHITE);
        pro7Panel.add(pro7img);
        pro7img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[6], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product7 name
        pro7Label = new JLabel(products[6].getProductName());
        pro7Label.setBounds(15, (15 + 250), 300, 30);
        pro7Label.setFont(normalFont);
        pro7Label.setForeground(Color.BLACK);
        pro7Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro7Panel.add(pro7Label);
        pro7Label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[6], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product7 price
        pro7PriceLabel = new JLabel(products[6].getProductPrice() + "$");
        pro7PriceLabel.setBounds(15, (250 + 45), 150, 50);
        pro7PriceLabel.setFont(priceFont);
        pro7PriceLabel.setForeground(Color.BLUE);
        pro7PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro7Panel.add(pro7PriceLabel);
        pro7Panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[6], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product7 buy
        pro7BuyButton = new JButton("Buy");
        pro7BuyButton.setBackground(Color.decode("#9dade1"));
        pro7BuyButton.setBounds(300, 340, 80, 40);
        pro7BuyButton.setFont(normalFont);
        pro7BuyButton.setForeground(Color.WHITE);
        pro7BuyButton.setBackground(Color.BLACK);
        pro7BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro7Panel.add(pro7BuyButton);
        pro7BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[6], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });

        // product 8
        pro8Panel = new JPanel();
        // pro8Panel.setBackground(Color.BLACK);
        pro8Panel.setLayout(null);
        pro8Panel.setBounds(1200, 500, 400, 400);
        itemsPanel.add(pro8Panel);
        // product8 image
        pro8img = new JButton();
        pro8img.setIcon(new ImageIcon(products[7].getProductImage()));
        pro8img.setBounds(15, 15, 350, 250);
        pro8img.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro8img.setBackground(Color.WHITE);
        pro8Panel.add(pro8img);
        pro8img.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[7], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product8 name
        pro8Label = new JLabel(products[7].getProductName());
        pro8Label.setBounds(15, (15 + 250), 300, 30);
        pro8Label.setFont(normalFont);
        pro8Label.setForeground(Color.BLACK);
        pro8Label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro8Panel.add(pro8Label);
        pro8Panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[7], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product8 price
        pro8PriceLabel = new JLabel(products[7].getProductPrice() + "$");
        pro8PriceLabel.setBounds(15, (250 + 45), 150, 50);
        pro8PriceLabel.setFont(priceFont);
        pro8PriceLabel.setForeground(Color.BLUE);
        pro8PriceLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro8Panel.add(pro8PriceLabel);
        pro8PriceLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Add your action here
                System.out.println("Product 1 label clicked!");
                productDetailFrame pdf = new productDetailFrame(products[7], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
        // product8 buy
        pro8BuyButton = new JButton("Buy");
        pro8BuyButton.setBackground(Color.decode("#9dade1"));
        pro8BuyButton.setBounds(300 - 25, 340, 80, 40);
        pro8BuyButton.setFont(normalFont);
        pro8BuyButton.setForeground(Color.WHITE);
        pro8BuyButton.setBackground(Color.BLACK);
        pro8BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pro8Panel.add(pro8BuyButton);
        pro8BuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy button clicked");
                productDetailFrame pdf = new productDetailFrame(products[7], c1);
                pdf.setVisible(true);
                setVisibility(false);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

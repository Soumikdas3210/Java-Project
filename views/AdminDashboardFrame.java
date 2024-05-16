package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Admin;
import entity.User;
import classes.*;

public class AdminDashboardFrame extends JFrame implements ActionListener {

    private JPanel jp1, jp2;
    private JLabel titleLabel, usernameLabel, userinfoLabel,
            salesinfoLabel, newadminLabel, employeeLabel,
            productLabel;
    private JButton productinfoBtn, addadminBtn, salesinfoBtn, userBtn, signoutBtn, userInfoBtn;
    private Font headingFont, normalFont;

    private Admin a1;

    public AdminDashboardFrame(Admin a1) {

        super("First Page");
        super.setSize(1600, 900);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.a1 = a1;

        headingFont = new Font("Roboto", Font.PLAIN, 20);
        normalFont = new Font("Roboto", Font.PLAIN, 25);

        jp1 = new JPanel();
        jp1.setBounds(0, 0, 800, 900);
        ImageIcon img = new ImageIcon("images/adminDash.png");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 800, 900);
        jp1.add(imgLabel);

        jp2 = new JPanel();
        jp2.setBackground(Color.CYAN);
        jp2.setBounds(800, 0, 800, 900);
        jp2.setLayout(null);

        // titleLabel = new JLabel("Admin Dashboard");
        // titleLabel.setFont(headingFont);
        // titleLabel.setBounds(20, 18, 300, 35);
        // jp2.add(titleLabel);

        ImageIcon userImageIcon = new ImageIcon("images/mini_avatar.png");
        userBtn = new JButton(userImageIcon);
        userBtn.setBounds(25, 10, 80, 80); // Set preferred size for circular button
        userBtn.setOpaque(false);
        userBtn.setFocusPainted(true);
        userBtn.setBorder(BorderFactory.createEmptyBorder());
        userBtn.setBackground(Color.BLACK);
        userBtn.addActionListener(this);
        jp2.add(userBtn);

        usernameLabel = new JLabel(a1.getUsername());
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(130, 30, 500, 35);
        jp2.add(usernameLabel);

        signoutBtn = new JButton("Sign Out");
        signoutBtn.setFont(headingFont);
        signoutBtn.setBounds(650, 30, 120, 35);
        signoutBtn.addActionListener(this);
        jp2.add(signoutBtn);

        userInfoBtn = new JButton();
        userInfoBtn.setIcon(new ImageIcon("images/adminDashUserInfo.png"));
        userInfoBtn.setBounds(23, 170, 360, 200);
        userInfoBtn.setOpaque(false);
        userInfoBtn.setFocusPainted(true);
        userInfoBtn.setBorder(BorderFactory.createEmptyBorder());
        userInfoBtn.addActionListener(this);
        jp2.add(userInfoBtn);

        userinfoLabel = new JLabel("User Info");
        userinfoLabel.setFont(normalFont);
        userinfoLabel.setBounds(130, 380, 150, 35);
        jp2.add(userinfoLabel);

        salesinfoBtn = new JButton();
        salesinfoBtn.setIcon(new ImageIcon("images/adminDashTransictionInfo.png"));
        salesinfoBtn.setBounds(403, 170, 360, 200);
        salesinfoBtn.setOpaque(false);
        salesinfoBtn.setFocusPainted(true);
        salesinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(salesinfoBtn);

        salesinfoLabel = new JLabel("Sales Info");
        salesinfoLabel.setFont(normalFont);
        salesinfoLabel.setBounds(520, 380, 180, 35);
        jp2.add(salesinfoLabel);

        addadminBtn = new JButton();
        addadminBtn.setIcon(new ImageIcon("images/userinfo.jpg"));
        addadminBtn.setBounds(23, 430, 360, 200);
        addadminBtn.setOpaque(false);
        addadminBtn.setFocusPainted(true);
        addadminBtn.setBorder(BorderFactory.createEmptyBorder());
        addadminBtn.addActionListener(this);
        jp2.add(addadminBtn);

        newadminLabel = new JLabel("Add Admin");
        newadminLabel.setFont(normalFont);
        newadminLabel.setBounds(145, 640, 180, 35);
        jp2.add(newadminLabel);

        productinfoBtn = new JButton();
        productinfoBtn.setIcon(new ImageIcon("images/adminDashProductInfo.png"));
        productinfoBtn.setBounds(403, 430, 360, 200);
        productinfoBtn.setOpaque(false);
        productinfoBtn.setFocusPainted(true);
        productinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        productinfoBtn.addActionListener(this);
        jp2.add(productinfoBtn);

        productLabel = new JLabel("Product Info");
        productLabel.setFont(normalFont);
        productLabel.setBounds(505, 640, 180, 35);
        jp2.add(productLabel);

        // productinfoBtn = new JButton();
        // productinfoBtn.setIcon(new ImageIcon("image/userinfo.jpg"));
        // productinfoBtn.setBounds(213, 550, 360, 200);
        // productinfoBtn.setOpaque(false);
        // productinfoBtn.setFocusPainted(true);
        // productinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        // jp2.add(productinfoBtn);

        // employeeLabel = new JLabel("Employee Information");
        // employeeLabel.setFont(normalFont);
        // employeeLabel.setBounds(305, 750, 180, 35);
        // jp2.add(employeeLabel);

        super.add(jp1);
        super.add(jp2);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addadminBtn) {
            AddAdminFrame aaf = new AddAdminFrame(a1);
            aaf.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == signoutBtn) {
            LoginFrame lf = new LoginFrame();
            lf.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == userBtn) {
            // Admin a2 = new Admin(a1.getUsername(), a1.getPassword());
            profileFrame Pf = new profileFrame(a1);
            System.out.println(a1.getEmail());
            Pf.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == userInfoBtn) {
            UserTable usertable = new UserTable();
            usertable.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == productinfoBtn) {
            ProductTable producttable = new ProductTable();
            producttable.setVisible(true);
            this.setVisible(false);
        }

    }
}

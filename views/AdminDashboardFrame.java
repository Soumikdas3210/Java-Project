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
import classes.*;

public class AdminDashboardFrame extends JFrame implements ActionListener {

    JPanel jp1, jp2;
    JLabel titleLabel, usernameLabel, userinfoLabel,
            salesinfoLabel, newadminLabel, employeeLabel,
            productLabel;
    JButton userinfoBtn, productinfoBtn, addadminBtn, salesinfoBtn, usernameBtn, signoutBtn;
    Font headingFont, normalFont;

    private Admin a1;

    public AdminDashboardFrame(Admin a1) {

        super("First Page");
        super.setSize(1600, 900);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.a1 = a1;

        headingFont = new Font("Cambria", Font.PLAIN, 30);
        normalFont = new Font("Cambria", Font.PLAIN, 20);

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

        titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setFont(headingFont);
        titleLabel.setBounds(20, 18, 300, 35);
        jp2.add(titleLabel);

        usernameLabel = new JLabel(a1.getUsername());
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(480, 18, 200, 35);
        //usernameLabel.addActionListener(this);
        jp2.add(usernameLabel);

        signoutBtn = new JButton("Sign Out");
        signoutBtn.setFont(normalFont);
        signoutBtn.setBounds(650, 18, 120, 35);
        signoutBtn.addActionListener(this);
        jp2.add(signoutBtn);

        userinfoBtn = new JButton();
        ImageIcon userinfo = new ImageIcon("images/adminDashUserInfo.png");
        userinfoBtn.setIcon(userinfo);
        userinfoBtn.setBounds(23, 120, 360, 200);
        userinfoBtn.setOpaque(false);
        userinfoBtn.setFocusPainted(true);
        userinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(userinfoBtn);

        userinfoLabel = new JLabel("User Info");
        userinfoLabel.setFont(normalFont);
        userinfoLabel.setBounds(130, 320, 150, 35);
        jp2.add(userinfoLabel);

        salesinfoBtn = new JButton();
        salesinfoBtn.setIcon(new ImageIcon("images/adminDashTransictionInfo.png"));
        salesinfoBtn.setBounds(403, 120, 360, 200);
        salesinfoBtn.setOpaque(false);
        salesinfoBtn.setFocusPainted(true);
        salesinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(salesinfoBtn);

        salesinfoLabel = new JLabel("Sales Information");
        salesinfoLabel.setFont(normalFont);
        salesinfoLabel.setBounds(520, 320, 180, 35);
        jp2.add(salesinfoLabel);

        addadminBtn = new JButton();
        addadminBtn.setIcon(new ImageIcon("images/userinfo.jpg"));
        addadminBtn.setBounds(23, 360, 360, 200);
        addadminBtn.setOpaque(false);
        addadminBtn.setFocusPainted(true);
        addadminBtn.setBorder(BorderFactory.createEmptyBorder());
        addadminBtn.addActionListener(this);
        jp2.add(addadminBtn);

        newadminLabel = new JLabel("Add Admin");
        newadminLabel.setFont(normalFont);
        newadminLabel.setBounds(145, 560, 180, 35);
        jp2.add(newadminLabel);

        productinfoBtn = new JButton();
        productinfoBtn.setIcon(new ImageIcon("images/adminDashProductInfo.png"));
        productinfoBtn.setBounds(403, 360, 360, 200);
        productinfoBtn.setOpaque(false);
        productinfoBtn.setFocusPainted(true);
        productinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(productinfoBtn);

        productLabel = new JLabel("Product Information");
        productLabel.setFont(normalFont);
        productLabel.setBounds(505, 560, 180, 35);
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
        }

    }
}

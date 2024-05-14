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
import repository.UserRepository;

public class AdminDashboardFrame extends JFrame implements ActionListener  {
    private String username, password;

    JPanel jp1, jp2;
    JLabel titleLabel, usernameLabel, signoutLabel, userinfoLabel,
           salesinfoLabel, newadminLabel, employeeLabel,
           productLabel;
    JButton userinfoBtn, productinfoBtn, addadminBtn, salesinfoBtn, usernameBtn;       
    Font headingFont, normalFont;       

    public AdminDashboardFrame(String username, String password){

        super("First Page");
        super.setSize(1600, 900);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.username = username;
        this.password = password;
        Admin a1 = new Admin(username, password);

        headingFont = new Font("Cambria", Font.PLAIN, 30);
        normalFont = new Font("Cambria", Font.PLAIN, 20);

        jp1 = new JPanel();
        jp1.setBackground(Color.GREEN);
        jp1.setBounds(0, 0, 800, 900);
        
        jp2 = new JPanel();
        jp2.setBackground(Color.CYAN);
        jp2.setBounds(800, 0, 800, 900);
        jp2.setLayout(null);

        titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setFont(headingFont);
        titleLabel.setBounds(20, 18, 300, 35);
        jp2.add(titleLabel);

        usernameBtn = new JButton("User name");
        usernameBtn.setFont(normalFont);
        usernameBtn.setBounds(480, 18, 120, 35);
        usernameBtn.addActionListener(this);
        jp2.add(usernameBtn);

        signoutLabel = new JLabel("Sign Out");
        signoutLabel.setFont(normalFont);
        signoutLabel.setBounds(650, 18, 120, 35);
        jp2.add(signoutLabel);

        userinfoBtn = new JButton();
        userinfoBtn.setIcon(new ImageIcon("image/userinfo.jpg"));
        userinfoBtn.setBounds(23, 70,360,200);
        userinfoBtn.setOpaque(false);
        userinfoBtn.setFocusPainted(true);
        userinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(userinfoBtn);

        userinfoLabel = new JLabel("User Information");
        userinfoLabel.setFont(normalFont);
        userinfoLabel.setBounds(130, 270, 150, 35);
        jp2.add(userinfoLabel);

        salesinfoBtn = new JButton();
        salesinfoBtn.setIcon(new ImageIcon("image/userinfo.jpg"));
        salesinfoBtn.setBounds(403, 70,360,200);
        salesinfoBtn.setOpaque(false);
        salesinfoBtn.setFocusPainted(true);
        salesinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(salesinfoBtn);

        salesinfoLabel = new JLabel("Sales Information");
        salesinfoLabel.setFont(normalFont);
        salesinfoLabel.setBounds(520, 270, 180, 35);
        jp2.add(salesinfoLabel);

        addadminBtn = new JButton();
        addadminBtn.setIcon(new ImageIcon("image/userinfo.jpg"));
        addadminBtn.setBounds(23, 310,360,200);
        addadminBtn.setOpaque(false);
        addadminBtn.setFocusPainted(true);
        addadminBtn.setBorder(BorderFactory.createEmptyBorder());
        addadminBtn.addActionListener(this);
        jp2.add(addadminBtn);

        newadminLabel = new JLabel("Add Admin");
        newadminLabel.setFont(normalFont);
        newadminLabel.setBounds(145, 510, 180, 35);
        jp2.add( newadminLabel);

        productinfoBtn = new JButton();
        productinfoBtn.setIcon(new ImageIcon("image/userinfo.jpg"));
        productinfoBtn.setBounds(403, 310,360,200);
        productinfoBtn.setOpaque(false);
        productinfoBtn.setFocusPainted(true);
        productinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(productinfoBtn);

        productLabel = new JLabel("Product Information");
        productLabel.setFont(normalFont);
        productLabel.setBounds(505, 510, 180, 35);
        jp2.add( productLabel);

        productinfoBtn = new JButton();
        productinfoBtn.setIcon(new ImageIcon("image/userinfo.jpg"));
        productinfoBtn.setBounds(213, 550,360,200);
        productinfoBtn.setOpaque(false);
        productinfoBtn.setFocusPainted(true);
        productinfoBtn.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(productinfoBtn);

        productLabel = new JLabel("Employee Information");
        productLabel.setFont(normalFont);
        productLabel.setBounds(305, 750, 180, 35);
        jp2.add( productLabel);


        super.add(jp1);
        super.add(jp2);

    }
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == addadminBtn){
            AddAdminFrame aaf = new AddAdminFrame();
            aaf.setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==usernameBtn){

        }
        
    }
}

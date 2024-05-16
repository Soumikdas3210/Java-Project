package views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class UserInfoFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public UserInfoFrame() {
        setTitle("User Data");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        table = new JTable(model);

        // Add columns to the table
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Email");
        model.addColumn("Question");
        model.addColumn("Answer");

        // Load data from file
        loadData();

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void loadData() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/user.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 6) {
                    model.addRow(new Object[] { parts[0], parts[1], parts[2], parts[4], parts[5] });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

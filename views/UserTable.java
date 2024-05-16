package views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserTable extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public UserTable() {
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

        // Add Edit button
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Get data from selected row
                    String username = (String) table.getValueAt(selectedRow, 0);
                    String password = (String) table.getValueAt(selectedRow, 1);
                    String email = (String) table.getValueAt(selectedRow, 2);
                    String question = (String) table.getValueAt(selectedRow, 3);
                    String answer = (String) table.getValueAt(selectedRow, 4);

                    // Open a dialog for editing
                    EditUserDialog editDialog = new EditUserDialog(UserTable.this, username, password, email, question, answer);
                    editDialog.setVisible(true);

                    // Update table if changes are made
                    if (editDialog.isOkPressed()) {
                        table.setValueAt(editDialog.getUsername(), selectedRow, 0);
                        table.setValueAt(editDialog.getPassword(), selectedRow, 1);
                        table.setValueAt(editDialog.getEmail(), selectedRow, 2);
                        table.setValueAt(editDialog.getQuestion(), selectedRow, 3);
                        table.setValueAt(editDialog.getAnswer(), selectedRow, 4);
                    }
                } else {
                    JOptionPane.showMessageDialog(UserTable.this, "Please select a row to edit.");
                }
            }
        });

        getContentPane().add(editButton, BorderLayout.SOUTH);
    }

    private void loadData() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/user.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 6) {
                    model.addRow(new Object[]{parts[0], parts[1], parts[2], parts[4], parts[5]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

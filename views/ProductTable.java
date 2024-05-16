package views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductTable extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public ProductTable() {
        setTitle("Product Data");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Allow editing for all cells
                return true;
            }
        };
        table = new JTable(model);

        // Add columns to the table
        model.addColumn("Product Name");
        model.addColumn("Price");
        model.addColumn("SKU");
        model.addColumn("Image");
        model.addColumn("Details");

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
                // Save data to file when Edit button is clicked
                saveData();
            }
        });
        getContentPane().add(editButton, BorderLayout.SOUTH);
    }

    private void loadData() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/productData.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    model.addRow(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        try (FileWriter writer = new FileWriter("data/productData.txt")) {
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
            System.out.println("Product data updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         ProductTable productTable = new ProductTable();
    //         productTable.setVisible(true);
    //     });
    // }
}

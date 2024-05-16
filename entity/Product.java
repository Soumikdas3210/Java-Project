package entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Product {
    private String productName;
    private double productPrice;
    private String productSku;
    private String productImage;
    private String productDetails;

    public Product(String productName, double productPrice, String productSku, String productImage,
            String productDetails) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSku = productSku;
        this.productImage = productImage;
        this.productDetails = productDetails;
    }

    public static Product[] loadProductsFromFile(String filename) {
        Product[] products = new Product[8]; // Creating an array of size 8
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < 8) {
                // System.out.println("Reading line: " + line); // Debug
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String productName = parts[0].trim();
                    double productPrice = Double.parseDouble(parts[1].trim());
                    String productSku = parts[2].trim();
                    String productImage = parts[3].trim();
                    String productDetails = parts[4].trim();
                    products[index++] = new Product(productName, productPrice, productSku, productImage,
                            productDetails);
                } else {
                    System.err.println("Invalid line: " + line); // Debug
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return products;
    }

    public void addProduct(String productName, double productPrice, String productSku, String productImage,
            String productDetails) {
        try (FileWriter writer = new FileWriter("productData.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            // Append product data to the file
            bufferedWriter.write(
                    productName + "," + productPrice + "," + productSku + "," + productImage + "," + productDetails);
            bufferedWriter.newLine(); // Add a new line for the next product
            System.out.println("Product added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Getters for attributes
    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductSku() {
        return productSku;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductDetails() {
        return productDetails;
    }
}

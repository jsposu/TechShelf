import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private static int productCounter = 1;

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        boolean running = true;

        while (running) {
            String option = JOptionPane.showInputDialog(
                    "TECHSHELF MENU\n\n" +
                    "1. Add Product\n" +
                    "2. Show Products\n" +
                    "3. Exit\n\n" +
                    "Choose an option:"
            );

            if (option == null) break; // User closed window

            switch (option) {

                case "1":
                    addProduct(products);
                    break;

                case "2":
                    showProducts(products);
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid option. Please try again.");
            }
        }
    }

    // ------------------------------------
    //      ADD NEW PRODUCT
    // ------------------------------------
    private static void addProduct(ArrayList<Product> products) {

        String name = inputText("Product Name:");
        if (name == null) return;

        String description = inputText("Product Description:");
        if (description == null) return;

        String manufacturer = inputText("Manufacturer:");
        if (manufacturer == null) return;

        String model = inputText("Model:");
        if (model == null) return;

        double price = inputDouble("Price:");
        if (Double.isNaN(price)) return; // Cancel pressed

        int stock = inputInt("Stock Quantity:");
        if (stock == Integer.MIN_VALUE) return; // Cancel pressed

        // Generate ID automatically
        String id = String.format("P%03d", productCounter);
        productCounter++;

        Product p = new Product(id, name, description, manufacturer, model, id, price, stock);
        products.add(p);

        JOptionPane.showMessageDialog(null,
                "Product added successfully!\nID: " + id);
    }

    // ------------------------------------
    //     SHOW ALL SAVED PRODUCTS
    // ------------------------------------
    private static void showProducts(ArrayList<Product> products) {

        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products stored.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("PRODUCT LIST:\n\n");

        for (Product p : products) {
            sb.append("ID: ").append(p.getProductId()).append("\n")
              .append("Name: ").append(p.getName()).append("\n")
              .append("Price: $").append(p.getPrice()).append("\n")
              .append("Stock: ").append(p.getStockQuantity()).append("\n")
              .append("-------------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // ------------------------------------
    //      VALIDATION METHODS
    // ------------------------------------

    // Validate text fields (not empty, allow cancel)
    private static String inputText(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(message);

            if (input == null) return null;  // cancel pressed
            if (!input.trim().isEmpty()) return input.trim();

            JOptionPane.showMessageDialog(null, "Error: this field cannot be empty.");
        }
    }

    // Validate double (price) — cancel returns NaN
    private static double inputDouble(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(message);

            if (input == null) return Double.NaN;  // cancel

            try {
                double value = Double.parseDouble(input);
                if (value >= 0) return value;

                JOptionPane.showMessageDialog(null, "Error: price cannot be negative.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: enter a valid number.");
            }
        }
    }

    // Validate integer (stock) — cancel returns Integer.MIN_VALUE
    private static int inputInt(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(message);

            if (input == null) return Integer.MIN_VALUE;  // cancel

            try {
                int value = Integer.parseInt(input);
                if (value >= 0) return value;

                JOptionPane.showMessageDialog(null, "Error: stock cannot be negative.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: enter a valid integer.");
            }
        }
    }
}

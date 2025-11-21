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

        String name = JOptionPane.showInputDialog("Product Name:");
        if (name == null) return;

        String description = JOptionPane.showInputDialog("Product Description:");
        if (description == null) return;

        String manufacturer = JOptionPane.showInputDialog("Manufacturer:");
        if (manufacturer == null) return;

        String model = JOptionPane.showInputDialog("Model:");
        if (model == null) return;

        double price = Double.parseDouble(
                JOptionPane.showInputDialog("Price:")
        );

        int stock = Integer.parseInt(
                JOptionPane.showInputDialog("Stock Quantity:")
        );

        // Generate product ID automatically (P001, P002, etc.)
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
}

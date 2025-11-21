public class Transaction {

    private String transactionId;
    private String date;
    private String type; // "sale" or "purchase"
    private String customerOrSupplierId;
    private String productId;
    private int quantity;
    private double totalPrice;

    public Transaction(String transactionId, String date, String type, String customerOrSupplierId, String productId, int quantity, double totalPrice) {

        this.transactionId = transactionId;
        this.date = date;
        this.type = type;
        this.customerOrSupplierId = customerOrSupplierId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getCustomerOrSupplierId() {
        return customerOrSupplierId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

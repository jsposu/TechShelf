public class Product {

    private String productId;
    private String name;
    private String description;
    private String manufacturer;
    private String model;
    private String serialTag;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, String description, String manufacturer, String model, String serialTag, double price, int stockQuantity) {

        this.productId = productId;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialTag = serialTag;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters  
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getserialTag() {
        return serialTag;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Setters that make sense (optional)
    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}

public class Supplier {

    private String supplierId;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Supplier(String supplierId, String name, String phone, String email, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Getters
    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

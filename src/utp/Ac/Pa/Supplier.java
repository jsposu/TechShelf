
import java.time.LocalDate;

public class Supplier {

    private int supplierId;
    private String nameSupplier;
    private String phone;
    private String email;
    private String address;
    private MetodosPagos MetodoPagoS;
    private LocalDate registrationDate;

    public Supplier(int supplierId, String nameSupplier, String phone, String email, String address, 
                   LocalDate registrationDate, MetodosPagos MetodoPagoS) {
        this.supplierId = supplierId;
        this.nameSupplier = nameSupplier;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.MetodoPagoS = MetodoPagoS;
        this.registrationDate = registrationDate;
    }

    // Getters
    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return nameSupplier;
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

        public MetodosPagos getMetodoPagoS() {
        return MetodoPagoS;
    }
}

public class MetodosPagos {
int idMetodoPago;
String nombreMetodoPago;

    // Constructor
    public MetodosPagos(int idMetodoPago, String nombreMetodoPago) {
        this.idMetodoPago = idMetodoPago;
        this.nombreMetodoPago = nombreMetodoPago;
    }

    // Getters
    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }    
}

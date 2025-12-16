import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {

    private static int productCounter = 1;

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Roles> listaRoles = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Supplier> listasuppliers = new ArrayList<>();
        ArrayList<MetodosPagos> listasMetodosPagos = new ArrayList<>();
        boolean running = true;

        while (running) {
            String option = JOptionPane.showInputDialog(
                    "TECHSHELF MENU\n\n" +
                    "1. Add Product\n" +
                    "2. Show Products\n" +
                    "3. Add Users\n" +
                    "4. Add Roles\n" +
                    "5. Add Suppliers\n" +
                    "6. Add Metodos de Pago\n" +
                    "7. Add Warranty\n" +
                    "8. Add ListapreCAB\n" +
                    "9. Add LispreDT\n" +
                    "10. Exit\n\n" +
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
                    AddUsuario(listaUsuarios, listaRoles, LocalDate.now(), LocalDate.now(),
                    "Nombre", "ApellidoPaterno", "ApellidoMaterno",
                    true); 
                    break;
                case "4":
                    addRoles(listaRoles);
                    break;
                case "5":
                    addSuppliers(listasuppliers,listasMetodosPagos);
                    break;
                case "6":
                    AddMetodosPagos(listasMetodosPagos);
                    break;
                case "10":
                    running = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid option. Please try again.");
            }
        }
    }

    // CREAR METODOS DE PAGOS 
    private static void AddMetodosPagos(ArrayList<MetodosPagos> metodosPagos) {

        String nombreMetodoPago = JOptionPane.showInputDialog("Enter Metodo de Pago Name:");
        if (nombreMetodoPago == null || nombreMetodoPago.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Metodo de Pago name cannot be empty.");
            return;
        }

        // Generate Metodo de Pago ID automatically
        int newMetodoPagoId = metodosPagos.size() + 1;

        MetodosPagos newMetodoPago = new MetodosPagos(newMetodoPagoId, nombreMetodoPago.trim());
        metodosPagos.add(newMetodoPago);

        JOptionPane.showMessageDialog(null,
                "Metodo de Pago added successfully!" +
                "\nID: " + newMetodoPagoId +
                "\nName: " + nombreMetodoPago);
    }


// CREAR SUPPLIERS
    private static void addSuppliers(
        ArrayList<Supplier> suppliers,
        ArrayList<MetodosPagos> metodosPagos) {

    String nameSupplier = JOptionPane.showInputDialog("Enter Supplier Name:");
    if (nameSupplier == null || nameSupplier.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Supplier name cannot be empty.");
        return;
    }

    String phone = JOptionPane.showInputDialog("Enter Phone:");
    if (phone == null || phone.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Phone cannot be empty.");
        return;
    }

    String email = JOptionPane.showInputDialog("Enter Email:");
    if (email == null || email.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Email cannot be empty.");
        return;
    }

    String address = JOptionPane.showInputDialog("Enter Address:");
    if (address == null || address.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Address cannot be empty.");
        return;
    }

    // Mostrar métodos de pago
    StringBuilder metodoPagoOptions = new StringBuilder("Select Metodo de pago by ID:\n");
    for (MetodosPagos metodoPago : metodosPagos) {
        metodoPagoOptions
            .append(metodoPago.getIdMetodoPago())
            .append(". ")
            .append(metodoPago.getNombreMetodoPago())
            .append("\n");
    }

    String metodoPagoStr = JOptionPane.showInputDialog(metodoPagoOptions.toString());
    if (metodoPagoStr == null || metodoPagoStr.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Metodo de pago selection cannot be empty.");
        return;
    }

    int idMetodoPago;
    try {
        idMetodoPago = Integer.parseInt(metodoPagoStr.trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid MetodoPago ID.");
        return;
    }

    // Buscar método de pago seleccionado
    MetodosPagos selectedMetodoPago = null;
    for (MetodosPagos metodoPago : metodosPagos) {
        if (metodoPago.getIdMetodoPago() == idMetodoPago) {
            selectedMetodoPago = metodoPago;
            break;
        }
    }

    if (selectedMetodoPago == null) {
        JOptionPane.showMessageDialog(null, "Metodo de pago not found.");
        return;
    }

    // Generar ID automático
    int supplierId = suppliers.size() + 1;

    Supplier newSupplier = new Supplier(
            supplierId,
            nameSupplier,
            phone,
            email,
            address,
            LocalDate.now(),
            selectedMetodoPago
    );

    suppliers.add(newSupplier);

    JOptionPane.showMessageDialog(null,
            "Supplier added successfully!" +
            "\nID: " + supplierId +
            "\nName: " + nameSupplier +
            "\nPhone: " + phone +
            "\nEmail: " + email +
            "\nAddress: " + address +
            "\nPayment Method: " + selectedMetodoPago.getNombreMetodoPago());
}


    // CREAR ROLES 
    private static void addRoles(ArrayList<Roles> roles) {

    String roleName = JOptionPane.showInputDialog("Enter Role Name:");
    if (roleName == null || roleName.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Role name cannot be empty.");
        return;
    }
/*
    String roleDescription = JOptionPane.showInputDialog("Enter Role Description:");
    if (roleDescription == null || roleDescription.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Role description cannot be empty.");
        return;
    }*/

    int newRoleId = roles.size() + 1;

    Roles newRole = new Roles(newRoleId, roleName.trim() /*, roleDescription.trim() */, true);
    roles.add(newRole);

    JOptionPane.showMessageDialog(null,
            "Role added successfully!" +
            "\nID: " + newRoleId +
            "\nName: " + roleName+
            "\nEstado: " + true);
            //"\nDescription: " + roleDescription);
        }

    //crear usuarios
    private static void AddUsuario(ArrayList<Usuario> usuarios, ArrayList<Roles> roles, LocalDate FNacimiento, LocalDate FIngreso,
                   String nombre, String ApellidoPaterno, String ApellidoMaterno,
                    boolean estado) {

        String username = JOptionPane.showInputDialog("Enter Username:");
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter Password:");
        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.");
            return;
        }

        StringBuilder roleOptions = new StringBuilder("Select Role by ID:\n");
        for (Roles role : roles) {
            roleOptions.append(role.getId()).append(". ").append(role.getName()).append("\n");
        }

        String roleIdStr = JOptionPane.showInputDialog(roleOptions.toString());
        if (roleIdStr == null || roleIdStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Role selection cannot be empty.");
            return;
        }

        int roleId;
        try {
            roleId = Integer.parseInt(roleIdStr.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Role ID.");
            return;
        }

        Roles selectedRole = null;
        for (Roles role : roles) {
            if (role.getId() == roleId) {
                selectedRole = role;
                break;
            }
        }

        if (selectedRole == null) {
            JOptionPane.showMessageDialog(null, "Role not found.");
            return;
        }

        String nombreU = JOptionPane.showInputDialog("Enter Nombre:");
        if (nombreU == null || nombreU.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre cannot be empty.");
            return;
        }

        String ApellidoPaternoU = JOptionPane.showInputDialog("Enter Apellido Paterno:");
        if (ApellidoPaternoU == null || ApellidoPaternoU.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Apellido Paterno cannot be empty.");
            return;
        }

        String ApellidoMaternoU = JOptionPane.showInputDialog("Enter Apellido Materno:");
        if (ApellidoMaternoU == null || ApellidoMaternoU.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Apellido Materno cannot be empty.");
            return;
        }

        //String ApellidoCasada = JOptionPane.showInputDialog("Enter Apellido Casada:");
        //String UltPassword = JOptionPane.showInputDialog("Enter Ult Password:");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // ===== FECHA DE NACIMIENTO =====
        LocalDate FNacimientoU = null;
        try {
        String txtFNacimiento = JOptionPane.showInputDialog(
        "Ingrese Fecha de Nacimiento (dd/MM/yyyy):"
        );

        if (txtFNacimiento == null || txtFNacimiento.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede estar vacía");
        return;
        }
        FNacimientoU = LocalDate.parse(txtFNacimiento.trim(), formato);

        } catch (DateTimeParseException e) {
         JOptionPane.showMessageDialog(null, "Formato inválido. Use dd/MM/yyyy");
         return;
       }

       // ===== FECHA DE INGRESO =====
        LocalDate FIngresoU = null;
        try {
        String txtFIngreso = JOptionPane.showInputDialog(
        "Ingrese Fecha de Ingreso (dd/MM/yyyy):"
       );

       if (txtFIngreso == null || txtFIngreso.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "La fecha de ingreso no puede estar vacía");
        return;
      }

       FIngresoU = LocalDate.parse(txtFIngreso.trim(), formato);

     } catch (DateTimeParseException e) {
      JOptionPane.showMessageDialog(null, "Formato inválido. Use dd/MM/yyyy");
      return;
     }       

        //LocalDate FecModPass = LocalDate.now(); // Placeholder, replace with actual input
        boolean estadoU = true; // Placeholder, replace with actual input 

        Usuario newUser = new Usuario(username.trim(), password.trim(), selectedRole, FNacimientoU, FIngresoU,
                   nombre.trim(), ApellidoPaternoU.trim(), ApellidoMaternoU.trim(), estadoU);
        usuarios.add(newUser);

        JOptionPane.showMessageDialog(null,
                "User added successfully!" +
                "\nUsername: " + username +
                "\nRole: " + selectedRole.getName() +
                "\nNombre: " + nombreU +
                "\nApellido Paterno: " + ApellidoPaternoU +
                "\nApellido Materno: " + ApellidoMaternoU +
                /*"\nApellido Casada: " + ApellidoCasada +
                "\nUlt Password: " + UltPassword + */
                "\nFNacimiento: " + FNacimientoU +
                "\nFIngreso: " + FIngresoU +
                //"\nFecModPass: " + FecModPass +
                "\nEstado: " + estadoU);
    }

    // ------------------------------------
    //      ADD NEW PRODUCT
    // ------------------------------------
    private static void addProduct(ArrayList<Product> products) {

        String name = inputText("Product Name.:");
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

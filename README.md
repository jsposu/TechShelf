# TechShelf
System for a Technology Store Management (Sistema de Gestión de Tienda de Tecnología)

![UML Diagram image](/docs/uml/imageV5.png "UML Diagram")

The Technology Store Management System is a software solution designed to help the operations of a technology retail store. It integrates inventory control, sales processing, and customer sales management.
The system provides real-time tracking of product stock, automates the sales process with invoice generation, and maintains customer records for enhanced service.
Built with Java, the system ensures reliability and scalability for the store's growing needs.

## How to Compile and Run (Windows, Linux & MacOS)
### Windows
1. Open CMD or PowerShell.
2. Navigate to the project folder:
   cd "C:\path\to\TechShelf"
3. Check that Java JDK is installed:
   java -version
   javac -version
4. Compile all Java files:
   javac -d bin "src\utp\Ac\Pa\*.java"
5. Run the program:
   java -cp bin Main

### Linux & MacOS
1. Open a terminal.
2. Navigate to the project folder:
   cd ~/TechShelf
3. Check that Java JDK is installed:
   java -version
   javac -version
4. Compile the project:
   javac -d bin src/utp/Ac/Pa/*.java
5. Run the program:
   java -cp bin Main

### Notes
- The `-d bin` flag places compiled `.class` files inside the `bin` folder.
- Adjust the folder path depending on where TechShelf is saved.
- Replace `Main` with the actual main class name if different.
- `JOptionPane` works normally in any graphical environment.

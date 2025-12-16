import java.time.LocalDate;

public class Usuario {

    private String username;
    private String password;
    private LocalDate FNacimiento;
    private LocalDate FIngreso;
    private String nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String ApellidoCasada;
    private String UltPassword;
    private LocalDate FecModPass;
    private Roles roles;
    private boolean estado;

    /** 🔹 Constructor */
    public Usuario(String username, String password, Roles roles, LocalDate FNacimiento, LocalDate FIngreso,
                   String nombre, String ApellidoPaterno, String ApellidoMaterno,
                   /*String ApellidoCasada, String UltPassword, LocalDate FecModPass,*/ boolean estado) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.FNacimiento = FNacimiento;
        this.FIngreso = FIngreso;
        this.nombre = nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
       /*  this.ApellidoCasada = ApellidoCasada;
        this.UltPassword = UltPassword;
        this.FecModPass = FecModPass;   */
        this.estado = estado;
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    /*public boolean tienePermiso(Permiso permiso) {
        return roles.hasPermiso(permiso);
    }*/

    public String getRol() {
        return roles.getName();
    }
}

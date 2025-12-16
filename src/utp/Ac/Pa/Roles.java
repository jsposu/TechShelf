import java.util.Set;
import java.util.HashSet;


public class Roles {

    private int idRole;
    private String name;
    private String description;
    private Set<Permiso> permisos;

    public Roles(int idRole, String name, String description) {
        this.idRole = idRole;
        this.name = name;
        this.description = description;
        this.permisos = new HashSet<>();
    }

    public void addPermiso(Permiso permiso) {
        permisos.add(permiso);
    }

    public boolean hasPermiso(Permiso permiso) {
        return permisos.contains(permiso);
    }

    public String getName() {
        return name;
    }
}
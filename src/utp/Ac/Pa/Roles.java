import java.util.Set;
import java.util.HashSet;

public class Role {

    private int idRole;
    private String name;
    private Set<Permiso> permisos;

    public Role(int idRole, String name) {
        this.idRole = idRole;
        this.name = name;
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

public class Roles {

    private int id;
    private String name;
    private String description;
    private boolean estadoR;

    // 🔹 Constructor
    public Roles(int id, String name, boolean estadoR /*, String description */) {
        this.id = id;
        this.name = name;
        this.estadoR = estadoR;
        //his.description = description;
    }

    // 🔹 Getters y Setters (opcional pero recomendado)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /*  public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/
}


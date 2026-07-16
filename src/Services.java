public class Services {
    private int id;
    private String name;

    // Constructor for new Service
    public Services(String name) {
        this.name = name;
    }

    // Constructor for Database import
    public Services(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

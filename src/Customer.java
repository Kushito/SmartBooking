

public class Customer {

    private int id;
    private String name;
    private String email;

    // Constructor for taking from Database
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Constructor for creating new Customer
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}
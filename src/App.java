public class App {
    public static void main(String[] args) throws Exception {
        // Create a new customer
        Customer newCustomer = new Customer("John Doe", "john.doe@example.com");

        // Add the customer to the database
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.addCustomer(newCustomer);

        // Retrieve and display all customers from the database
        System.out.println("All Customers:");
        for (Customer customer : customerDAO.getAllCustomers()) {
            System.out.println(customer);
        }
    }
}

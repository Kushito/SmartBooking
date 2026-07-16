import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws Exception {
        //all create DAO objects
        CustomerDAO customerDAO = new CustomerDAO();
        ServicesDAO serviceDAO = new ServicesDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        //Date format for parsing date strings
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Create a new customer

        //Customer newCustomer = new Customer("John Doe", "john.doe@example.com");

        // Add the customer to the database

        //customerDAO.addCustomer(newCustomer);

        // Retrieve and display all customers from the database

        /*
        System.out.println("All Customers:");
        for (Customer customer : customerDAO.getAllCustomers()) {
            System.out.println(customer);
        }
        */

        // Create a new service

        /*
        Services newService = new Services("Coference Room 1");
        if (!serviceDAO.serviceExists(newService.getName())) {
            serviceDAO.addService(newService);
        }else {
            System.out.println("Service already exists: " + newService.getName());
        }
        */

        // Retrieve and display all services from the database

        
        System.out.println("All Services:");
        for (Services service : serviceDAO.getAllServices()) {
            System.out.println(service);
        }
        

        // New appointment

        /* 
        try{
        Date termin = dateFormat.parse("2024-06-15 10:00:00");

        Appointment newAppointment = new Appointment(1,"Coference Room 1", termin, "Scheduled");
        appointmentDAO.addAppointment(newAppointment);
        } catch (ParseException e) {
        e.printStackTrace();
        }
        */
    }
}

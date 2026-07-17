import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AppointmentDAO {
    
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/smart_booking";
    private static final String USER = "postgres";
    private static final String PASS = "admin";

    // Add a new appointment to the database
    public void addAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointments (customers_id, services_name, appointment_date, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointment.getCustomerId());
            pstmt.setString(2, appointment.getServiceName());
            pstmt.setTimestamp(3, new java.sql.Timestamp(appointment.getDate().getTime()));
            pstmt.setString(4, appointment.getStatus());
            pstmt.executeUpdate();
            System.out.println("Appointment added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding appointment: " + e.getMessage());
        }
    }

    //Check if an appointment already exists for a given service at a specific date and time
    public boolean appointmentExists(String serviceName, java.util.Date date) throws SQLException {
        String sql = "SELECT COUNT(*) FROM appointments WHERE services_name = ? AND appointment_date = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, serviceName);
            pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking appointment existence: " + e.getMessage());
        }
        return false;
    }

    // End of Appointment in database
    public void endAppointment(int appointmentId) throws SQLException {
        String sql = "UPDATE appointments SET status = 'Completed' WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Appointment ended successfully.");
            } else {
                System.out.println("No appointment found with the given ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error ending appointment: " + e.getMessage());
        }
    }


    // Retrieve all appointments from the database
    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int customerId = rs.getInt("customer_id");
                java.sql.Timestamp timestamp = rs.getTimestamp("date");
                java.util.Date date = new java.util.Date(timestamp.getTime());
                String serviceName = rs.getString("service_name");
                String status = rs.getString("status");
                appointments.add(new Appointment(id, customerId, date, serviceName, status));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving appointments: " + e.getMessage());
        }
        return appointments;
    }
}
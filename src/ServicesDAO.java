import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicesDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/smart_booking";
    private static final String USER = "postgres";
    private static final String PASS = "admin";

    // Add a new service to the database
    public void addService(Services service) throws SQLException {
        String sql = "INSERT INTO services (name) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, service.getName());
            pstmt.executeUpdate();
            System.out.println("Service added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding service: " + e.getMessage());
        }
    }

    // Retrieve all services from the database
    public List<Services> getAllServices() throws SQLException {
        List<Services> services = new ArrayList<>();
        String sql = "SELECT * FROM services";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                services.add(new Services(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving services: " + e.getMessage());
        }
        return services;
    }

    //Check if a service exists in the database
    public boolean serviceExists(String serviceName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM services WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, serviceName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking service existence: " + e.getMessage());
        }
        return false;
    }
}

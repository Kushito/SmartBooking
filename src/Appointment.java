import java.util.Date;

public class Appointment {
    private int id;
    private int customerId;
    private Date date;
    private String serviceName;
    private String status;

    //Constructor for Database inport
    public Appointment(int id, int customerId, Date date, String serviceName, String status) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.serviceName = serviceName;
        this.status = status;
    }

    //Constructor for new Appoiment
    public Appointment(int customerId, String serviceName, Date date, String status) {
        this.customerId = customerId;
        this.date = date;
        this.serviceName = serviceName;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {return id;}
    public int getCustomerId() {return customerId;}
    public Date getDate() {return date;}
    public String getServiceName() {return serviceName;}
    public String getStatus() {return status;}

    public void setId(int id) {this.id = id;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public void setDate(Date date) {this.date = date;}
    public void setServiceName(String serviceName) {this.serviceName = serviceName;}
    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "Appoiment{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", date=" + date +
                ", serviceName='" + serviceName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}

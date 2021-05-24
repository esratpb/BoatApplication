import java.util.Random;

public class Customer {
    Random random = new Random();
    private int customerId;
    private String name;
    private int phoneNumber;
    private String email;
    private String address;

    public Customer( String name, int phoneNumber, String email, String address) {
        this.customerId = random.nextInt(1000);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Customer(){

    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

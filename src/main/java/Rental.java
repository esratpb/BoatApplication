import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class Rental {
    private Random count = new Random();
    private int rentalId;
    private LocalDateTime date;
    private Boat boat;
    private Customer customer;
    private LocalTime startTime;
    private LocalTime endTime;
    private int rentDuration;
    private double totalPrice;
    private boolean paymentIsDone;
    private boolean isReturned;

    public Rental(LocalDateTime date, Boat boat, Customer customer, LocalTime startTime, LocalTime endTime, int rentDuration, double totalPrice, boolean paymentIsDone, boolean isReturned) {
        this.rentalId = count.nextInt(500);
        this.date = date;
        this.boat = boat;
        this.customer = customer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentDuration = rentDuration;
        this.totalPrice = totalPrice;
        this.paymentIsDone = paymentIsDone;
        this.isReturned = isReturned;
    }
    public Rental(LocalDateTime localDateTime, int i, Boat boat1, Customer customer1, LocalDateTime parse, LocalDateTime dateTime, boolean b, boolean b1){

    }

    public Rental(String setDate, Boat boat2, Customer customer1, int i, int i1, boolean b, boolean b1) {

    }

    public int getRentalId() {
        return rentalId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    //    public void setDate(LocalDateTime date) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        String strDate = dateFormat.format(date);
//        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");
//        this.date = LocalDateTime.parse(strDate, f);
//        this.date = date;
//    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaymentIsDone() {
        return paymentIsDone;
    }

    public void setPaymentIsDone(boolean paymentIsDone) {
        this.paymentIsDone = paymentIsDone;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", date=" + date +
                ", boat=" + boat +
                ", customer=" + customer +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", rentDuration=" + rentDuration +
                ", totalPrice=" + totalPrice +
                ", paymentIsDone=" + paymentIsDone +
                ", isReturned=" + isReturned +
                '}';
    }
}

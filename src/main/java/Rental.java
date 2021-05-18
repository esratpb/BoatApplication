import java.time.LocalDateTime;
import java.util.Date;

public class Rental {
    private Date date = new Date();
    private int rentalId;
    private Boat boat;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean paymentIsDone;
    private boolean isReturned;

    public Rental(Date date, int rentalId, Boat boat, Customer customer, LocalDateTime startTime, LocalDateTime endTime, boolean paymentIsDone, boolean isReturned) {
        this.date = date;
        this.rentalId = rentalId;
        this.boat = boat;
        this.customer = customer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentIsDone = paymentIsDone;
        this.isReturned = isReturned;
    }
}

import java.util.Random;

public class Boat {
    Random random = new Random();
    private int boatId;
    private String boatType;
    private int seats;
    private double minimumPrice; // hourly price in euros
    private int chargingTime;


    public Boat(String boatType, int seats, double minimumPrice) {
        this.boatId = random.nextInt(100);
        this.boatType = boatType;
        this.seats = seats;
        this.minimumPrice = minimumPrice;
    }



    public Boat(String boatType, int seats, double minimumPrice, int chargingTime) {
        this.boatId = random.nextInt(100);
        this.boatType = boatType;
        this.seats = seats;
        this.minimumPrice = minimumPrice;
        this.chargingTime = chargingTime;
    }

    public Boat() {

    }


    public int getBoatId() {
        return boatId;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "boatId=" + boatId +
                ", boatType='" + boatType + '\'' +
                ", seats=" + seats +
                ", minimumPrice=" + minimumPrice +
                ", chargingTime=" + chargingTime +
                '}';
    }
}

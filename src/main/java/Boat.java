public class Boat {

    private String boatId;
    private String boatType;
    private int seats;
    private double price; // hourly price in euros

    public Boat(String boatId, String boatType, int seats, double price) {
        this.boatId = boatId;
        this.boatType = boatType;
        this.seats = seats;
        this.price = price;
    }

    public Boat() {

    }

    public String getBoatId() {
        return boatId;
    }

    public void setBoatId(String boatId) {
        this.boatId = boatId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "boatId='" + boatId + '\'' +
                ", boatType='" + boatType + '\'' +
                ", seats=" + seats +
                ", price=" + price +
                '}';
    }
}

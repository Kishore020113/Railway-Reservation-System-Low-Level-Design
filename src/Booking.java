public class Booking {
    private static int id = 1;
    private int bookingId;
    private Train train;
    private Passenger passenger;
    private Seat seat;
    private Status status;
    private String source;
    private String destination;
    public SeatType seatType;

    public Booking(Train train, Passenger passenger, Seat seat, SeatType seatType,Status status, String source, String destination){
        this.train = train;
        this.passenger = passenger;
        this.seat = seat;
        this.status = status;
        this.source = source;
        this.destination = destination;
        this.bookingId = id;
        this.seatType = seatType;
        id++;
    }

    public static int getId() {
        return id;
    }
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public SeatType getSeatType(){
        return seatType;
    }
    public void setSeatType(SeatType seatType){
        this.seatType = seatType;
    }
}

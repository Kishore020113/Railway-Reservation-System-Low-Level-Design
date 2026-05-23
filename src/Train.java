import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Train {
    private int trainId;
    private String trainName;
    private String source;
    private String destination;
    private int capacity;
    private List<Seat> sets;
    private Queue<Booking> racQueue;
    private Queue<Booking> waitlistQueue;
    private List<Booking> bookings;
    private int racCapacity;
    private int waitlistCapacity;

    public Train(int trainId,String trainName,String source,String destination,int racCapacity, int waitlistCapacity){
        this.trainId = trainId;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.capacity = 8;
        this.sets = new ArrayList<>();
        this.racQueue = new LinkedList<>();
        this.waitlistQueue = new LinkedList<>();
        this.bookings = new ArrayList<>();
        this.racCapacity = racCapacity;
        this.waitlistCapacity = waitlistCapacity;
    }
    public void addSeat(Seat seat){
        sets.add(seat);
    }
    public int getRacCapacity(){
        return racCapacity;
    }

    public int getWaitlistCapacity(){
        return waitlistCapacity;
    }
    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public void addRacQueue(Booking booking){
        racQueue.add(booking);
    }
    public void addWlQueue(Booking booking){
        waitlistQueue.add(booking);
    }
    public int getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }


    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Seat> getSets() {
        return sets;
    }

    public Queue<Booking> getRacQueue() {
        return racQueue;
    }

    public Queue<Booking> getWaitlistQueue() {
        return waitlistQueue;
    }

    public List<Booking> getBookings(){
        return bookings;
    }
}

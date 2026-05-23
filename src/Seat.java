public class Seat {
    private int setNo;
    private SeatType setType;
    private boolean isBooked;
    private Passenger bookedBy;

    public Seat(int setNo, SeatType setType){
        this.setNo = setNo;
        this.setType = setType;
        this.isBooked = false;
        this.bookedBy = null;
    }

    public int getSetNo() {
        return setNo;
    }

    public SeatType getSetType() {
        return setType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public Passenger getBookedBy() {
        return bookedBy;
    }

    public void setSetType(SeatType setType) {
        this.setType = setType;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void setBookedBy(Passenger bookedBy) {
        this.bookedBy = bookedBy;
    }
}

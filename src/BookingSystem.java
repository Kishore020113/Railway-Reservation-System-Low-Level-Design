import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    List<Train> trains;
    public BookingSystem(){
        this.trains = new ArrayList<>();

    }
    public void addTrain(Train train){
        trains.add(train);
    }

    public void bookTicket(Passenger passenger,Train train, SeatType seatType){
           Seat seat = AvailableSeats(train,seatType);
           if(seat != null){
               seat.setBooked(true);
               seat.setBookedBy(passenger);
               Booking booking = new Booking(train,passenger,seat,seatType,Status.CONFIRMED, passenger.getSource(), passenger.getDestination());
               train.addBooking(booking);
               System.out.println("TICKET CONFIMED! SEAT NO: "+ seat.getSetNo());
           }
           else if(train.getRacQueue().size() < train.getRacCapacity()){
               Booking booking = new Booking(train,passenger,seat,seatType,Status.RAC, passenger.getSource(), passenger.getDestination());
               train.addRacQueue(booking);
               System.out.println("Added to RAC POSITION : "+ train.getRacQueue().size());
           }
           else if(train.getWaitlistQueue().size() < train.getWaitlistCapacity()){
               Booking booking = new Booking(train,passenger,seat,seatType,Status.WL, passenger.getSource(), passenger.getDestination());
               train.addWlQueue(booking);
               System.out.println("Added to WL POSITION : "+ train.getWaitlistQueue().size());
           }
           else{
               System.out.println("Train is currently full");
           }
    }

    public void cancelTicket(int id,Train train){
        boolean found = false;
        List<Booking> book = new ArrayList<>();
        for(Booking booking : train.getBookings()){
            if(booking.getBookingId() == id){
                found = true;
                booking.setStatus(Status.CANCELLED);
                booking.getSeat().setBooked(false);
                SeatType seatType = booking.getSeatType();
                Seat s = AvailableSeats(train,seatType);
                if(s != null){
                    Booking b1 = train.getRacQueue().poll();
                    if(b1 != null){
                        b1.setStatus(Status.CONFIRMED);
                        b1.setSeat(s);
                        s.setBooked(true);
                        s.setBookedBy(b1.getPassenger());
                        book.add(b1);
                        System.out.println("TICKET CONFIMED! SEAT NO: "+ s.getSetNo());
                    }
                    Booking b2 = train.getWaitlistQueue().poll();
                    if(b2 != null){
                        b2.setStatus(Status.RAC);
                        train.addRacQueue(b2);
                    }
                }
            }
        }
        train.getBookings().addAll(book);
        if(!found){
            System.out.println("Invalid booking ID!");
        }
    }
    public void getBookedTickets(){
        for(Train train : trains) {
            System.out.println("Booking for the Train No: " + train.getTrainId());
            System.out.println("BookingId\t" + "PassengerId\t\t" + "PassengerName\t" + "SeatNo\t" + "BookingStatus\t" + "Source\t" + "Destination\t");
            for(Booking b : train.getBookings()){
                System.out.println(b.getBookingId() + "\t\t\t\t" + b.getPassenger().getPassengerId() + "\t\t\t\t" + b.getPassenger().getPassengerName() + "\t\t\t" + b.getSeat().getSetNo() +
                        "\t\t" + b.getStatus() +"\t\t" + b.getSource() +"\t\t" + b.getDestination());
            }
            for(Booking b : train.getRacQueue()){
                System.out.println(b.getBookingId() + "\t\t\t\t" + b.getPassenger().getPassengerId() + "\t\t\t\t" + b.getPassenger().getPassengerName() + "\t\t\t" + "RAC\t\t" +
                        "\t\t" + b.getStatus() +"\t\t" + b.getSource() +"\t\t" + b.getDestination());
            }
            for(Booking b : train.getWaitlistQueue()){
                System.out.println(b.getBookingId() + "\t\t\t\t" + b.getPassenger().getPassengerId() + "\t\t\t\t" + b.getPassenger().getPassengerName() + "\t\t\t" + "WL\t\t" +
                        "\t\t" + b.getStatus() +"\t\t" + b.getSource() +"\t\t" + b.getDestination());
            }
            System.out.println();
            System.out.println();
        }
    }
    public void getBookingsByTrain(Train train){
        System.out.println("Booking for the Train No: " + train.getTrainId());
        System.out.println("BookingId\t" + "PassengerId\t" + "PassengerName\t" + "SeatNo\t" + "BookingStatus\t" + "Source\t" + "Destination\t");
        for(Booking b : train.getBookings()){
            System.out.println(b.getBookingId() + "\t\t" + b.getPassenger().getPassengerId() + "\t\t" + b.getPassenger().getPassengerName() + "\t\t" + b.getSeat().getSetNo() +
                    "\t\t" + b.getStatus() +"\t\t" + b.getSource() +"\t\t" + b.getDestination());
        }
        for(Booking b : train.getRacQueue()){
            System.out.println(b.getBookingId() + "\t\t" + b.getPassenger().getPassengerId() + "\t\t" + b.getPassenger().getPassengerName() + "\t\t" + "RAC\t\t\t" +
                    "\t\t" + b.getStatus() +"\t\t\t\t" + b.getSource() +"\t\t" + b.getDestination());
        }
        for(Booking b : train.getWaitlistQueue()){
            System.out.println(b.getBookingId() + "\t\t" + b.getPassenger().getPassengerId() + "\t\t" + b.getPassenger().getPassengerName() + "\t\t" + "WL\t\t\t" +
                    "\t\t" + b.getStatus() +"\t\t\t\t" + b.getSource() +"\t\t" + b.getDestination());
        }
    }
    public void getAvailableSeats(Train train, SeatType seatType){
        int count = 0;
        for(Seat seat : train.getSets()){
            if(!seat.isBooked() && seat.getSetType() == seatType){
               count++;
            }
        }
        System.out.println("Available Type :" + seatType + "seats : " + count) ;
    }
    public Seat AvailableSeats(Train train, SeatType seat){
        for(Seat s : train.getSets()){
            if(!s.isBooked() && s.getSetType() == seat){
                return s;
            }
        }
        return null;
    }
}


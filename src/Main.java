public class Main {
    public static void main(String[] args) {

        // 1. Create BookingSystem
        BookingSystem bookingSystem = new BookingSystem();

        Train train1 = new Train(1, "Chennai Express", "A", "E", 2, 2);
        train1.addSeat(new Seat(1, SeatType.AC));
        train1.addSeat(new Seat(2, SeatType.AC));
        train1.addSeat(new Seat(3, SeatType.SL));
        train1.addSeat(new Seat(4, SeatType.SL));

        // 3. Add train to system
        bookingSystem.addTrain(train1);

        // 4. Create passengers
        Passenger p1 = new Passenger("Kishore", "kishore@gmail.com", 21, "A", "E");
        Passenger p2 = new Passenger("Rahul", "rahul@gmail.com", 30, "A", "C");
        Passenger p3 = new Passenger("Priya", "priya@gmail.com", 19, "B", "E");
        Passenger p4 = new Passenger("Vikram", "vikram@gmail.com", 15, "B", "D");
        Passenger p5 = new Passenger("Anbu", "anbu@gmail.com", 45, "C", "E");
        Passenger p6 = new Passenger("Karthik", "karthik@gmail.com", 52, "A", "E");
//
        // 5. Book tickets - test all cases!
        System.out.println("=== BOOKING TICKETS ===");
        bookingSystem.bookTicket(p1, train1, SeatType.AC); // CONFIRMED
        bookingSystem.bookTicket(p2, train1, SeatType.AC); // CONFIRMED
        bookingSystem.bookTicket(p3, train1, SeatType.AC); // RAC
        bookingSystem.bookTicket(p4, train1, SeatType.AC); // RAC
        bookingSystem.bookTicket(p5, train1, SeatType.AC); // WL

        System.out.println("\n=== ALL BOOKINGS ===");
        bookingSystem.getBookedTickets();

//        System.out.println("=== AVAILABLE SEATS ===");
//        bookingSystem.getAvailableSeats(train1, SeatType.AC);
//        bookingSystem.getAvailableSeats(train1, SeatType.SL);
//
//        System.out.println("\n=== CANCELLING TICKET 1 ===");
//        bookingSystem.cancelTicket(1, train1);
//
//        System.out.println("\n=== BOOKINGS AFTER CANCELLATION ===");
//        bookingSystem.getBookedTickets();
    }
}
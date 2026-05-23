# Railway Reservation System 🚂

A console-based Railway Reservation System built using Core Java and OOP principles.

## Classes
- **BookingSystem** → manages all bookings and allocation
- **Train** → tracks seats, RAC and waitlist queues
- **Passenger** → stores passenger details
- **Seat** → tracks seat type and availability
- **Booking**git → holds individual booking details

## Features
- Book tickets (Confirmed, RAC, Waitlist)
- Cancel tickets with automatic promotion
- Check available seats by type
- View all bookings per train

## Booking Logic
- Seat available → CONFIRMED
- Seats full → RAC queue
- RAC full → Waitlist queue
- Cancel → RAC promoted to CONFIRMED, WL promoted to RAC

## How to Run
```bash
javac *.java
java Main
```

## Tech
Java | OOP | Collections | Queue | Enum
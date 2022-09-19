package org.example;

public interface CabBookingService {
    Booking bookRide(String pickupLocation) throws BookingException;
}

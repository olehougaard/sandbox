package org.example;

import java.util.ArrayList;

public class CabBookingServiceImpl implements CabBookingService {
    private final ArrayList<Booking> bookings = new ArrayList<>();

    @Override
    public Booking bookRide(String pickupLocation) {
        bookings.add(new Booking(pickupLocation));
        return bookings.get(bookings.size() - 1);
    }
}

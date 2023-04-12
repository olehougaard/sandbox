package org.example;

import java.io.Serializable;

public class Booking implements Serializable {
    private final String bookingLocation;

    public Booking(String bookingLocation) {
        this.bookingLocation = bookingLocation;
    }

    public String getBookingLocation() {
        return bookingLocation;
    }

    @Override
    public String toString() {
        return bookingLocation;
    }
}

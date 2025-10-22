package za.ac.cput.factory.booking;

import za.ac.cput.domain.booking.Booking;
import za.ac.cput.domain.booking.CleaningService;
import za.ac.cput.domain.booking.Vehicle;
import za.ac.cput.domain.user.employee.WashAttendant;

import java.time.LocalDateTime;
import java.util.List;

public class BookingFactory {

    public static Booking createBooking(
            List<CleaningService> cleaningServices,
            Vehicle vehicle,
            WashAttendant washAttendant,
            LocalDateTime bookingDateTime,
            boolean tipAdd,
            double bookingCost) {

        // Basic validation
        if (cleaningServices == null || cleaningServices.isEmpty())
            throw new IllegalArgumentException("At least one cleaning service is required");

        if (vehicle == null)
            throw new IllegalArgumentException("Vehicle is required");

        if (washAttendant == null)
            throw new IllegalArgumentException("Wash attendant is required");

        if (bookingDateTime == null)
            bookingDateTime = LocalDateTime.now();

        if (bookingCost < 0)
            throw new IllegalArgumentException("Booking cost must be positive");

        return new Booking.Builder()
                .setCleaningServices(cleaningServices)
                .setWashAttendant(washAttendant)
                .setBookingDateTime(bookingDateTime)
                .setVehicle(vehicle)
                .setTipAdd(tipAdd)
                .setBookingCost(bookingCost)
                .setCancelled(false) // ✅ Default new field
                .build();
    }
}
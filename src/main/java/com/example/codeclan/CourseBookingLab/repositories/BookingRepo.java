package com.example.codeclan.CourseBookingLab.repositories;

import com.example.codeclan.CourseBookingLab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

    //get all bookings for a given date
    List<Booking> findBookingByDateIgnoreCase(String date);
}

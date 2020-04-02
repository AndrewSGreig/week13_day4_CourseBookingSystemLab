package com.example.codeclan.CourseBookingLab.controllers;

import com.example.codeclan.CourseBookingLab.models.Booking;
import com.example.codeclan.CourseBookingLab.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingRepo bookingRepo;


    @GetMapping(value="bookings")
    public ResponseEntity getAllBookingsByDate(
            @RequestParam(name="date", required = false)String date
    ){
        if(date!=null){
            return new ResponseEntity(bookingRepo.findBookingByDateIgnoreCase(date), HttpStatus.OK);
        }
        return new ResponseEntity(bookingRepo.findAll(), HttpStatus.OK);
    }

}

package com.example.codeclan.CourseBookingLab.controllers;

import com.example.codeclan.CourseBookingLab.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepo courseRepo;

    //if the course rating is provided in the url display relevant course
    // get all courses for a given customer
    //


    @GetMapping(value="courses")
    public ResponseEntity getAllCourses(
            @RequestParam(required = false, name="rating")Integer rating,
            @RequestParam(required = false, name="customerName")String customerName
    ){
        if (rating != null){
            return new ResponseEntity(courseRepo.findCourseByRating(rating), HttpStatus.OK);
        }
        if (customerName != null){
            return new ResponseEntity(courseRepo.findCourseByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepo.findAll(), HttpStatus.OK);
    }


}

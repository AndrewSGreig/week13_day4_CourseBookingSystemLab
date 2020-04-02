package com.example.codeclan.CourseBookingLab.controllers;

import com.example.codeclan.CourseBookingLab.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;
    @GetMapping(value="customers")
    public ResponseEntity getAllCustomers(
            @RequestParam(required = false, name="courseName")String courseName
    ){
        if (courseName != null){
            return new ResponseEntity(customerRepo.findCustomerByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepo.findAll(), HttpStatus.OK);
    }

}

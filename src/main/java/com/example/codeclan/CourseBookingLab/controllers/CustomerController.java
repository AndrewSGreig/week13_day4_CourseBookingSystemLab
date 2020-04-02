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
            @RequestParam(required = false, name="courseName")String courseName,
            @RequestParam(required = false, name="town")String town,
            @RequestParam(required = false, name="ageGreaterThan")Integer ageGreaterThan
    ){
        if(ageGreaterThan!=null && courseName!=null && town!=null){
            //http://localhost:8080/customers?town=Largs&courseName=Data%20Analysis&ageGreaterThan=40
            return new ResponseEntity(customerRepo.findCustomerByTownAndBookingsCourseNameAndAgeGreaterThan(town, courseName, ageGreaterThan), HttpStatus.OK);
        }
        if(courseName!=null && town!=null){
            //http://localhost:8080/customers?town=Largs&courseName=Data%20Analysis
            return new ResponseEntity(customerRepo.findCustomerByTownAndBookingsCourseName(town, courseName), HttpStatus.OK);
        }
        if (courseName != null){
            http://localhost:8080/customers?courseName=Data%20Analysis
            return new ResponseEntity(customerRepo.findCustomerByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepo.findAll(), HttpStatus.OK);
    }

}

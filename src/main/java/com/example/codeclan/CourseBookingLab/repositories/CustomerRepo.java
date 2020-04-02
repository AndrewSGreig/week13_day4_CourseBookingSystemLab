package com.example.codeclan.CourseBookingLab.repositories;

import com.example.codeclan.CourseBookingLab.models.Course;
import com.example.codeclan.CourseBookingLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    //what get all customers for a given course
    List<Customer> findCustomerByBookingsCourseName(String name);

    //get all customers from a given town on a particular course
    List <Customer> findCustomerByTownAndBookingsCourseName(String town, String name);

    //Get all customers over a certain age in a given town for a given course
    List <Customer> findCustomerByTownAndBookingsCourseNameAndAgeGreaterThan(String town, String name, int age);


}

package com.example.codeclan.CourseBookingLab.repositories;

import com.example.codeclan.CourseBookingLab.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    //TODO write a query to find all pirates over a certain age
    // What do I have?: the age
    //what do i want :List<Pirate>

    //operation<object>By<property<[modifier]<operator>
    //modifier:
    // GreaterThan
    //Less than
    //less than or =

    List<Course> findCourseByRating(int rating);

    List<Course> findCourseByBookingsCustomerNameIgnoreCase(String name);
}

package com.example.codeclan.CourseBookingLab;

import com.example.codeclan.CourseBookingLab.repositories.BookingRepo;
import com.example.codeclan.CourseBookingLab.repositories.CourseRepo;
import com.example.codeclan.CourseBookingLab.repositories.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingLabApplicationTests {
	@Autowired
	CourseRepo courseRepo;

	@Autowired
	BookingRepo bookingRepo;

	@Autowired
	CustomerRepo customerRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourses(){
		assertEquals(4, courseRepo.findAll().size());
	}

	@Test
	public void canFindCourseByRating(){
		assertEquals(2, courseRepo.findCourseByRating(5).size());
	}

	@Test
	public void canFindCourseByCustomerName(){
		assertEquals(1, courseRepo.findCourseByBookingsCustomerNameIgnoreCase("Jan").size());
	}

	@Test
	public void canGetCustomersByCourseName(){
		assertEquals(1, customerRepo.findCustomerByTownAndBookingsCourseNameIgnoreCase("Largs","Data Analysis").size());
	}

	@Test
	public void canGetCustomersOverAgeInSpecifiedTownForCourse(){
		assertEquals(1, customerRepo.findCustomerByTownAndBookingsCourseNameAndAgeGreaterThanIgnoreCase("Largs", "Data Analysis", 34).size());
		assertEquals(0, customerRepo.findCustomerByTownAndBookingsCourseNameAndAgeGreaterThanIgnoreCase("Largs", "Data Analysis", 36).size());
	}

}

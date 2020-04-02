package com.example.codeclan.CourseBookingLab.components;
import com.example.codeclan.CourseBookingLab.models.Booking;
import com.example.codeclan.CourseBookingLab.models.Course;
import com.example.codeclan.CourseBookingLab.models.Customer;
import com.example.codeclan.CourseBookingLab.repositories.BookingRepo;
import com.example.codeclan.CourseBookingLab.repositories.CourseRepo;
import com.example.codeclan.CourseBookingLab.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    CustomerRepo customerRepo;
    public DataLoader() {
    }
    public void run(ApplicationArguments args) {
        customerRepo.deleteAll();
        courseRepo.deleteAll();
        bookingRepo.deleteAll();
        //Customers
        Customer jan = new Customer("Jan", "Glasgow", 27);
        Customer john = new Customer("John", "Glasgow", 25);
        Customer lucy = new Customer("Lucy", "Largs", 35);
        Customer jake = new Customer("Jake", "Aberdeen", 50);
        Customer peter = new Customer("Peter", "London", 27);
        Customer jim = new Customer("Jim", "Edinburgh", 33);
        Customer elliot = new Customer("Elliot", "Edinburgh", 49);
        Customer derek = new Customer("Derek", "Aberdeen", 41);
        customerRepo.save(jan);
        customerRepo.save(john);
        customerRepo.save(lucy);
        customerRepo.save(jake);
        customerRepo.save(peter);
        customerRepo.save(jim);
        customerRepo.save(elliot);
        customerRepo.save(derek);
        //Courses
        Course professionalSoftwareDevelopmentG = new Course("Professional Software Development", "Glasgow", 5);
        Course professionalSoftwareDevelopmentE = new Course("Professional Software Development", "Edinburgh", 5);
        Course dataAnalysis = new Course("Data Analysis", "Glasgow", 4);
        Course fullStackWebDevelopment = new Course("Full-stack Web Development", "Inverness", 3);
        courseRepo.save(professionalSoftwareDevelopmentG);
        courseRepo.save(professionalSoftwareDevelopmentE);
        courseRepo.save(dataAnalysis);
        courseRepo.save(fullStackWebDevelopment);
        //Bookings
        Booking booking1 = new Booking("01-March-2020", professionalSoftwareDevelopmentG, jan);
        Booking booking2 = new Booking("01-March-2020", professionalSoftwareDevelopmentG, jake);
        Booking booking3 = new Booking("02-March-2020", dataAnalysis, lucy);
        Booking booking4 = new Booking("03-March-2020", dataAnalysis, jake);
        Booking booking5 = new Booking("05-March-2020", fullStackWebDevelopment, john);
        Booking booking6 = new Booking("07-March-2020", fullStackWebDevelopment, jake);
        Booking booking7 = new Booking("07-March-2020", professionalSoftwareDevelopmentE, jim);
        Booking booking8 = new Booking("07-March-2020", professionalSoftwareDevelopmentE, elliot);
        Booking booking9 = new Booking("09-March-2020", fullStackWebDevelopment, peter);
        Booking booking10 = new Booking("09-March-2020", dataAnalysis, peter);
        Booking booking11 = new Booking("15-March-2020", fullStackWebDevelopment, derek);
        Booking booking12 = new Booking("22-March-2020", fullStackWebDevelopment, elliot);
        bookingRepo.save(booking1);
        bookingRepo.save(booking2);
        bookingRepo.save(booking3);
        bookingRepo.save(booking4);
        bookingRepo.save(booking5);
        bookingRepo.save(booking6);
        bookingRepo.save(booking7);
        bookingRepo.save(booking8);
        bookingRepo.save(booking9);
        bookingRepo.save(booking10);
        bookingRepo.save(booking11);
        bookingRepo.save(booking12);
        //Adding bookings to customers
        jan.addBookingToBookings(booking1);
        jake.addBookingToBookings(booking2);
        jake.addBookingToBookings(booking4);
        jake.addBookingToBookings(booking6);
        lucy.addBookingToBookings(booking3);
        john.addBookingToBookings(booking5);
        jim.addBookingToBookings(booking7);
        elliot.addBookingToBookings(booking8);
        elliot.addBookingToBookings(booking12);
        peter.addBookingToBookings(booking9);
        peter.addBookingToBookings(booking10);
        derek.addBookingToBookings(booking11);
        customerRepo.save(jan);
        customerRepo.save(john);
        customerRepo.save(lucy);
        customerRepo.save(jake);
        customerRepo.save(peter);
        customerRepo.save(jim);
        customerRepo.save(elliot);
        customerRepo.save(derek);
        //Adding bookings to courses
        professionalSoftwareDevelopmentE.addBookingToBookings(booking7);
        professionalSoftwareDevelopmentE.addBookingToBookings(booking8);
        dataAnalysis.addBookingToBookings(booking3);
        dataAnalysis.addBookingToBookings(booking4);
        dataAnalysis.addBookingToBookings(booking10);
        professionalSoftwareDevelopmentG.addBookingToBookings(booking1);
        professionalSoftwareDevelopmentG.addBookingToBookings(booking2);
        fullStackWebDevelopment.addBookingToBookings(booking5);
        fullStackWebDevelopment.addBookingToBookings(booking6);
        fullStackWebDevelopment.addBookingToBookings(booking9);
        fullStackWebDevelopment.addBookingToBookings(booking11);
        fullStackWebDevelopment.addBookingToBookings(booking12);
        courseRepo.save(professionalSoftwareDevelopmentG);
        courseRepo.save(professionalSoftwareDevelopmentE);
        courseRepo.save(dataAnalysis);
        courseRepo.save(fullStackWebDevelopment);
    }
}
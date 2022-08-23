package com.example.demo.booking;


import com.example.demo.Exceptions.EmptyListCheckException;
import com.example.demo.Exceptions.InvalidAgeException;
import com.example.demo.treck.Treks;
import com.example.demo.treck.TreksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private BookingRepository repository;
    private TreksService treksService;


    public BookingService(@Autowired BookingRepository bookingRepository, @Autowired TreksService treksService) {
        this.repository = bookingRepository;
        this.treksService = treksService;

    }

    public List<Booking> ViewBooking() {
        return repository.findAll();
    }



    public String enterBooking(Booking booking ) throws EmptyListCheckException, InvalidAgeException {
            String trekId = booking.getTrekId();
            List<Treks> listByTrekId = treksService.getTrailByTrekId(trekId);
            if (listByTrekId.isEmpty()) {
//                return "No Booking Found";
                throw new EmptyListCheckException("No Booking Found");
            }
//            throw new EmptyListCheckException("No Booking Found");
            Treks object = listByTrekId.get(0);
            if (booking.getPersonAge() >= object.getMaximumAge() ||
                    booking.getPersonAge() <= object.getMinimumAge()) {
//                return "Invalid Age";
                throw new InvalidAgeException("Invalid Age");
            }
            repository.save(booking);
            return "Booking Added";
    }


    public void deleteBooking( String bookingId){
         System.out.println("book deleted 1");
         repository.deleteById(bookingId);
         System.out.println("book deleted");
//        return " Deleted booking with id: " + booking.getId();

//        public void deleteBooking( String bookingId){
//            System.out.println("book deleted 1");
//            repository.delete(bookingId);
//            System.out.println("book deleted");
//            return " Deleted booking with id: " + booking.getId();
    }


    public List<Booking> getBookingsByPersonId (String personId) {
        return repository.findByPersonId(personId);
    }


    public List<Booking> getBookingsByTrekId(String trekId) {
        return repository.findByTrekId(trekId);
    }



    public List<Booking> getBookingsByTrekName(String trekName){
        return repository.findByTrekName(trekName);
    }

}

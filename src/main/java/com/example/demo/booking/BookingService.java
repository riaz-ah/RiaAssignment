package com.example.demo.booking;


import com.example.demo.treckk.Trecks;
import com.example.demo.treckk.TrecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private BookingRepository repository;
    private TrecksService trecksService;


    public BookingService(@Autowired BookingRepository bookingRepository, @Autowired TrecksService trecksService) {
        this.repository = bookingRepository;
        this.trecksService =trecksService;

    }

    public List<Booking> ViewBooking() {
        return repository.findAll();
    }



    public String enterBooking(Booking booking ) {
        String treckId = booking.getTreckId();
        List<Trecks> listByTreckId = trecksService.getTrailByTreckId(treckId);
        Trecks object = listByTreckId.get(0);
        if (listByTreckId.isEmpty()){
            return "No Booking Found";
        }
        if ( booking.getPersonAge() >= object.getMaximumAge()
                && booking.getPersonAge() <= object.getMinimumAge()){
            return "No Booking Found";
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


    public List<Booking> getBookingsByTreckId(String treckId) {
        return repository.findByTreckId(treckId);
    }



    public List<Booking> getBookingsByTreckName(String treckName){
        return repository.findByTreckName(treckName);
    }

}

package com.example.demo.booking;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByPersonId(String personId);
    List<Booking> findByTrekId(String trekId);
    List<Booking> findByTrekName(String trekName);
    void deleteById(String bookingId);


//    object
}

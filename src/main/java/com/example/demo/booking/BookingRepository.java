package com.example.demo.booking;


import com.example.demo.treckk.Trecks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByPersonId(String personId);
    List<Booking> findByTreckId(String treckId);
    List<Booking> findByTreckName(String treckName);
    void deleteById(String bookingId);


//    object
}

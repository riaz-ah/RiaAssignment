package com.example.demo.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/viewAllBookings")
    public ResponseEntity<?> viewBooking() {
        return ResponseEntity.status(200)
                .header("message", "all trails found")
                .body(bookingService.ViewBooking());
    }

    @PostMapping("/enterBooking")
    public ResponseEntity <?> enterBooking(@RequestBody Booking booking) throws InvalidAgeException, EmptyListCheckException {
        String bookingResult = bookingService.enterBooking(booking);
        return ResponseEntity.status(200)
                .header("message", "record saved")
                .body(bookingResult + booking.getBookingId());
    }

    @DeleteMapping("/deleteBookingById/{bookingId}")
    public void deleteBooking(@PathVariable String bookingId){
//        bookingService.deleteBooking(booking.getBookingId());
        bookingService.deleteBooking(bookingId);

    }

//    @DeleteMapping("/deleteBooking/{ticketId}")
//    public ResponseEntity<?> deleteBooking(@RequestBody Booking booking){
//        bookingService.deleteBooking(booking.getBookingId());
//        return ResponseEntity.status(200)
//                .header("message", "booking deleted")
//                . body("booking deleted with id:" + booking.getId());

    @GetMapping("/getBookingByPersonId/{personId}")
    public ResponseEntity<?> getAllBooking(@PathVariable String personId){
        return ResponseEntity.status(200)
                .header("message", "trail found using personId")
                .body(bookingService.getBookingsByPersonId(personId));

    }

    @GetMapping("/getBookingByTreckId")
    public ResponseEntity<?> getBookings(@RequestParam String treckId){
        return ResponseEntity.status(200)
                .header("message", "Booking found using treckId")
                .body(bookingService.getBookingsByTreckId(treckId));
    }

    @GetMapping("/getBookingByTreckName/{treckName}")
    public ResponseEntity<?> getBookingsByTreckName(@PathVariable String treckName){
        return ResponseEntity.status(200)
                .header("message", "Booking found using treckName")
                .body(bookingService.getBookingsByTreckName(treckName));
    }



}

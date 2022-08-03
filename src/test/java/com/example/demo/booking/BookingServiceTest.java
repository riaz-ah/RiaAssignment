package com.example.demo.booking;

import com.example.demo.treckk.Trecks;
import com.example.demo.treckk.TrecksRepository;
import com.example.demo.treckk.TrecksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private TrecksService trecksService;


    @BeforeEach
    void init(){
        bookingService = new BookingService(bookingRepository,trecksService);
    }

    @Test
    void testViewAllBooking(){
        Booking P1B1 = new Booking();

        P1B1.setBookingId("P1B1");
        P1B1.setPersonId("Person1");
        P1B1.setTreckName("Blue Falls");
        P1B1.setTreckId("Treck1");
        P1B1.setPersonAge(50);

        Booking P1B2 = new Booking();

        P1B2.setBookingId("P1B2");
        P1B2.setPersonId("Person1");
        P1B2.setTreckName("Green Valley");
        P1B2.setTreckId("Treck2");
        P1B2.setPersonAge(50);

        Booking P1B3 = new Booking();

        P1B2.setBookingId("P1B3");
        P1B2.setPersonId("Person1");
        P1B2.setTreckName("Brown Mountains");
        P1B2.setTreckId("Treck3");
        P1B2.setPersonAge(50);

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(P1B1);
        bookingList.add(P1B2);
        bookingList.add(P1B3);
        Mockito.when(bookingRepository.findAll()).thenReturn(bookingList);
        List<Booking> response = bookingService.ViewBooking();
        assertThat(response).isEqualTo(bookingList);
        assertThat(response.size()).isEqualTo(bookingList.size());
//       ViewBooking
    }
    @Test
    void enterBooking(){
        Booking PIB1 = new Booking();

        PIB1.setBookingId("P1B1");
        PIB1.setPersonId("Person1");
        PIB1.setTreckName("Blue Falls");
        PIB1.setTreckId("Treck1");
        PIB1.setPersonAge(60);

        Mockito.when(bookingRepository.save(PIB1)).thenReturn(PIB1);
        Booking response = bookingService.enterBooking(PIB1);
        assertThat(response).isEqualTo(PIB1);


//        Mockito.when(bookingRepository.save(PIB1)).thenReturn(PIB1);
//        Booking response = bookingService.enterBooking();
//        assertThat(bookingService.enterBooking(PIB1)).isEqualTo(PIB1);

    }

//    @Test
//    void deleteBooking(){
//        Booking PIB1 = new Booking();
//
//        PIB1.setBookingId("P1B1");
//        PIB1.setPersonId("Person1");
//        PIB1.setTreckName("Blue Falls");
//        PIB1.setTreckId("Treck1");
//        PIB1.setPersonAge(60);
//        bookingService.deleteBooking("P1B1");
//        Mockito.verify(bookingRepository,Mockito.atLeastOnce()).delete("P1B1");
////r
//    }
    @Test
    void getByPersonId(){
        Booking PIB1 = new Booking();

        PIB1.setBookingId("P1B1");
        PIB1.setPersonId("Person1");
        PIB1.setTreckName("Blue Falls");
        PIB1.setTreckId("Treck1");
        PIB1.setPersonAge(60);

        List<Booking> bookingList3 = new ArrayList<>();
        bookingList3.add(PIB1);
        Mockito.when(bookingRepository.findByPersonId("Person1")).thenReturn(bookingList3);
        List<Booking> response = bookingService.getBookingsByPersonId("Person1");
        assertThat(response.size()).isEqualTo(bookingList3.size());
        assertThat(response).isEqualTo(bookingList3);
    }
//
    @Test
    void getByTreckId(){
        Booking b = new Booking();

        b.setBookingId("P1B1");
        b.setPersonId("Person1");
        b.setTreckName("Blue Falls");
        b.setTreckId("Treck1");
        b.setPersonAge(60);

        List<Booking> bookingList2 = new ArrayList<>();
        bookingList2.add(b);
        Mockito.when(bookingRepository.findByTreckId("b")).thenReturn(bookingList2);
        List<Booking> response = bookingService.getBookingsByTreckId("b");
        assertThat(response.size()).isEqualTo(bookingList2.size());
        assertThat(response).isEqualTo(bookingList2);
    }
}
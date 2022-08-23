package com.example.demo.booking;

import com.example.demo.Exceptions.EmptyListCheckException;
import com.example.demo.Exceptions.InvalidAgeException;
import com.example.demo.treck.Treks;
import com.example.demo.treck.TreksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private TreksService treksService;


    @BeforeEach
    void init(){
        bookingService = new BookingService(bookingRepository, treksService);
    }

    @Test
    void testViewAllBooking(){
        Booking P1B1 = new Booking();

        P1B1.setBookingId("P1B1");
        P1B1.setPersonId("Person1");
        P1B1.setTrekName("Blue Falls");
        P1B1.setTrekId("Trek1");
        P1B1.setPersonAge(50);

        Booking P1B2 = new Booking();

        P1B2.setBookingId("P1B2");
        P1B2.setPersonId("Person1");
        P1B2.setTrekName("Green Valley");
        P1B2.setTrekId("Trek2");
        P1B2.setPersonAge(50);

        Booking P1B3 = new Booking();

        P1B2.setBookingId("P1B3");
        P1B2.setPersonId("Person1");
        P1B2.setTrekName("Brown Mountains");
        P1B2.setTrekId("Trek3");
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
    void enterBooking() throws InvalidAgeException, EmptyListCheckException {
        Booking PIB1 = new Booking();

        PIB1.setBookingId("P1B1");
        PIB1.setPersonId("Person1");
        PIB1.setTrekName("Blue Falls");
        PIB1.setTrekId("Trek1");
        PIB1.setPersonAge(60);

        Treks T = new Treks();
        T.setMinimumAge(0);
        T.setMaximumAge(100);
        List<Treks> L = new ArrayList<>();
        L.add(T);
        Mockito.when(treksService.getTrailByTrekId("Trek1")).thenReturn(L);
        Mockito.when(bookingRepository.save(PIB1)).thenReturn(PIB1);
        String response = bookingService.enterBooking(PIB1);
        assertThat(response).isEqualTo("Booking Added");

//        Mockito.when(bookingRepository.save(PIB1)).thenReturn(PIB1);
//        Booking response = bookingService.enterBooking();
//        assertThat(bookingService.enterBooking(PIB1)).isEqualTo(PIB1);
    }



    @Test
    void enterBookingWithEmptyList() throws InvalidAgeException, EmptyListCheckException {
        Booking PIB1 = new Booking();

        PIB1.setBookingId("P1B1");
        PIB1.setPersonId("Person1");
        PIB1.setTrekName("Blue Falls");
        PIB1.setTrekId("Treck1");
        PIB1.setPersonAge(60);

        List<Treks> L = new ArrayList<>();
        Mockito.when(treksService.getTrailByTrekId("Treck1")).thenReturn(L);
//            String response = bookingService.enterBooking(PIB1);
        Exception exception = assertThrows(EmptyListCheckException.class, () -> {
            bookingService.enterBooking(PIB1);
        });
        Assert.assertEquals(exception.getMessage(), "No Booking Found");

//        assertThat(response).isEqualTo("No Booking Found");

    }

    @Test
    void enterBookingForInvalidAge() throws InvalidAgeException, EmptyListCheckException {
        Booking PIB1 = new Booking();

        PIB1.setBookingId("P1B1");
        PIB1.setPersonId("Person1");
        PIB1.setTrekName("Blue Falls");
        PIB1.setTrekId("Treck1");
        PIB1.setPersonAge(120);

        Treks T = new Treks();
        T.setMinimumAge(0);
        T.setMaximumAge(100);

        List<Treks> L = new ArrayList<>();
        L.add(T);
        Mockito.when(treksService.getTrailByTrekId("Trek1")).thenReturn(L);
//        String response = bookingService.enterBooking(PIB1);
        Exception exception = assertThrows(InvalidAgeException.class, () -> {
            bookingService.enterBooking(PIB1);
        });
        Assert.assertEquals(exception.getMessage(), "Invalid Age");

//        assertThat(response).isEqualTo("Invalid Age");
    }

    //        Mockito.when(bookingRepository.save(PIB1)).thenReturn(PIB1);
//        Booking response = bookingService.enterBooking();
//        assertThat(bookingService.enterBooking(PIB1)).isEqualTo(PIB1);


    @Test
    void deleteBooking(){
        Booking P1B1 = new Booking();

        P1B1.setBookingId("P1B1");
        P1B1.setPersonId("Person1");
        P1B1.setTrekName("Blue Falls");
        P1B1.setTrekId("Trek1");
        P1B1.setPersonAge(60);
        bookingService.deleteBooking("P1B1");
        Mockito.verify(bookingRepository,Mockito.atLeastOnce()).deleteById("P1B1");

    }
    @Test
    void getByPersonId (){
        Booking PIB1 = new Booking();

        PIB1.setBookingId("P1B1");
        PIB1.setPersonId("Person1");
        PIB1.setTrekName("Blue Falls");
        PIB1.setTrekId("Trek1");
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
    void getByTrekId(){
        Booking b = new Booking();

        b.setBookingId("P1B1");
        b.setPersonId("Person1");
        b.setTrekName("Blue Falls");
        b.setTrekId("Trek1");
        b.setPersonAge(60);

        List<Booking> bookingList2 = new ArrayList<>();
        bookingList2.add(b);
        Mockito.when(bookingRepository.findByTrekId("b")).thenReturn(bookingList2);
        List<Booking> response = bookingService.getBookingsByTrekId("b");
        assertThat(response.size()).isEqualTo(bookingList2.size());
        assertThat(response).isEqualTo(bookingList2);
    }
}
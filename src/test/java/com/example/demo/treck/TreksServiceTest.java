package com.example.demo.treck;

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
class TreksServiceTest {
    private TreksService treksService;
    @Mock
    private TreksRepository treksRepository;
    @BeforeEach
    void init(){
        treksService = new TreksService(treksRepository);
    }
    @Test
    void testEnterTrails(){
        Treks trek1 = new Treks();

        trek1.setTrekId("trek1");
        trek1.setName("Blue Falls");
        trek1.setStartAt("07:00");
        trek1.setEndAt("09:00");
        trek1.setMinimumAge(5);
        trek1.setMaximumAge(100);
        trek1.setUnitPrice(2900);
        Mockito.when(treksRepository.save(trek1)).thenReturn(trek1);
        assertThat(treksService.enterTrail(trek1)).isEqualTo(trek1);
    }
    @Test
    void testViewTrails(){
        Treks trek2 = new Treks();

        trek2.setTrekId("trek2");
        trek2.setName("Green Valley");
        trek2.setStartAt("10:00");
        trek2.setEndAt("13:00");
        trek2.setMinimumAge(11);
        trek2.setMaximumAge(50);
        trek2.setUnitPrice(5900);

        Treks trek3 = new Treks();

        trek3.setTrekId("trek3");
        trek3.setName("Brown Mountains");
        trek3.setStartAt("14:00");
        trek3.setEndAt("19:00");
        trek3.setMinimumAge(18);
        trek3.setMaximumAge(40);
        trek3.setUnitPrice(9900);

        List<Treks> treksList = new ArrayList<>();
        treksList.add(trek2);
        treksList.add(trek3);
        Mockito.when(treksRepository.findAll()).thenReturn(treksList);
        List<Treks> response = treksService.ViewTrails();
        assertThat(response.size()).isEqualTo(treksList.size());
        assertThat(response).isEqualTo(treksList);

    }
    @Test
    void getById(){
        Treks T1 = new Treks();

        T1.setTrekId("trek1");
        T1.setName("Blue Falls");
        T1.setStartAt("07:00");
        T1.setEndAt("09:00");
        T1.setMinimumAge(5);
        T1.setMaximumAge(100);
        T1.setUnitPrice(2990);

        List<Treks> treksList2 = new ArrayList<>();
        treksList2.add(T1);
        Mockito.when(treksRepository.findByTrekId("trek1")).thenReturn(treksList2);
        List<Treks> response = treksService.getTrailByTrekId("trek1");
        assertThat(response).isEqualTo(treksList2);
//        why not..........findTrail("trek1")  ??
    }

    @Test
    void getByName(){
        Treks T2 = new Treks();

        T2.setTrekId("trek1");
        T2.setName("Blue Falls");
        T2.setStartAt("07:00");
        T2.setEndAt("09:00");
        T2.setMinimumAge(5);
        T2.setMaximumAge(100);
        T2.setUnitPrice(2990);

        List<Treks> treksList3 = new ArrayList<>();
        treksList3.add(T2);
        Mockito.when(treksRepository.findByName("trek1")).thenReturn(treksList3);
        List<Treks> response = treksService.findTrail("trek1");
        assertThat(response.size()).isEqualTo(treksList3.size());
        assertThat(response).isEqualTo(treksList3);
//        Why not..........getTrail("name")  ??


    }

    }



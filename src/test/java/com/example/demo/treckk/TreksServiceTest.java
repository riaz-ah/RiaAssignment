package com.example.demo.treckk;

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
    private TrecksRepository trecksRepository;
    @BeforeEach
    void init(){
        treksService = new TreksService(trecksRepository);
    }
    @Test
    void testEnterTrails(){
        Trecks treck1 = new Trecks();

        treck1.setTreckId("treck1");
        treck1.setName("Blue Falls");
        treck1.setStartAt("07:00");
        treck1.setEndAt("09:00");
        treck1.setMinimumAge(5);
        treck1.setMaximumAge(100);
        treck1.setUnitPrice(2900);
        Mockito.when(trecksRepository.save(treck1)).thenReturn(treck1);
        assertThat(treksService.enterTrail(treck1)).isEqualTo(treck1);
    }
    @Test
    void testViewTrails(){
        Trecks treck2 = new Trecks();

        treck2.setTreckId("treck2");
        treck2.setName("Green Valley");
        treck2.setStartAt("10:00");
        treck2.setEndAt("13:00");
        treck2.setMinimumAge(11);
        treck2.setMaximumAge(50);
        treck2.setUnitPrice(5900);

        Trecks treck3 = new Trecks();

        treck3.setTreckId("treck3");
        treck3.setName("Brown Mountains");
        treck3.setStartAt("14:00");
        treck3.setEndAt("19:00");
        treck3.setMinimumAge(18);
        treck3.setMaximumAge(40);
        treck3.setUnitPrice(9900);

        List<Trecks> trecksList = new ArrayList<>();
        trecksList.add(treck2);
        trecksList.add(treck3);
        Mockito.when(trecksRepository.findAll()).thenReturn(trecksList);
        List<Trecks> response = treksService.ViewTrails();
        assertThat(response.size()).isEqualTo(trecksList.size());
        assertThat(response).isEqualTo(trecksList);

    }
    @Test
    void getById(){
        Trecks T1 = new Trecks();

        T1.setTreckId("treck1");
        T1.setName("Blue Falls");
        T1.setStartAt("07:00");
        T1.setEndAt("09:00");
        T1.setMinimumAge(5);
        T1.setMaximumAge(100);
        T1.setUnitPrice(2990);

        List<Trecks> trecksList2 = new ArrayList<>();
        trecksList2.add(T1);
        Mockito.when(trecksRepository.findByTreckId("treck1")).thenReturn(trecksList2);
        List<Trecks> response = treksService.getTrailByTreckId("treck1");
        assertThat(response).isEqualTo(trecksList2);
//        why not..........findTrail("treck1")  ??
    }

    @Test
    void getByName(){
        Trecks T2 = new Trecks();

        T2.setTreckId("treck1");
        T2.setName("Blue Falls");
        T2.setStartAt("07:00");
        T2.setEndAt("09:00");
        T2.setMinimumAge(5);
        T2.setMaximumAge(100);
        T2.setUnitPrice(2990);

        List<Trecks> trecksList3 = new ArrayList<>();
        trecksList3.add(T2);
        Mockito.when(trecksRepository.findByName("treck1")).thenReturn(trecksList3);
        List<Trecks> response = treksService.findTrail("treck1");
        assertThat(response.size()).isEqualTo(trecksList3.size());
        assertThat(response).isEqualTo(trecksList3);
//        Why not..........getTrail("name")  ??


    }

    }



package com.example.demo.treck;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = TreksController.class)
public class TreksControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private TreksService treksService;
    private TreksController treksController;

    @BeforeEach
    void init(){
        treksController = new TreksController(treksService);
    }

    @Test
    public void testViewTrails() throws Exception {
        Treks mockTrek = new Treks();
        mockTrek.setTrekId("trek1");
        mockTrek.setName("Blue Falls");
        mockTrek.setStartAt("07:00");
        mockTrek.setEndAt("09:00");
        mockTrek.setMinimumAge(5);
        mockTrek.setMaximumAge(100);
        mockTrek.setUnitPrice(2900);


        List<Treks> treksList = new ArrayList<>();
        treksList.add(mockTrek);
        String inputInJson = this.mapToJson(mockTrek);
        String URI = "/viewAllTrails";
        Mockito.when(treksService.ViewTrails()).thenReturn(treksList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result =  mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo(inputInJson);

        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatus());
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}

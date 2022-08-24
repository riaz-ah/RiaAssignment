package com.example.demo.booking;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Booking")

public class Booking {

    @Id
    private String id;

    private String bookingId;
    private String personId;
    private String trekName;
    private String trekId;
    private int personAge;

    }




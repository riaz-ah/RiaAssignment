package com.example.demo.treck;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Treks")
public class Treks {
    @Id
    private String id;
    private String trekId;
    private String name;
    private String startAt;
    private String endAt;
    private int minimumAge;
    private int maximumAge;
    private int unitPrice;

}

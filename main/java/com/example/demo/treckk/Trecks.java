package com.example.demo.treckk;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Trecks")
public class Trecks {
    @Id
    private String Id;
    private String name;
    private String startAt;
    private String endAt;
    private int minimumAge;
    private int maximumAge;
    private int unitPrice;

}

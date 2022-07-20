package com.example.demo.treckk.book;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document(collection = "Books")
public class Book {
@Id
    private String id;
    private String bookName;
    private String authorName;
    private String bookId;

}










































//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HelloWorldController {
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//    public String helloWorld(){
//        return "hello world";
//    }
//
//}

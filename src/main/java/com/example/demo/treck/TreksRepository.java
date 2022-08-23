package com.example.demo.treck;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TreksRepository extends MongoRepository<Treks, String> {


    List<Treks> findByTrekId(String trekId);
    List<Treks> findByName(String name);

//    object
}

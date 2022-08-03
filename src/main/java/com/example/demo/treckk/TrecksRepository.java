package com.example.demo.treckk;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TrecksRepository extends MongoRepository<Trecks, String> {


    List<Trecks> findByTreckId(String treckId);
    List<Trecks> findByName(String name);

//    object
}

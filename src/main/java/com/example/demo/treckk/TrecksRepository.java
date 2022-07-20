package com.example.demo.treckk;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrecksRepository extends MongoRepository<Trecks, String> {
}

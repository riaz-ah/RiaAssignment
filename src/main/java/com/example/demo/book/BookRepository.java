package com.example.demo.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends MongoRepository <Book, String> {

    Optional<Book> findByBookId(String bookId);
    List<Book> findByAuthorName(String authorName);

    void deleteByBookId (String bookId);



}

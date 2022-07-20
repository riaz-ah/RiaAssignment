package com.example.demo.treckk.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {
@Autowired
    private BookRepository repository;

    public String saveBook( Book book) {
        repository.save(book);
        return "Added book with id: " + book.getId();
    }

    public List<Book> getBooks() {return repository.findAll();
    }

    public Optional<Book> getBook(String id) {

        return repository.findByBookId(id);
    }
    public String deleteBook( String bookId) {
        repository.deleteByBookId(bookId);
        return "book deleted with id: " + bookId;
    }

    public List<Book> findBooks(String AuthorName) {
        return repository.findByAuthorName(AuthorName);
    }
}

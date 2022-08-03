package com.example.demo.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity <?>saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return ResponseEntity.status(200)
                .header("message", "record saved")
                .body("Added book with id: " + book.getId());
    }

    @GetMapping("/findAllBooks")
    public ResponseEntity <?>  getBooks() {
        return ResponseEntity.status(200)
                .header("message", "all books found")
                .body(bookService.getBooks());
    }

    @GetMapping("/findBooks/{id}")
    public ResponseEntity <?> getBook(@PathVariable String id) {
        return ResponseEntity.status(200)
                .header("message", "book found")
                .body(bookService.getBook(id));
    }

    @GetMapping("/findBookByAuthor/{AuthorName}")
    public ResponseEntity<?> findBook(@PathVariable String AuthorName) {
        return ResponseEntity.status(200)
                .header("message", "all books for this author")
                .body(bookService.findBooks(AuthorName));
    }

    @GetMapping("/delete/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable String bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.status(200)
                .header("message", "book deleted with this Id")
                .body("book deleted with id: " + bookId);
    }


}

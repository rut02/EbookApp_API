package com.example.finalproject.controller;

import com.example.finalproject.business.BookBusiness;
import com.example.finalproject.Payload.BookPayload;
import com.example.finalproject.json.BookListJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookBusiness bookBusiness;

    @Autowired
    public BookController(BookBusiness bookBusiness) {
        this.bookBusiness = bookBusiness;
    }

    @GetMapping
    public List<BookListJson> getAllBooks() {
        return bookBusiness.getListBook();
    }

    @GetMapping("/{id}")
    public BookListJson getBookById(@PathVariable Long id) {
        return bookBusiness.getBookById(id);
    }

    @GetMapping("/search/title/{title}")
    public List<BookListJson> getBooksByTitle(@PathVariable String title) {
        return bookBusiness.getBookByTitle(title);
    }
    @GetMapping("/search/author/{author}")
    public List<BookListJson> getBookByAuthor(@PathVariable String author) {
        return bookBusiness.getBookByAuthor(author);
    }
    @GetMapping("/search/genre/{genre}")
    public List<BookListJson> getBookByGenre(@PathVariable String genre) {
        return bookBusiness.getBookByGenre(genre);
    }
    @GetMapping("/search/other/{other}")
    public List<BookListJson> getBookByOther(@PathVariable String other) {
        return bookBusiness.getBookByOther(other);
    }

    @PostMapping
    public void createBook(@RequestBody BookPayload bookPayload) {
        bookBusiness.saveBook(bookPayload);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookPayload payload) {
        bookBusiness.updateBook(id, payload);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookBusiness.deleteBook(id);
    }
}
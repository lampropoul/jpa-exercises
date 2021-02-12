package org.vla.jpa.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.vla.jpa.demo.model.Book;
import org.vla.jpa.demo.repository.BookRepository;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    
    private final BookRepository bookRepository;
    
    public BookController(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @GetMapping
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }
    
}

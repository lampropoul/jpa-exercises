package org.vla.jpa.demo.init;

import java.util.Date;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import org.vla.jpa.demo.model.Book;
import org.vla.jpa.demo.repository.BookRepository;

@Component
public class DataInit {
    
    private final BookRepository bookRepository;
    
    public DataInit(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @PostConstruct
    public void insertData() {
        Book book = new Book();
        book.setTitle("JPA with Hibernate and Spring");
        book.setPublishingDate(new Date());
        book.setPages(300);
        bookRepository.save(book);
    }
    
}

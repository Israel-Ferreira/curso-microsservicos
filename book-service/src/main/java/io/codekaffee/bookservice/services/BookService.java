package io.codekaffee.bookservice.services;

import io.codekaffee.bookservice.dto.BookDTO;
import io.codekaffee.bookservice.exceptions.BookNotFoundException;
import io.codekaffee.bookservice.models.Book;
import io.codekaffee.bookservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Book createBook(BookDTO bookDTO){
        Book book = new Book(bookDTO);
        return bookRepository.save(book);
    }
}

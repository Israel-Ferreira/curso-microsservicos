package io.codekaffee.bookservice.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.codekaffee.bookservice.dto.BookDTO;
import io.codekaffee.bookservice.models.Book;
import io.codekaffee.bookservice.models.Cambio;
import io.codekaffee.bookservice.services.BookService;
import io.codekaffee.bookservice.services.CambioService;

@RestController
@RequestMapping("/book-service")
public class BooksController {


    private final Environment env;
    private final BookService bookService;
    private final CambioService cambioService;

    @Autowired
    public BooksController(Environment env, BookService bookService, CambioService cambioService){
        this.env = env;
        this.bookService = bookService;
        this.cambioService = cambioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBook(@PathVariable("id") Long id, @RequestParam(value = "currency", required = true, defaultValue = "BRL") String currency ){
        Book book = bookService.findBookById(id);
        Cambio cambio = cambioService.getCurrency(currency, book.getPrice());

        String port = env.getProperty("server.port");

        BookDTO bookDTO = new BookDTO(book, currency, port);
        bookDTO.setPrice(cambio.getConvertedValue());

        return ResponseEntity.ok(bookDTO);
    }


    @PostMapping
    public ResponseEntity<?> createBook(BookDTO bookDTO){
        Book book = bookService.createBook(bookDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + book.getId())
                .build().toUri();

        return ResponseEntity.created(uri).build();
    }
}

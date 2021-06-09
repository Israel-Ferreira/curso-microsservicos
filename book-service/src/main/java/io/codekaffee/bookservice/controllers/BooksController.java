package io.codekaffee.bookservice.controllers;

import io.codekaffee.bookservice.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/book-service")
public class BooksController {

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable("id") Long id, @RequestParam(value = "currency", required = true) String currency ){
        LocalDate date =  LocalDate.of(1996,8,1);


        Double price = 35.00;

        Book book = new Book(id, "A Game Of Thrones","George R.R Martin", date, price, "BRL");

        return ResponseEntity.ok(book);
    }
}

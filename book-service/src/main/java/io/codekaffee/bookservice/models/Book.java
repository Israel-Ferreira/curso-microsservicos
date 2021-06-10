package io.codekaffee.bookservice.models;

import io.codekaffee.bookservice.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String title;

    @Column(nullable = false, length = 180)
    private String author;

    @Column(nullable = false)
    private LocalDate launchDate;

    @Column(nullable = false)
    private Double price;



    public Book(Long id, String title, String author, LocalDate launchDate, Double price, String currency) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
    }

    public Book(String title, String author, LocalDate launchDate, Double price) {
        this.title = title;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
    }


    public Book(BookDTO bookDTO) {
        this.author = bookDTO.getAuthor();
        this.launchDate =  bookDTO.getLaunchDate();
        this.price = bookDTO.getPrice();
        this.title = bookDTO.getTitle();
    }

}

package io.codekaffee.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.bookservice.models.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String title;
    private String author;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate launchDate;

    private Double price;

    private String env;
    private String currency;


    public  BookDTO(Book book, String currency, String env){
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.launchDate = book.getLaunchDate();
        this.currency = currency;

        this.price = book.getPrice();

        this.env = env;
    }
}

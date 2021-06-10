package io.codekaffee.bookservice.exceptions.handlers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    private String msg;
    private Integer statusCode;

}

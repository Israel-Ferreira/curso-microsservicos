package io.codekaffee.bookservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private  String to;
    private Double convertedValue;
    private Double conversionFactor;
}

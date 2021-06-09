package io.codekaffee.cambioservice.exceptions;


public class CambioNotFoundException extends RuntimeException {
    public CambioNotFoundException() {
        super("Cotação não encontrada");
    }

    public CambioNotFoundException(String message) {
        super(message);
    }

    public CambioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

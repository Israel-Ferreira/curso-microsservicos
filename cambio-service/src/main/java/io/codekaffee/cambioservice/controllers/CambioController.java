package io.codekaffee.cambioservice.controllers;

import io.codekaffee.cambioservice.models.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cambio-service")
public class CambioController {

    @Autowired
    private Environment env;

    @GetMapping(value = "/convert")
    public ResponseEntity<Cambio> getCambio(
            @RequestParam(value = "amount", required = false) BigDecimal amount,
            @RequestParam(value = "from", required = true, defaultValue = "USD") String from,
            @RequestParam(value = "to", required = true, defaultValue = "BRL") String to
    ) {

        String port = env.getProperty("server.port");

        Cambio cambio = new Cambio(1L, from, to,BigDecimal.ONE, amount);
        cambio.setEnvironment(port);

        return ResponseEntity.ok(cambio);
    }
}

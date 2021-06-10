package io.codekaffee.cambioservice.controllers;

import io.codekaffee.cambioservice.dto.CambioDTO;
import io.codekaffee.cambioservice.services.CurrencyService;
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

    @Autowired
    private CurrencyService currencyService;


    @GetMapping(value = "/convert")
    public ResponseEntity<CambioDTO> getCambio(
            @RequestParam(value = "amount", required = false) BigDecimal amount,
            @RequestParam(value = "from", required = true, defaultValue = "USD") String from,
            @RequestParam(value = "to", required = true, defaultValue = "BRL") String to
    ) {


        String port = env.getProperty("server.port");

        CambioDTO cambioDTO =  currencyService.getValueByCambio(from,to,amount);
        cambioDTO.setEnv(port);

        return ResponseEntity.ok(cambioDTO);
    }
}

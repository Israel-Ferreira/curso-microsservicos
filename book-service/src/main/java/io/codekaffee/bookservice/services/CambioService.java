package io.codekaffee.bookservice.services;

import io.codekaffee.bookservice.clients.CambioFeignClient;
import io.codekaffee.bookservice.models.Cambio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CambioService {

    @Autowired
    private CambioFeignClient cambioFeignClient;

    @Value("${cambio-service.default-from-value}")
    private String from;

    public Cambio getCurrency(String to, Double price){
        log.info("Price: " + price);
        ResponseEntity<Cambio> rst =  cambioFeignClient.getCambio(from, to, price);

        return rst.getBody();
    }

}

package io.codekaffee.bookservice.clients;

import io.codekaffee.bookservice.models.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cambio-service", url = "localhost:8004")
public interface CambioFeignClient {

    @GetMapping("/cambio-service/convert")
    public ResponseEntity<Cambio> getCambio(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") Double amount
    );
}

package io.codekaffee.bookservice.services;

import io.codekaffee.bookservice.models.Cambio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CambioService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cambio-service.url}")
    private String url;

    @Value("${cambio-service.default-from-value}")
    private String from;

    public Cambio getCurrency(String to, Double price){
        String requestUrl = url + "?from=" + from + "&to=" + to + "&amount=" + price;

        log.info("Price: " + price);
        log.info("Request Url: " + requestUrl);

        ResponseEntity<Cambio> rst =  restTemplate.getForEntity(requestUrl, Cambio.class);

        return rst.getBody();
    }

}

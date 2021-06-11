package io.codekaffee.bookservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("book-service")
public class FooBarController {
    

    @GetMapping("/foo-bar")
    @Retry(name = "default")
    public ResponseEntity<String> fooBar(){

        log.info("Foo bar request is received");
        log.info("Tentando outra Vez...");

        var response = new RestTemplate()
            .getForEntity("http://localhost:29222", String.class);


        return response;
    } 
}

package io.codekaffee.bookservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@Tag(name = "foo-bar")
@RequestMapping("book-service")
public class FooBarController {
    

    @GetMapping("/foo-bar/retry")
    @Operation(summary = "example method - retry")
    @Retry(name = "default", fallbackMethod = "fallbackMethod" )
    public ResponseEntity<String> fooBar(){

        log.info("Foo bar request is received");
        log.info("Tentando outra Vez...");

        var response = new RestTemplate()
            .getForEntity("http://localhost:29222", String.class);


        return response;
    }



    @GetMapping("/foo-bar/cb")
    @Operation(summary = "example method - circuit breaker")
    @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    public ResponseEntity<String> fooBarCircuitBreaker(){
        log.info("Foo bar request is received");

        var response = new RestTemplate()
            .getForEntity("http://localhost:29222", String.class);


        return response;
    }


    @GetMapping("/foo-bar/rl")
    @Operation(summary = "example - rate limit")
    @RateLimiter(name = "rate-limit-ct", fallbackMethod = "fallbackMethod")
    public ResponseEntity<String> fooBarRateLimit(){
        return ResponseEntity.ok("Teste");
    }


    @GetMapping("/foo-bar/bulk-head")
    @Operation(summary = "example - bulkhead limit")
    @Bulkhead(name = "blk-head-foo", fallbackMethod = "fallbackMethod")
    public ResponseEntity<String> fooBarBulkhead(){
        System.out.println("Rodando BULK Head  ....");
        return ResponseEntity.ok("Teste");
    }


    public ResponseEntity<String>fallbackMethod(Exception e){
        var msg = "Deu Ruim";
        return ResponseEntity.ok(msg);
    }
}

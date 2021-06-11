package io.codekaffee.bookservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class FooBarController {
    

    @GetMapping("/foo-bar")
    public ResponseEntity<String> fooBar(){
        return ResponseEntity.ok("Hello, This processes of drugstore is a Varzea");
    } 
}

package com.examregistration.examregistration.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/surprise")
public class EasterEggController {
    
    private RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/{number}")
    public ResponseEntity<?> sruperiseMe(@PathVariable("number") String numberString) {
        Integer number = Integer.parseInt(numberString);
        String url = "http://numbersapi.com/" + number;
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}

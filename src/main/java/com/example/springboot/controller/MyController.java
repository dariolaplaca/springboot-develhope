package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MyController {
    Random random = new Random();
    @GetMapping(value = "/random")
    public ResponseEntity<ResponseStatus> rand(){
        if(random.nextBoolean()){
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(400).build();
    }

}

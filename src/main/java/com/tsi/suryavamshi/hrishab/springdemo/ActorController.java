package com.tsi.suryavamshi.hrishab.springdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor){
        Actor act = actor;
        return ResponseEntity.status(HttpStatus.CREATED).body(act);
    }
}

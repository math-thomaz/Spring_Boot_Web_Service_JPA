package com.maththomaz.webService.resources;

import com.maththomaz.webService.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Math", "math@gmail.com", "999999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}

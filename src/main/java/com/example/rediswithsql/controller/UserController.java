package com.example.rediswithsql.controller;

import com.example.rediswithsql.model.User;
import com.example.rediswithsql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        long start = System.currentTimeMillis();
        User user = userService.getById(id); // this method is @Cacheable
        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + " ms");
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "Successful";
    }

}

package com.apress.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserReactiveRepository userReactiveRepository;

    @GetMapping
    public Flux<User> allUsers() {
        return userReactiveRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User>  getUser(@PathVariable String id) {
        return userReactiveRepository.findById(id);
    }

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
       return userReactiveRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userReactiveRepository.deleteById(id);
    }
}


package com.example.fullstackspringbootandreact.web;

import com.example.fullstackspringbootandreact.domain.Car;
import com.example.fullstackspringbootandreact.domain.CarRepository;
import com.example.fullstackspringbootandreact.domain.PrincipalUser;
import com.example.fullstackspringbootandreact.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    private CarRepository repository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
    @GetMapping("/")
    public String getHello() {
    return  "hello world";
    }
    @GetMapping("/user")
    public String user() {
        return "Hello, User!";
    }
    @GetMapping("/users")
    public Iterable<PrincipalUser> users() {
        return userRepository.findAll() ;
    }
}



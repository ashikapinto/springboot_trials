package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @Autowired
    private CabService service;

    //create user
    @PostMapping("/users")
    public void add(@RequestBody User user) {
        service.saveuser(user);
    }

    // get all users
    @GetMapping("/users")
    public List<User> list() {
        return service.listusers();
    }

    //create ride
    @PostMapping("/ride")
    public void addride(@RequestBody Rides ride) {
        service.saveride(ride);
    }

    //get all rides of a user
    @GetMapping("/rides/{name}")
    public List<Rides> getridesforuser(@PathVariable String name) {
        System.out.println("getting all rides of a user");
        return service.getByName(name);
    }

    //delete user -> deletes all his rides too
    @DeleteMapping("/users/{name}")
    public void delete(@PathVariable String name) {
        service.delete(name);
    }


    //delete ride
    @DeleteMapping("/rides/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteride(id);
    }



}


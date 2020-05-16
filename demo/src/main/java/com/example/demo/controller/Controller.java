package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @Autowired
    private CabService service;

    //register a new user
    @PostMapping("/api/users")
    public void add(@RequestBody User user) {
        service.saveuser(user);
    }

    // get all registered users
    @GetMapping("/api/users")
    public List<User> list() {
        return service.listusers();
    }

    //create a new ride for a registered user
    @GetMapping("/api/ride")
    public String addride(@RequestParam String name,@RequestParam Integer source, @RequestParam Integer destination) {
        if(service.checkuser(name)) {
            System.out.println("User exists");
            service.saveride(name,source,destination);
            return "Done!";
        }
        else{

            System.out.println("nope");
            return "The user is not registered. Please register first.";
        }


    }

    //get all rides of a user
    @GetMapping("/api/rides/{name}")
    public List<Rides> getridesforuser(@PathVariable String name) {
        System.out.println("getting all rides of a user");
        return service.getByName(name);
    }

    //delete user -> deletes all his rides too
    @DeleteMapping("/api/users/{name}")
    public void delete(@PathVariable String name) {
        service.delete(name);
    }


    //delete ride
    @DeleteMapping("/api/rides/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteride(id);
    }


    //join an existing ride
    @PostMapping("/api/joinride")
    public String joinride(@RequestParam String name,@RequestParam Integer rideId){
        if(service.checkuser(name)) {
            System.out.println("User exists");
            service.saveshare(name,rideId);
            return "Done!";
        }
        else{

            System.out.println("nope");
            return "The user is not registered. Please register first.";
        }

    }

    //get members who joined a ride
    @GetMapping("/api/ride/{id}/")
    public List<Share> getmembers(@PathVariable Integer id){
        System.out.println(id);
        return service.getmembersofride(id);
    }



}


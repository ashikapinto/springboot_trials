package com.example.demo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RidesRepository extends CrudRepository<Rides,Integer>{
    List<Rides> findByName(String name);
    public void deleteByName(String name);
}


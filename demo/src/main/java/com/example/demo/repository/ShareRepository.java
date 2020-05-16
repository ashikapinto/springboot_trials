package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareRepository extends CrudRepository<Share,Integer> {
    List<Share> findByRideId(Integer rideId);
}





package com.example.demo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    public void deleteByName(String name);
    public boolean existsByName(String name);
}

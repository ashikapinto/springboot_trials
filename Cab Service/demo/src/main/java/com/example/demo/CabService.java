package com.example.demo;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CabService {
    @Autowired
    private UserRepository userrepo;

    @Autowired
    private RidesRepository riderepo;

    public void saveuser(User user) {
        userrepo.save(user);
    }
    public List<User> listusers() {
        return (List<User>) userrepo.findAll();
    }
    public void saveride(Rides ride) {
        riderepo.save(ride);
    }
    public List<Rides> getByName(String name){
        System.out.println(riderepo.findAll());
        return riderepo.findByName(name);
    }
    public void deleteride(Integer id) {
        System.out.println(id);
        riderepo.deleteById(id);
    }
    public void delete(String name) {
        userrepo.deleteByName(name);
        riderepo.deleteByName(name);
    }

}


package com.example.demo;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.font.TrueTypeFont;

@Service
@Transactional
public class CabService {
    @Autowired
    private UserRepository userrepo;

    @Autowired
    private RidesRepository riderepo;
    @Autowired
    private ShareRepository sharerepo;

    public void saveuser(User user) {
        userrepo.save(user);
    }

    public List<User> listusers() {
        return (List<User>) userrepo.findAll();
    }

    public boolean checkuser(String name){
        if(userrepo.existsByName(name)){
            return true;
        }
        else{
            return false;
        }
    }
    public void saveride(String name,Integer source, Integer destination ) {
        System.out.println("in service");
        riderepo.save(new Rides(name,source,destination));
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
    public void saveshare(String name,Integer rideId){
        sharerepo.save(new Share(name,rideId));

    }
    public List<Share> getmembersofride(Integer rideId){
        //int rideId=Integer.parseInt(id);
        return sharerepo.findByRideId(rideId);
    }

}


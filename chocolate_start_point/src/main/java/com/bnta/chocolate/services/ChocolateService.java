package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {


    @Autowired
    ChocolateRepository chocolateRepository;

        public List<Chocolate> getAllChocolate(){
        return chocolateRepository.findAll();
    }

    public Optional<Chocolate> getChocolateById(Long id){
        return chocolateRepository.findById(id);
    }

    public Chocolate saveChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }
}


//
//Create a package called services and two classes: ChocolateService and EstateService.
//Use these classes to create methods to handle saving Chocolate and Estate objects to the database.
//This is your service layer and will handle all interactions with the repositories.
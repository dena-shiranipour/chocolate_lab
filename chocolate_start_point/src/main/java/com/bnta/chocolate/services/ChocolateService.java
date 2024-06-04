package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Chocolate> getAllOver60Chocolate(){
            List<Chocolate> allChocolates = chocolateRepository.findAll();
        List<Chocolate> over60Chocolate = new ArrayList<>();
        for(Chocolate chocolate : allChocolates){
            if(chocolate.getCocoaPercentage() >= 60){
                over60Chocolate.add(chocolate);
            }
        }
        return over60Chocolate;
    }


}



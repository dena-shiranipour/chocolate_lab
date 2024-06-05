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

    public void saveChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
    }

    public List<Chocolate> getChocolatesWithCocoaPercentageGreaterThan(int cocoaPercentage){
        return chocolateRepository.findByCocoaPercentageGreaterThanOrEqualTo(cocoaPercentage);
    }


}



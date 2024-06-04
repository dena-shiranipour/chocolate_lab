package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    // localhost:8080/chocolates OR localhost:8080/chocolates?isOver60=true
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolate(@RequestParam Optional<Boolean> isOver60){
        List<Chocolate> chocolates;
        if(chocolates.getCocoaPercentage() >= 60){
            chocolates = chocolateService.getAllOver60Chocolate();
        } else {
            chocolates = chocolateService.getAllChocolate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable Long id){
        Optional<Chocolate> chocolate = chocolateService.getChocolateById(id);
        if(chocolate.isPresent()){
            return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}

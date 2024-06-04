package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Estate estate = new Estate ("Kate's Estate", "France");
        estateService.saveEstate(estate);
        Estate estate2 = new Estate ("Dena's Estate", "Spain");
        estateService.saveEstate(estate2);
        Chocolate chocolate = new Chocolate("Kate's Chocolate", 75, estate);
        chocolateService.saveChocolate(chocolate);
        Chocolate chocolate2 = new Chocolate("Dena's Chocolate", 25, estate2);
        chocolateService.saveChocolate(chocolate2);
    }

}

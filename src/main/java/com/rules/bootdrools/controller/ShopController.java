package com.rules.bootdrools.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rules.bootdrools.model.Fare;
import com.rules.bootdrools.model.Product;
import com.rules.bootdrools.model.TaxiRide;
import com.rules.bootdrools.service.ShopService;
import com.rules.bootdrools.service.TaxiFareCalculatorService;
import com.rules.bootdrools.service.TaxiFareConfiguration;

@RestController
public class ShopController {


	@RequestMapping(value = "/getFare", method = RequestMethod.GET, produces = "application/json")
	public Fare getQuestions(@RequestParam(value = "night", required = false,defaultValue = "false") Boolean night,@RequestParam(value = "distance", required = false,defaultValue = "0") Long distance) {		
        ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
        TaxiFareCalculatorService taxiFareCalculatorService = (TaxiFareCalculatorService) context.getBean(TaxiFareCalculatorService.class);
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(night);
        taxiRide.setDistanceInMile(distance);
        Fare rideFare = new Fare();
        taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
        

		return rideFare;
	}
}

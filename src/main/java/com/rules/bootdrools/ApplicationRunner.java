package com.rules.bootdrools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rules.bootdrools.model.Fare;
import com.rules.bootdrools.model.TaxiRide;
import com.rules.bootdrools.service.TaxiFareCalculatorService;
import com.rules.bootdrools.service.TaxiFareConfiguration;

public class ApplicationRunner {
	  public static void main(String[] args) {
	        ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
	        TaxiFareCalculatorService taxiFareCalculatorService = (TaxiFareCalculatorService) context.getBean(TaxiFareCalculatorService.class);
	        TaxiRide taxiRide = new TaxiRide();
	        taxiRide.setIsNightSurcharge(true);
	        taxiRide.setDistanceInMile(190L);
	        Fare rideFare = new Fare();
	        taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
	    }
}

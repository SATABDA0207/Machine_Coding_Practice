package com.cabBookingApp.service;

import com.cabBookingApp.models.Cab;
import com.cabBookingApp.models.Driver;
import com.cabBookingApp.models.Location;
import com.cabBookingApp.repository.ApplicationRepository;

public class DriverApplication {
    private static ApplicationRepository applicationRepository = ApplicationRepository.getInstance();
    public void registerCab(String cabId, String driverId, int firstLocation, int secondLocation){
        Driver driver = Driver.builder().id(driverId).availability(true).build();
        Location location = Location.builder().x1(firstLocation).x2(secondLocation).build();
        Cab cab = Cab.builder().cabAvailable(true).driver(driver).id(cabId).cabLocation(location).build();

        applicationRepository.registerCab(cab);
        applicationRepository.printCabList();
    }
}

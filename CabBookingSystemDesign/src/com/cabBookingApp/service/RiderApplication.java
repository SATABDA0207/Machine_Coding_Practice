package com.cabBookingApp.service;

import com.cabBookingApp.models.Cab;
import com.cabBookingApp.models.Location;
import com.cabBookingApp.models.Ride;
import com.cabBookingApp.models.Rider;
import com.cabBookingApp.repository.ApplicationRepository;

import java.util.ArrayList;

public class RiderApplication {
    private static ApplicationRepository applicationRepository = ApplicationRepository.getInstance();
    public void registerRider(String riderId, int firstLocation, int secondLocation){
        Location location = Location.builder().x1(firstLocation).x2(secondLocation).build();
        Rider rider = Rider.builder().id(riderId).rideHistory(new ArrayList<>()).riderLocation(location).build();

        applicationRepository.registerRider(rider);
        applicationRepository.printRiderList();
    }

    public void bookRide(String riderId, int finalFirstLocation, int finalSecondLocation){
        Location finalLocation = Location.builder().x2(finalSecondLocation)
                .x1(finalFirstLocation).build();
        Rider rider = applicationRepository.getRider(riderId);
        Cab assignedCab = applicationRepository.bookRide(rider.getRiderLocation());

        System.out.println("Rider Id: " + riderId + " has been assigned to CabId: " + assignedCab.getId());

        Ride ride = Ride.builder().initialLocation(rider.getRiderLocation())
                .destinationLocation(finalLocation).cabDetails(assignedCab).riderDetails(rider).build();
        applicationRepository.addRiderHistory(ride, rider);
        applicationRepository.updateFinalLocation(rider, assignedCab, finalLocation);
    }
}

package com.cabBookingApp.repository;

import com.cabBookingApp.models.Cab;
import com.cabBookingApp.models.Location;
import com.cabBookingApp.models.Ride;
import com.cabBookingApp.models.Rider;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {
    private static ApplicationRepository instance;
    private List<Rider> riderList;
    private List<Cab> cabList;
    private List<Cab> availableCabList;

    private ApplicationRepository(){
        this.riderList = new ArrayList<>();
        this.cabList = new ArrayList<>();
        this.availableCabList = new ArrayList<>();
    }

    public static ApplicationRepository getInstance(){
        if(instance == null){
            synchronized (ApplicationRepository.class){
                if(instance == null){
                    instance = new ApplicationRepository();
                }
            }
        }
        return instance;
    }

    public void registerCab(Cab cab){
        cabList.add(cab);
        availableCabList.add(cab);
    }

    public void registerRider(Rider rider){
        riderList.add(rider);
    }

    public Cab bookRide(Location location){
        int minDistance = Integer.MAX_VALUE;
        Cab bookedCab = null;

        for(Cab cab : availableCabList){
            int distance = cab.getCabLocation().calculateDistance(location);
            if(distance < minDistance){
                minDistance = distance;
                bookedCab = cab;
            }
        }

        availableCabList.remove(bookedCab);
        return bookedCab;
    }

    public void addRiderHistory(Ride ride, Rider rider){
        int index = riderList.indexOf(rider);
        riderList.get(index).getRideHistory().add(ride);
    }

    public Rider getRider(String riderId){
        for (Rider rider : riderList){
            if(rider.getId().equals(riderId)) return rider;
        }

        return null;
    }

    public void updateFinalLocation(Rider rider, Cab cab, Location finalLocation){
        rider.setRiderLocation(finalLocation);
        cab.setCabLocation(finalLocation);
    }

    public void printCabList(){
        System.out.println(cabList);
        System.out.println(availableCabList);
    }

    public void printRiderList(){
        System.out.println(riderList);
    }
}

package com.cabBookingApp.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
    private int x1;
    private int x2;

    public int calculateDistance(Location location){
        return (int) Math.sqrt((x1 - x2)*(x1 - x2) + (location.x1 - location.x2) * (location.x1 - location.x2));
    }
}

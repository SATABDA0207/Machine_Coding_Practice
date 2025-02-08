package com.cabBookingApp.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Rider {
    private String id;
    private Location riderLocation;
    private List<Ride> rideHistory;
}

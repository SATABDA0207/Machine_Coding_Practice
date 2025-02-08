package com.cabBookingApp.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ride {
    private String id;
    private Cab cabDetails;
    private Rider riderDetails;
    private Location initialLocation;
    private Location destinationLocation;
}

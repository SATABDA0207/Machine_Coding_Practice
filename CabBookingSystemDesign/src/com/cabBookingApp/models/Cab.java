package com.cabBookingApp.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cab {
    private String id;
    private Driver driver;
    private Location cabLocation;
    private Boolean cabAvailable;
}

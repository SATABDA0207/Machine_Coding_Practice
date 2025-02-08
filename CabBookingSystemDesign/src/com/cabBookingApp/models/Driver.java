package com.cabBookingApp.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Driver {
    private String id;
    private Boolean availability;

    public void switchAvailability(){
        availability = !availability;
    }
}

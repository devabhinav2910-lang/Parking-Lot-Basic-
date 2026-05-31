package org.example.models;

import lombok.Data;
import org.example.enums.VehicleType;

@Data
public class ParkingLot {
    private final String id;
    private final VehicleType canPark;
    private final String number;
    private final boolean isAvailable;
    private final int floorNumber;
}

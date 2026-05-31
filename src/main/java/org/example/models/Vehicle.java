package org.example.models;

import lombok.Data;
import org.example.enums.VehicleType;

@Data
public class Vehicle {
    private final String id;
    private final VehicleType type;
    private final Double weight;
    private final String vehicleNumber;
}

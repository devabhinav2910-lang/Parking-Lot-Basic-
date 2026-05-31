package org.example.services;

import org.example.enums.VehicleType;

public interface IAvailabilityService {
    boolean isParkingLotAvailable(VehicleType vehicleType);
    boolean markParkingLotAsAvailable(String parkingLotId);
    boolean markParkingLotAsUnavailable(String parkingLotId);
}

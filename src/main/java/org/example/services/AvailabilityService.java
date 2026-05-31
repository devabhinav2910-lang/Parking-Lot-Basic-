package org.example.services;

import org.example.enums.VehicleType;
import org.example.models.ParkingLot;
import org.example.registry.Registry;

public class AvailabilityService implements IAvailabilityService {
    private final Registry registry;

    public AvailabilityService(Registry registry) {
        this.registry = registry;
    }

    @Override
    public boolean isParkingLotAvailable(VehicleType vehicleType) {
        return registry.getParkingLotRegistry().values().stream()
                .anyMatch(lot -> lot.isAvailable() && lot.getCanPark() == vehicleType);
    }

    @Override
    public boolean markParkingLotAsAvailable(String parkingLotId) {
        ParkingLot lot = registry.getParkingLotRegistry().get(parkingLotId);
        if (lot == null) return false;
        
        ParkingLot updatedLot = new ParkingLot(
            lot.getId(),
            lot.getCanPark(),
            lot.getNumber(),
            true,
            lot.getFloorNumber()
        );
        registry.getParkingLotRegistry().put(parkingLotId, updatedLot);
        return true;
    }

    @Override
    public boolean markParkingLotAsUnavailable(String parkingLotId) {
        ParkingLot lot = registry.getParkingLotRegistry().get(parkingLotId);
        if (lot == null) return false;
        
        ParkingLot updatedLot = new ParkingLot(
            lot.getId(),
            lot.getCanPark(),
            lot.getNumber(),
            false,
            lot.getFloorNumber()
        );
        registry.getParkingLotRegistry().put(parkingLotId, updatedLot);
        return true;
    }
}

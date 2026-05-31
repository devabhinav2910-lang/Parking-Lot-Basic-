package org.example.repo;

import org.example.models.ParkingLot;
import org.example.registry.Registry;

public class ParkingLotRepo implements IParkingLotRepo{
    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        Registry.addParkingLot(parkingLot);
    }

    @Override
    public ParkingLot getParkingLot(String id) {
       return  Registry.getParkingLot(id);
    }
}

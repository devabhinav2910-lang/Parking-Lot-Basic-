package org.example.repo;

import org.example.models.ParkingLot;

public interface IParkingLotRepo {
    void addParkingLot(ParkingLot parkingLot);
    ParkingLot getParkingLot(String id);
}

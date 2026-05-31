package org.example.services;

import org.example.enums.VehicleType;
import org.example.models.ParkingLot;
import org.example.models.ParkingTicket;
import org.example.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class FareCalculationService implements IFareCalculationService {
    private final Map<VehicleType, Double> hourlyRates;
    private final Registry registry;

    public FareCalculationService(Registry registry) {
        this.registry = registry;
        this.hourlyRates = new HashMap<>();
        // Default rates per hour
        hourlyRates.put(VehicleType.CAR, 20.0);
        hourlyRates.put(VehicleType.BIKE, 10.0);
        hourlyRates.put(VehicleType.TRUCK, 50.0);
    }

    @Override
    public double calculateFare(ParkingTicket ticket) {
        if (ticket.getExitTime() == null) {
            throw new IllegalArgumentException("Exit time not set");
        }

        ParkingLot lot = registry.getParkingLotRegistry().get(ticket.getParkingLotId());
        VehicleType vehicleType = lot.getCanPark();

        long durationInMillis = ticket.getExitTime() - ticket.getEntryTime();
        double durationInHours = durationInMillis / (1000.0 * 60 * 60);
        
        // Minimum 1 hour charge
        if (durationInHours < 1) {
            durationInHours = 1;
        }

        double hourlyRate = hourlyRates.getOrDefault(vehicleType, 20.0);
        return Math.ceil(durationInHours) * hourlyRate;
    }
}

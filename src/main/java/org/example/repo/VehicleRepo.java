package org.example.repo;

import org.example.models.Vehicle;
import org.example.registry.Registry;

public class VehicleRepo implements IVehicleRepo{
    @Override
    public Vehicle getVehicle(String id) {
        return Registry.getVehicle(id);
    }

    @Override
    public void addVehicle(Vehicle v) {
        Registry.addVehicle(v);
    }
}

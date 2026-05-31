package org.example.repo;

import org.example.models.Vehicle;

public interface IVehicleRepo {
    Vehicle getVehicle(String id);
    void addVehicle(Vehicle v);
}

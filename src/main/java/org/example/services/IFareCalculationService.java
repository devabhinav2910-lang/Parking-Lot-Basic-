package org.example.services;

import org.example.models.ParkingTicket;

public interface  IFareCalculationService {
    double calculateFare(ParkingTicket ticket);
}

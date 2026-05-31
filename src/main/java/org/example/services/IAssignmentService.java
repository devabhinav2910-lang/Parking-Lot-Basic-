package org.example.services;

import org.example.models.ParkingTicket;
import org.example.models.Vehicle;


public interface IAssignmentService {
    ParkingTicket assignParkingLot(Vehicle v);
    void deAssignParkingLot(ParkingTicket ticket);
}

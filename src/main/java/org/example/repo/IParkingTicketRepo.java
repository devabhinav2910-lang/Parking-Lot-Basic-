package org.example.repo;

import org.example.models.ParkingTicket;

public interface IParkingTicketRepo {
    ParkingTicket getParkingTicket(String id);
    void addParkingTicket(ParkingTicket parkingTicket);
}

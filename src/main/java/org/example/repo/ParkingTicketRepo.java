package org.example.repo;

import org.example.models.ParkingTicket;
import org.example.registry.Registry;

public class ParkingTicketRepo implements IParkingTicketRepo{
    @Override
    public ParkingTicket getParkingTicket(String id) {
        return Registry.getParkingTicket(id);
    }

    @Override
    public void addParkingTicket(ParkingTicket parkingTicket) {
        Registry.addParkingTicket(parkingTicket);
    }
}

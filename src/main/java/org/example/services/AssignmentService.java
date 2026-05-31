package org.example.services;

import org.example.exceptions.ParkingLotException;
import org.example.models.ParkingLot;
import org.example.models.ParkingTicket;
import org.example.models.Vehicle;
import org.example.registry.Registry;

public class AssignmentService implements IAssignmentService {
    private final IAvailabilityService availabilityService;
    private final Registry registry;

    public AssignmentService(IAvailabilityService availabilityService, Registry registry) {
        this.availabilityService = availabilityService;
        this.registry = registry;
    }

    @Override
    public ParkingTicket assignParkingLot(Vehicle v) {
        if (!availabilityService.isParkingLotAvailable(v.getType())) {
            throw new ParkingLotException("No ParkingSlot Available Right now");
        }
        ParkingLot availableParkingLot = null;
        for (ParkingLot parkingLot : registry.getParkingLotRegistry().values()) {
            if (parkingLot.isAvailable()) {
                availableParkingLot = parkingLot;
                break;
            }
        }
        availabilityService.markParkingLotAsUnavailable(availableParkingLot.getId());
        ParkingTicket p = new  ParkingTicket("ParkingTicket_" + v.getVehicleNumber(), 1,  null, System.currentTimeMillis(), null, availableParkingLot.getId());
        registry.getParkingTicketRegistry().put("ParkingTicket_" + v.getVehicleNumber(), p);
        return p;
    }

    @Override
    public void deAssignParkingLot(ParkingTicket ticket) {
        availabilityService.markParkingLotAsAvailable(ticket.getParkingLotId());
    }
}

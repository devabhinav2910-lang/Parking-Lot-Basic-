package org.example;

import org.example.enums.VehicleType;
import org.example.models.ParkingTicket;
import org.example.models.Vehicle;
import org.example.registry.Registry;
import org.example.services.*;

public class Main {
    public static void main(String[] args) {
        // Initialize
        Registry registry = new Registry();
        IAvailabilityService availabilityService = new AvailabilityService(registry);
        IAssignmentService assignmentService = new AssignmentService(availabilityService, registry);
        IFareCalculationService fareService = new FareCalculationService(registry);

        System.out.println("=== Parking Lot System Demo ===\n");

        // Test 1: Park a vehicle
        Vehicle car1 = registry.getVehicleRegistry().get("vehicle1");
        System.out.println("1. Parking vehicle: " + car1.getVehicleNumber());
        ParkingTicket ticket1 = assignmentService.assignParkingLot(car1);
        System.out.println("   Ticket ID: " + ticket1.getId());
        System.out.println("   Assigned Lot: " + ticket1.getParkingLotId());
        System.out.println("   Entry Time: " + ticket1.getEntryTime() + "\n");

        // Test 2: Park another vehicle
        Vehicle car2 = registry.getVehicleRegistry().get("vehicle2");
        System.out.println("2. Parking vehicle: " + car2.getVehicleNumber());
        ParkingTicket ticket2 = assignmentService.assignParkingLot(car2);
        System.out.println("   Ticket ID: " + ticket2.getId());
        System.out.println("   Assigned Lot: " + ticket2.getParkingLotId() + "\n");

        // Test 3: Simulate time passage and checkout
        try {
            Thread.sleep(2000); // Simulate 2 seconds parking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("3. Vehicle " + car1.getVehicleNumber() + " exiting...");
        long exitTime = System.currentTimeMillis();
        ParkingTicket updatedTicket1 = new ParkingTicket(
            ticket1.getId(),
            ticket1.getEntryGate(),
            1, // exit gate
            ticket1.getEntryTime(),
            exitTime,
            ticket1.getParkingLotId()
        );

        double fare = fareService.calculateFare(updatedTicket1);
        System.out.println("   Duration: " + (exitTime - ticket1.getEntryTime()) + " ms");
        System.out.println("   Fare: Rs. " + fare);

        assignmentService.deAssignParkingLot(updatedTicket1);
        System.out.println("   Parking lot " + ticket1.getParkingLotId() + " is now available\n");

        // Test 4: Check availability
        System.out.println("4. Checking availability for CAR: " +
            availabilityService.isParkingLotAvailable(VehicleType.CAR));

        System.out.println("\n=== Demo Complete ===");
    }
}
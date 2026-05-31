package org.example.registry;

import org.example.enums.VehicleType;
import org.example.models.ParkingLot;
import org.example.models.ParkingTicket;
import org.example.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private static Map<String, Vehicle> vehicleRegistry = new HashMap<>();
    private static Map<String, ParkingLot> parkingLotRegistry = new HashMap<>();
    private static Map<String, ParkingTicket> parkingTicketRegistry = new HashMap<>();


    static {
        vehicleRegistry.put("vehicle1", new Vehicle("vehicle1", VehicleType.CAR, 100.0, "V1"));
        vehicleRegistry.put("vehicle2", new Vehicle("vehicle2", VehicleType.CAR, 100.0, "V2"));
        vehicleRegistry.put("vehicle3", new Vehicle("vehicle3", VehicleType.CAR, 100.0, "V3"));


        parkingLotRegistry.put("lot1", new ParkingLot("lot1", VehicleType.CAR, "S1", true, 1));
        parkingLotRegistry.put("lot2", new ParkingLot("lot2", VehicleType.CAR, "S2", true, 2));
        parkingLotRegistry.put("lot3", new ParkingLot("lot3", VehicleType.CAR, "S3", true, 3));
    }

    public Map<String, Vehicle> getVehicleRegistry(){
        return vehicleRegistry;
    }

    public Map<String, ParkingLot> getParkingLotRegistry(){
        return parkingLotRegistry;
    }

    public Map<String, ParkingTicket> getParkingTicketRegistry(){
        return parkingTicketRegistry;
    }

    public static void addVehicle(Vehicle v) {
        vehicleRegistry.put(v.getId(), v);
    }

    public static Vehicle getVehicle(String vehicleId) {
        return vehicleRegistry.get(vehicleId);
    }

    public static ParkingTicket getParkingTicket(String id) {
        return parkingTicketRegistry.get(id);
    }

    public static void addParkingTicket(ParkingTicket t) {
        parkingTicketRegistry.put(t.getId(), t);
    }


    public static ParkingLot getParkingLot(String id) {
        return parkingLotRegistry.get(id);
    }

    public static void addParkingLot(ParkingLot parkingLot) {
        parkingLotRegistry.put(parkingLot.getId(), parkingLot);
    }
}

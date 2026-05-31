package org.example.models;

import lombok.Data;

@Data
public class ParkingTicket {
    private final String id;
    private final Integer entryGate;
    private final Integer exitGate;
    private final Long entryTime;
    private final Long exitTime;
    private final String parkingLotId;
}

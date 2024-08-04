package org.lld.conceptCoding.questions.ParkingLot.parking.ticket;

import org.joda.time.DateTime;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;

public class Ticket {
    private final DateTime entryTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public Ticket(DateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }
    public DateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}

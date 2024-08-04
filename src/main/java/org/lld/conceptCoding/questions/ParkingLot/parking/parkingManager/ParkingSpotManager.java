package org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager;

import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;

import java.util.List;

public abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public abstract  ParkingSpot findParkingSpot(Vehicle vehicle);
    public void parkVehicle(Vehicle vehicle, ParkingSpot spot){

    }
    public abstract void removeVehicle(ParkingSpot spot);
}

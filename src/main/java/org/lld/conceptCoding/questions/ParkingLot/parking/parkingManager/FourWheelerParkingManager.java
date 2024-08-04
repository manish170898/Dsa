package org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager;

import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.FourWheelerParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;

import java.util.List;

public class FourWheelerParkingManager extends ParkingSpotManager {
    public FourWheelerParkingManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }
    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots){
            if(spot instanceof FourWheelerParkingSpot && spot.getVehicle() == null){
                spot.parkVehicle(vehicle);
                return spot;
            }
        }
        return null;
    }
    @Override
    public void removeVehicle(ParkingSpot spot) {
        spot.removeVehicle();
    }
}

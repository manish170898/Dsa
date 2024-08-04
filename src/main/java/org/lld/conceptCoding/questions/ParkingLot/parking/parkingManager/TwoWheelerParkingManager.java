package org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager;

import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.TwoWheelParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;

import java.util.List;

public class TwoWheelerParkingManager extends ParkingSpotManager{

    public TwoWheelerParkingManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }
    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots){
            if(spot instanceof TwoWheelParkingSpot && spot.getVehicle() == null){
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

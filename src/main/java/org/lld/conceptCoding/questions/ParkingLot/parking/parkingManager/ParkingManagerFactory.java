package org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager;

import org.lld.conceptCoding.questions.ParkingLot.exceptions.InvalidVehicleTypeException;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.VehicleType;

import java.util.List;

public class ParkingManagerFactory {
    public ParkingSpotManager getVehicleTypeManager(VehicleType vehicleType, List<ParkingSpot> parkingSpots) throws InvalidVehicleTypeException {
        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerParkingManager(parkingSpots);
        }
        else if(vehicleType.equals(VehicleType.FOUR_WHEELER)){
            return new FourWheelerParkingManager(parkingSpots);
        }
        else{
            throw new InvalidVehicleTypeException("Vehicle is neither Two Wheeler nor Four Wheeler");
        }
    }
}

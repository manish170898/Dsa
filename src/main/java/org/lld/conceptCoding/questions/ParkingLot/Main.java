package org.lld.conceptCoding.questions.ParkingLot;

import org.lld.conceptCoding.questions.ParkingLot.entranceGate.EntranceGateA;
import org.lld.conceptCoding.questions.ParkingLot.exceptions.InvalidVehicleTypeException;
import org.lld.conceptCoding.questions.ParkingLot.exceptions.ParkingSpaceNotFoundException;
import org.lld.conceptCoding.questions.ParkingLot.exitGate.ExitGateA;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager.ParkingManagerFactory;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.FourWheelerParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.TwoWheelParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();

        List<TwoWheelParkingSpot> twoWheelParkingSpots = new ArrayList<>();
        twoWheelParkingSpots.add(new TwoWheelParkingSpot(1,10));
        twoWheelParkingSpots.add(new TwoWheelParkingSpot(2,10));
        twoWheelParkingSpots.add(new TwoWheelParkingSpot(3,10));

        List<FourWheelerParkingSpot> fourWheelParkingSpots = new ArrayList<>();
        fourWheelParkingSpots.add(new FourWheelerParkingSpot(1,10));
        fourWheelParkingSpots.add(new FourWheelerParkingSpot(2,10));
        fourWheelParkingSpots.add(new FourWheelerParkingSpot(3,10));

        parkingSpots.addAll(twoWheelParkingSpots);
        parkingSpots.addAll(fourWheelParkingSpots);

        ParkingManagerFactory factory = new ParkingManagerFactory();
        EntranceGateA entryGateA = new EntranceGateA(factory);

        ExitGateA exitGateA = new ExitGateA();

        Vehicle vehicle = new Vehicle(324, VehicleType.FOUR_WHEELER);
        Vehicle vehicle1 = new Vehicle(122, VehicleType.TWO_WHEELER);
        Vehicle vehicle2 = new Vehicle(432, VehicleType.TWO_WHEELER);
        Vehicle vehicle3 = new Vehicle(143, VehicleType.FOUR_WHEELER);

        try{
            entryGateA.findSpaceAndPark(vehicle, parkingSpots);
            entryGateA.findSpaceAndPark(vehicle1, parkingSpots);
            entryGateA.findSpaceAndPark(vehicle2, parkingSpots);
            entryGateA.findSpaceAndPark(vehicle3, parkingSpots);
        }
        catch(ParkingSpaceNotFoundException | InvalidVehicleTypeException exception){
            System.out.println(exception.getMessage());
        }



    }


}

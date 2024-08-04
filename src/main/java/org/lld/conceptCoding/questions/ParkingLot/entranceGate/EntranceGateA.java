package org.lld.conceptCoding.questions.ParkingLot.entranceGate;

import org.joda.time.DateTime;
import org.lld.conceptCoding.questions.ParkingLot.exceptions.InvalidVehicleTypeException;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;
import org.lld.conceptCoding.questions.ParkingLot.exceptions.ParkingSpaceNotFoundException;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager.ParkingManagerFactory;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager.ParkingSpotManager;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.parking.ticket.Ticket;

import java.util.List;

public class EntranceGateA implements Entrance {
    ParkingManagerFactory parkingManagerFactory;
    ParkingSpotManager parkingSpotManager;
    public EntranceGateA(ParkingManagerFactory parkingManagerFactory) {
        this.parkingManagerFactory = parkingManagerFactory;
    }
    @Override
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new Ticket(DateTime.now(), vehicle, parkingSpot);
    }
    @Override
    public ParkingSpot findSpaceAndPark(Vehicle vehicle, List<ParkingSpot> parkingSpots) throws ParkingSpaceNotFoundException, InvalidVehicleTypeException {
        parkingSpotManager = parkingManagerFactory.getVehicleTypeManager(vehicle.getVehicleType(), parkingSpots);
        ParkingSpot spot = parkingSpotManager.findParkingSpot(vehicle);
        if(spot == null){
            throw new ParkingSpaceNotFoundException("Could Not Find Parking Spot");
        }
        return spot;
    }
}

package org.lld.conceptCoding.questions.ParkingLot.entranceGate;

import org.lld.conceptCoding.questions.ParkingLot.exceptions.InvalidVehicleTypeException;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;
import org.lld.conceptCoding.questions.ParkingLot.exceptions.ParkingSpaceNotFoundException;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot.ParkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.parking.ticket.Ticket;

import java.util.List;

public interface Entrance {
    Ticket generateTicket(org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle vehicle, ParkingSpot parkingSpot);
    ParkingSpot findSpaceAndPark(Vehicle vehicle, List<ParkingSpot> parkingSpots) throws ParkingSpaceNotFoundException, InvalidVehicleTypeException;
}

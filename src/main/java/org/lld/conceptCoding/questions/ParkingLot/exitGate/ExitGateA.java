package org.lld.conceptCoding.questions.ParkingLot.exitGate;

import org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager.ParkingManagerFactory;
import org.lld.conceptCoding.questions.ParkingLot.parking.parkingManager.ParkingSpotManager;
import org.lld.conceptCoding.questions.ParkingLot.parking.ticket.Ticket;

public class ExitGateA implements Exit{
    CostComputerFactory costComputerFactory;
    ParkingManagerFactory parkingManagerFactory;
    @Override
    public Integer computeCost(Ticket ticket) {
//        parkingManagerFactory.getVehicleTypeManager(ticket.getVehicle(), )
        return null;
    }
}

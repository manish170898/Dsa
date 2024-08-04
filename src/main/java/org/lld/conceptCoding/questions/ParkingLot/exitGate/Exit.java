package org.lld.conceptCoding.questions.ParkingLot.exitGate;

import org.lld.conceptCoding.questions.ParkingLot.parking.ticket.Ticket;

public interface Exit {
    Integer computeCost(Ticket ticket);
}

package org.lld.conceptCoding.questions.ParkingLot.exitGate.pricingStrategy;

import org.lld.conceptCoding.questions.ParkingLot.parking.ticket.Ticket;

public interface PricingStrategy {
    Integer price(Ticket ticket);
}

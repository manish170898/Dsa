package org.lld.conceptCoding.questions.ParkingLot.exitGate;

import org.lld.conceptCoding.questions.ParkingLot.exitGate.pricingStrategy.PricingStrategy;
import org.lld.conceptCoding.questions.ParkingLot.parking.ticket.Ticket;

public class FourWheelerComputer extends CostComputer{
    public FourWheelerComputer(PricingStrategy strategy) {
        super(strategy);
    }

//    @Override
//    public Integer compute(Ticket ticket) {
//        return null;
//    }
}

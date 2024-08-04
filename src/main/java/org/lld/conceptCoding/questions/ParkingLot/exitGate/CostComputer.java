package org.lld.conceptCoding.questions.ParkingLot.exitGate;

import org.lld.conceptCoding.questions.ParkingLot.exitGate.pricingStrategy.PricingStrategy;
public abstract class CostComputer {
    PricingStrategy strategy;
    public CostComputer(PricingStrategy strategy) {
        this.strategy = strategy;
    }
}

package org.lld.conceptCoding.designPatterns.strategy;

import org.lld.conceptCoding.designPatterns.strategy.driveStrategies.DriveStrategy;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle(DriveStrategy strategy) {
        super(strategy);
    }
}

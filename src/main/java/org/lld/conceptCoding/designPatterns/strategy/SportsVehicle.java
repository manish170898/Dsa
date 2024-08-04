package org.lld.conceptCoding.designPatterns.strategy;

import org.lld.conceptCoding.designPatterns.strategy.driveStrategies.DriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle(DriveStrategy strategy) {
        super(strategy);
    }
}

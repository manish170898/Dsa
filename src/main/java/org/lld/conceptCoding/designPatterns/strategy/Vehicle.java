package org.lld.conceptCoding.designPatterns.strategy;

import org.lld.conceptCoding.designPatterns.strategy.driveStrategies.DriveStrategy;

public class Vehicle {
    DriveStrategy strategy;
    public Vehicle(DriveStrategy strategy) {
        this.strategy = strategy;
    }
    public void drive(){
        strategy.drive();
    }
}

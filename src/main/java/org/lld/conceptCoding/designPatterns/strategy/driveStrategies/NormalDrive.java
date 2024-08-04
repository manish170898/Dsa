package org.lld.conceptCoding.designPatterns.strategy.driveStrategies;

public class NormalDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("This is a normal strategy");
    }
}

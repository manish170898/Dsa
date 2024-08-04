package org.lld.conceptCoding.designPatterns.strategy.driveStrategies;

public class SportsStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("This is sports strategy");
    }
}

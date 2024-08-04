package org.lld.conceptCoding.designPatterns.strategy;

import org.lld.conceptCoding.designPatterns.strategy.driveStrategies.NormalDrive;
import org.lld.conceptCoding.designPatterns.strategy.driveStrategies.SportsStrategy;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(new SportsStrategy());
        vehicle.drive();
    }
}

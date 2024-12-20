package org.lld.old.designPatterns.AdapterDP;

import java.util.Random;

public class EnemyTank implements EnemyAttacker {

    Random generator = new Random();

    @Override
    public void fireWeapon() {
        int attackDamage = generator.nextInt(10)+ 1;
        System.out.println("enemyTankDoes" + attackDamage);
    }

    @Override
    public void driveForward() {
        int movement = generator.nextInt(5)+1;
        System.out.println("enemyTagMoves"+ movement);
    }

    @Override
    public void assignDriver(String driverName) {
        System.out.println(driverName + "driving");
    }
}

package org.lld.old.designPatterns.AdapterDP;

import java.util.Random;

public class EnemyRobot {
    Random generaotr = new Random();

    public void smashWithHands(){
        int attackDamage = generaotr.nextInt(10)+1;
        System.out.println("Damage caused" + attackDamage);
    }

    public void walkForward(){
        int movement = generaotr.nextInt(5)+1;
        System.out.println("moves " + movement);
    }

    public void reactTohuman(String driverName){
        System.out.println("driver is crushed to death" + driverName);
    }

}

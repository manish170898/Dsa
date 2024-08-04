package org.lld.old.designPatterns.FactoryDP;

import java.util.Scanner;

public class EnemyShipTesting {
    public static void main(String[] args){

        EnemyShipFactory factory = new EnemyShipFactory();
        EnemyShip enemyShip= null;

        Scanner userInput = new Scanner(System.in);
        String typeOfShip;
        System.out.println("Why type of ship? (U / R/ B)");
        if(userInput.hasNextLine()){
            typeOfShip = userInput.nextLine();
            enemyShip = factory.makeEnemyShip(typeOfShip);
        }
        doStuddEnemy(enemyShip);
    }

    public static void doStuddEnemy(EnemyShip enemyShip){
        enemyShip.displayEnemyShip();
        enemyShip.followHeroShip();
        enemyShip.enemyShipShoots();
    }
}

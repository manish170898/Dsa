package org.lld.old.designPatterns.FactoryDP;

public class EnemyShipFactory {
    public EnemyShip makeEnemyShip(String newShipType){
        EnemyShip enemyShip = null;
        if(newShipType.equals("U")){
            return new UFOEnemyShip();
        }
        else if(newShipType.equals("B")){
            return new BigUFOEnemyShip();
        }
        else if(newShipType.equals("R")){
            return new RocketEnemyShip();
        }
        else
            return null;
    }
}

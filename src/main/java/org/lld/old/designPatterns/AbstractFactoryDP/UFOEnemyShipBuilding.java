package org.lld.old.designPatterns.AbstractFactoryDP;//package AbstractFactoryDP;
//
//
//
//public class UFOEnemyShipBuilding extends EnemyShipBuilding {
//    @Override
//    protected EnemyShip makeEnemyShip(String typeOfShip) {
//        EnemyShip enemyShip = null;
//        if(typeOfShip.equals("UFO")){
//            EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
//            enemyShip = new UFOEnemyShip(shipPartsFactory);
//            enemyShip.setName("UFO Grunt Ship");
//        }
//        else if(typeOfShip.equals("UFO BOSS")){
//            EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
//            enemyShip = new UFOBossEnemyShip(shipPartsFactory);
//            enemyShip.setName("UFO Grunt Ship");
//        }
//        return enemyShip;
//    }
//}

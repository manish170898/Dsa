package org.lld.old.designPatterns.FactoryDP;

public abstract class EnemyShip {
    private String name;
    private double amtDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHeroShip(){
        System.out.println(getName() + "is following the hero");
    }

    public void displayEnemyShip(){
        System.out.println(getName() + "is onScreen");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + "attacks and does" + getAmtDamage());
    }

}

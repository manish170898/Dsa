package org.lld.old.designPatterns.DecoratorDP;

public class Mozerella extends ToppingDecorator{

    public Mozerella(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding Moz");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ",Mozerella";
    }

    public double getCost(){
        return tempPizza.getCost() + .50;
    }
}

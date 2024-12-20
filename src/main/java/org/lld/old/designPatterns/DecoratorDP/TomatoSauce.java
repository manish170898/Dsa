package org.lld.old.designPatterns.DecoratorDP;

public class TomatoSauce extends ToppingDecorator{
    public TomatoSauce(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding Tomato Sauce");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ",TomatoSauce";
    }

    public double getCost(){
        return tempPizza.getCost() + .35;
    }
}

package org.lld.old.designPatterns.DecoratorDP;

public class PizzaMaker {
    public static void main(String[] args){
        Pizza pizza = new TomatoSauce(new Mozerella(new PlainPizza()));
    }
}

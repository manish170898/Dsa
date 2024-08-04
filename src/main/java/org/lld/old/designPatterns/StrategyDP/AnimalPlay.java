package org.lld.old.designPatterns.StrategyDP;

public class AnimalPlay {
    public static void main(String[] args) {
        Animal sparky = new Dog();
        Animal tweety = new Bird();
        System.out.println(sparky.getFlyType());

        sparky.setFlyType(new ItFlys());
        System.out.println(sparky.getFlyType());
    }
}

package org.lld.old.designPatterns.StrategyDP;

public class Bird extends Animal {
    public Bird() {
        super();
        setSound("Tweet");

        flyType = new ItFlys();
    }
}

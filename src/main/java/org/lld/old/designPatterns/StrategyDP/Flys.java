package org.lld.old.designPatterns.StrategyDP;
// Also knows as decoupling as we are encapsulationg a behavior that varies
public interface Flys {
    String fly();
}

class ItFlys implements Flys{

    @Override
    public String fly() {
        return "Flying High";
    }
}

class CantFly implements Flys {

    @Override
    public String fly() {
        return "Cant Fly";
    }
}

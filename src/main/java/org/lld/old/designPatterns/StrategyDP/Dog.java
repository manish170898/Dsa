package org.lld.old.designPatterns.StrategyDP;

public class Dog extends Animal{
    public void digHole(){
        System.out.println("Dug a hole");
    }

    public Dog(){
        super();
        setSound("Bark");
        flyType = new CantFly();
    }

    //WRONG CODE
//    public void fly(){
//        System.out.println("cant fly");
//    }
}

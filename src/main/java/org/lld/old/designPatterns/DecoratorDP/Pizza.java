package org.lld.old.designPatterns.DecoratorDP;

//public abstract class Pizza {
//    public abstract void setDescription(String newDescription);
//    public abstract String getDescription();
//    public abstract double getCost();
//    public abstract boolean hasFontina();
//}

public interface Pizza {
    public String getDescription();
    public double getCost();
}
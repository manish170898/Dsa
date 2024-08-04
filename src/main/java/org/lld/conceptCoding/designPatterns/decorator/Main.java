package org.lld.conceptCoding.designPatterns.decorator;

import org.lld.conceptCoding.designPatterns.decorator.pizza.BasePizza;
import org.lld.conceptCoding.designPatterns.decorator.pizza.FarmHouse;
import org.lld.conceptCoding.designPatterns.decorator.toppings.Mushroom;
import org.lld.conceptCoding.designPatterns.decorator.toppings.Paneer;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new FarmHouse();
        pizza = new Paneer(pizza);
        pizza = new Mushroom(pizza);

        System.out.println(pizza.cost());
    }
}

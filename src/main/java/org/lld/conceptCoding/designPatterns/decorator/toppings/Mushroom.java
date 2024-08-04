package org.lld.conceptCoding.designPatterns.decorator.toppings;

import org.lld.conceptCoding.designPatterns.decorator.pizza.BasePizza;

public class Mushroom extends Toppings{
    BasePizza pizza;
    public Mushroom(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 20;
    }
}

package org.lld.conceptCoding.designPatterns.decorator.toppings;

import org.lld.conceptCoding.designPatterns.decorator.pizza.BasePizza;

public class Paneer extends Toppings{
    BasePizza pizza;
    public Paneer(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 50;
    }
}

package org.lld.conceptCoding.designPatterns.factory.shapes;

public class Circle implements Shapes{
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

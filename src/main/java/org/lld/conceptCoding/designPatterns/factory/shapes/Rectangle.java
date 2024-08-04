package org.lld.conceptCoding.designPatterns.factory.shapes;

public class Rectangle implements Shapes {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

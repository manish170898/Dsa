package org.lld.conceptCoding.designPatterns.factory;

import org.lld.conceptCoding.designPatterns.factory.shapes.Shapes;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shapes shape = factory.getShapes("Circle");
        shape.draw();
    }
}

package org.lld.conceptCoding.designPatterns.factory;

import org.lld.conceptCoding.designPatterns.factory.shapes.Circle;
import org.lld.conceptCoding.designPatterns.factory.shapes.Rectangle;
import org.lld.conceptCoding.designPatterns.factory.shapes.Shapes;

public class ShapeFactory {
    Shapes getShapes(String input){
        switch (input) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            default:return null;
        }
    }

}

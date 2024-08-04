package org.lld.old.solid.interfaceSegregation;

//public interface Shape {
//    double calculateArea();
//    double calculateVolume();
//}
//
//class Cuboid implements Shape {
//
//    @Override
//    public double calculateArea() {
//        return 0;
//    }
//
//    @Override
//    public double calculateVolume() {
//        return 0;
//    }
//}
//// Square needs to unnecessoroly implement volume method as it is a2D figure
//class Square implements Shape {
//
//    @Override
//    public double calculateArea() {
//        return 0;
//    }
//
//    @Override
//    public double calculateVolume() {
//        return 0;
//    }
//}



//Solution
//Solution
interface ThreeDimentional {
    double calculateVolume();
}

interface TwoDimentional {
    double calculateArea();
}

class Cuboid implements ThreeDimentional,TwoDimentional {

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double calculateVolume() {
        return 0;
    }
}

class Square implements TwoDimentional {

    @Override
    public double calculateArea() {
        return 0;
    }
}
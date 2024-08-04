package org.lld.old.solid.liskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    public void startEngine(){

    }
}

class Car extends Vehicle{
    @Override
    public void startEngine(){

    }
}

class Bycle extends Vehicle{
    @Override
    public void startEngine(){
//        throw new EngineNotFoundException("Engine Missing");
    }
}

class VehicleMonitor{
    public void startVehicles(){
        List<Vehicle> vehicles =  new ArrayList<Vehicle>();
        Vehicle car =new Car();
        Vehicle cycle = new Bycle();

        vehicles.add(car);
        vehicles.add(cycle);

        vehicles.forEach(vahicle -> vahicle.startEngine());
    }
}

// Problem is that cycle does not have a engine, child cant perform same thing as parent
// Solution is that

// Suppose vehicle -> vehicleWithEngine , vehicleWithoutEngine
//                      startEngine         startMoving
//                          car                 bicycle




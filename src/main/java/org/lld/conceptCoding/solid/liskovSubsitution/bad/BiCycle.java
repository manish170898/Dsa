package org.lld.conceptCoding.solid.liskovSubsitution.bad;

public class BiCycle implements Vehicle {
    //Here capability is narrowed down
//    if we replace an object of Morotcycle here we might run into errors
    @Override
    public void turnOnEngine() throws Exception {
        throw new Exception("Bike Dones not have Engine");
    }

    @Override
    public void acclerate() {

    }
}

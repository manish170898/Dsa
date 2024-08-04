package org.lld.conceptCoding.questions.ParkingLot.vehicle;

public class Vehicle {
    private final Integer number;
    private final VehicleType vehicleType;
    public Vehicle(Integer number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }
    public Integer getNumber() {
        return number;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

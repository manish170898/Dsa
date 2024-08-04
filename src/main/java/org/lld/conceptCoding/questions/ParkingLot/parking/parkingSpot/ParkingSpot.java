package org.lld.conceptCoding.questions.ParkingLot.parking.parkingSpot;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final Integer id;
    private Boolean isEmpty;
    private Vehicle vehicle;
    private final Integer price;

    public ParkingSpot(Integer id, Integer price) {
        this.id = id;
        this.price = price;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isEmpty = false;
    }
    public void removeVehicle(){
        this.vehicle = null;
        this.isEmpty = true;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Integer getPrice() {
        return price;
    }
}

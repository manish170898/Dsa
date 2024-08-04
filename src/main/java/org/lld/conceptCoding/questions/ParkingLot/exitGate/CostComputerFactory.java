package org.lld.conceptCoding.questions.ParkingLot.exitGate;

import org.lld.conceptCoding.questions.ParkingLot.exceptions.InvalidVehicleTypeException;
import org.lld.conceptCoding.questions.ParkingLot.exitGate.pricingStrategy.HourlyPriceStrategy;
import org.lld.conceptCoding.questions.ParkingLot.exitGate.pricingStrategy.MinutelyPriceStrategy;
import org.lld.conceptCoding.questions.ParkingLot.exitGate.pricingStrategy.PricingStrategy;
import org.lld.conceptCoding.questions.ParkingLot.parking.ticket.Ticket;
import org.lld.conceptCoding.questions.ParkingLot.vehicle.VehicleType;

import java.util.List;

public class CostComputerFactory {
    public CostComputer getVehicleTypeComputer(Ticket ticket) throws InvalidVehicleTypeException {
        if(ticket.getVehicle().equals(VehicleType.TWO_WHEELER)){
            PricingStrategy strategy = new HourlyPriceStrategy();
            return new TwoWheelerComputer(strategy);
        }
        else if(ticket.getVehicle().equals(VehicleType.FOUR_WHEELER)){
            PricingStrategy strategy = new MinutelyPriceStrategy();
            return new FourWheelerComputer(strategy);
        }
        else{
            throw new InvalidVehicleTypeException("Vehicle is neither Two Wheeler nor Four Wheeler");
        }
    }
}

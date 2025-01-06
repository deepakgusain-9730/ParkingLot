package models;

import enums.ParkingLotStatus;
import enums.SlotAssignedStrategyType;
import enums.VehicleTypes;

import java.util.List;

public class ParkingLot extends BaseModel{

    private List<ParkingFloor> parkingFloors;

    private List<Gate> gates;

    private List<VehicleTypes> vehicleTypes;

    private ParkingLotStatus parkingLotStatus;


    private SlotAssignedStrategyType slotAssignedStrategyType;


    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleTypes> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleTypes> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public SlotAssignedStrategyType getSlotAssignedStrategyType() {
        return slotAssignedStrategyType;
    }

    public void setSlotAssignedStrategyType(SlotAssignedStrategyType slotAssignedStrategyType) {
        this.slotAssignedStrategyType = slotAssignedStrategyType;
    }
}

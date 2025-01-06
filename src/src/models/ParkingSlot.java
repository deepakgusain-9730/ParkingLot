package models;

import enums.ParkingSlotsStatus;
import enums.VehicleTypes;

public class ParkingSlot extends BaseModel{

    private int number;

    private ParkingSlotsStatus parkingSlotsStatus;

    private VehicleTypes vehicleType;

    private ParkingFloor parkingFloor;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ParkingSlotsStatus getParkingSlotsStatus() {
        return parkingSlotsStatus;
    }

    public void setParkingSlotsStatus(ParkingSlotsStatus parkingSlotsStatus) {
        this.parkingSlotsStatus = parkingSlotsStatus;
    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}

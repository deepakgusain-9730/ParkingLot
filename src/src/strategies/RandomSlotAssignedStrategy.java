package strategies;

import enums.VehicleTypes;
import models.Gate;
import models.ParkingSlot;

public class RandomSlotAssignedStrategy implements SlotAssignedStrategy {

    @Override
    public ParkingSlot assignSlot(Gate gate, VehicleTypes vehicleType) {
        ParkingSlot parkingSlot = new ParkingSlot();
        return parkingSlot;
    }

}

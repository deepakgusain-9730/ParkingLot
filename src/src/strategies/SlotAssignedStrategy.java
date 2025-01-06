package strategies;

import enums.VehicleTypes;
import models.Gate;
import models.ParkingSlot;

public interface SlotAssignedStrategy {
    public ParkingSlot assignSlot(Gate gate, VehicleTypes vehicleType);
}

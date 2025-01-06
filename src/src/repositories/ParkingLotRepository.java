package repositories;

import models.Gate;
import models.ParkingLot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();
    private static long parkingLotId = 0;
    public ParkingLot getParkingLotByGate(Gate gate) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if(parkingLot.getGates().contains(gate))
                return parkingLots.get(parkingLot.getId());

        }
        return null;
    }

    public ParkingLot saveParkingLot(ParkingLot parkingLot) {
        parkingLotId += 1;
        parkingLot.setId(parkingLotId);
        parkingLots.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}

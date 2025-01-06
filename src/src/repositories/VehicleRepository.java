package repositories;

import models.Vehicle;


import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {

    Map<String, Vehicle> vehicles = new TreeMap<>();
    private static long vehicleId = 0;

    public Optional<Vehicle> getVehicleByNumber(String number) {
        if (vehicles.containsKey(number)) {
            return Optional.of(vehicles.get(number));
        }
        return Optional.empty();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleId += 1;
        vehicle.setId(vehicleId);
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
}

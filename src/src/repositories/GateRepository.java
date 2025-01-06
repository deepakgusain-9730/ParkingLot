package repositories;

import models.Gate;
import models.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();

    private static long gateId = 0;

    public Optional<Gate> findGateById(Long gateId){
//        Optional helps you to handle null pointer exception
        if (gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }

    public Gate saveGate(Gate gate){
        gateId += 1;
        gate.setId(gateId);
        gates.put(gate.getId(), gate);
        return gate;
    }
}

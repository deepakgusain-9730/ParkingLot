package services;

import enums.SlotAssignedStrategyType;
import enums.VehicleTypes;
import exceptions.RecordNotFoundException;
import factory.SlotAssignedStrategyFactory;
import models.Gate;
import models.ParkingSlot;
import models.Ticket;
import models.Vehicle;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.SlotAssignedStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                  VehicleRepository vehicleRepository,
                  ParkingLotRepository parkingLotRepository,
    TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;

    }
    public Ticket issueTicket(String vehicleNumber,
                              Long gateId,
                              String vehicleOwnerName,
                              VehicleTypes vehicleType)
    throws RecordNotFoundException{
//  Create a ticket object
//        Assign a spot
//        Return the ticket
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
//        Setting the gate
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new RecordNotFoundException("Gate id not found " + gateId);
        }
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

//        Setting the vehicle
        Vehicle saveVehicle;
        Optional<Vehicle> vehicleOptional= vehicleRepository.getVehicleByNumber(vehicleNumber);
        if (vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
            vehicle.setVehicleType(vehicleType);
            saveVehicle = vehicleRepository.addVehicle(vehicle);
        }else{
            saveVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(saveVehicle);

//        Get parking lot strategy

        SlotAssignedStrategyType slotAssignedStrategyType =
                parkingLotRepository.getParkingLotByGate(gate
                ).getSlotAssignedStrategyType();

        SlotAssignedStrategy slotAssignedStrategy = SlotAssignedStrategyFactory.getSlotAssignedStrategy(slotAssignedStrategyType);
        ParkingSlot parkingSlot = slotAssignedStrategy.assignSlot(gate, vehicleType);
        ticket.setParkingSlot(parkingSlot);
        Ticket saveTicket = ticketRepository.saveTicket(ticket);
        saveTicket.setTicketNumber("Ticket -" + saveTicket.getId());
        return saveTicket;

    }
}

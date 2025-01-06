import controllers.TicketController;
import dto.IssueTicketRequestDto;
import dto.IssueTicketResponseDto;
import enums.*;
import models.Gate;
import models.ParkingLot;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotApplication {
    public static void main(String[] args) {

//        Creating Dependency injection

//        Creating registry objects
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

//        Creating service object

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

//        Creating controller
        TicketController ticketController = new TicketController(ticketService);

//        Create gate object
        Gate gate = new Gate();
        gate.setGate_number(1);
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateType(GateType.ENTRY);
        gateRepository.saveGate(gate);

//        creating parking lot object
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        List<Gate> gateObjects = new ArrayList<>();
        gateObjects.add(gate);
        parkingLot.setGates(gateObjects);
        parkingLot.setSlotAssignedStrategyType(SlotAssignedStrategyType.RANDOM);
        parkingLotRepository.saveParkingLot(parkingLot);


//        Creating request dto
        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setVehicleNumber("uk15123");
        issueTicketRequestDto.setGateId(gate.getId());
        issueTicketRequestDto.setVehicleOwnerName("Deepak gusain");
        issueTicketRequestDto.setVehicleType(VehicleTypes.CAR);

        IssueTicketResponseDto issueTicketResponseDto = ticketController.issueTicket(issueTicketRequestDto);

        System.out.println(issueTicketResponseDto.getMessage());

        }
}

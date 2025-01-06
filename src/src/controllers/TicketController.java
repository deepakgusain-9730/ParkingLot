package controllers;

import dto.IssueTicketRequestDto;
import dto.IssueTicketResponseDto;
import enums.ResponseType;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getVehicleOwnerName(),
                    issueTicketRequestDto.getVehicleType());
            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setMessage("Successfully Issued Ticket");
            issueTicketResponseDto.setResponse(ResponseType.SUCCESS);
        }
        catch (Exception e) {
            issueTicketResponseDto.setMessage("Issue has appeared: " + e.getMessage());
            issueTicketResponseDto.setResponse(ResponseType.FAILURE);
        }
        return issueTicketResponseDto;

    }
}

// needs to interact with the client.
//validations on the input
//Call the service and provide it with the inputs.
//Receive the output from service and send it over to the client in a proper format dto.

package repositories;

import models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private static long ticketId = 0;

    public Ticket saveTicket(Ticket ticket) {
        ticketId += 1;
        ticket.setId(ticketId);
        tickets.put(ticketId, ticket);
        return ticket;
    }
}

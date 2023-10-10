package br.com.bilheteriacinema.services;

import br.com.bilheteriacinema.models.Ticket;
import br.com.bilheteriacinema.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public Collection<Ticket> getAllTickets() {
        System.out.println("Chamou o getAllTicket");
        return (Collection<Ticket>) ticketRepository.findAll();
    }

   public List<Ticket> getTicketsById(Integer id) {
       System.out.println("Chamou o getTicketById");

       return  ticketRepository.findTicketsByUserId(id);

   }

    public void addTicket(Ticket ticket) {
        System.out.println("Passou no addTicket");
        ticketRepository.save(ticket);
    }

    public void deleteById(Integer id) {
        System.out.println("Passou no deleteById Ticket" + id);
        ticketRepository.deleteById(id);
    }

}

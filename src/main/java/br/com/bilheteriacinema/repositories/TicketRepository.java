package br.com.bilheteriacinema.repositories;

import br.com.bilheteriacinema.models.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

//    @Query("from TTicket t where t.user.id = :user_id ")
//    public List<Ticket> getTicketsById(Integer userid);

}

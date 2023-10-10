package br.com.bilheteriacinema.repositories;

import br.com.bilheteriacinema.models.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.user.id = :userId")
    List<Ticket> findTicketsByUserId(@Param("userId") Integer userId);

}

package br.com.bilheteriacinema;

import br.com.bilheteriacinema.models.*;
import br.com.bilheteriacinema.services.FeatureFilmService;
import br.com.bilheteriacinema.services.TicketService;
import br.com.bilheteriacinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.*;

@Order(4)
@Component
public class TicketLoader implements ApplicationRunner {

    @Autowired
    FeatureFilmService featureFilmService;

    @Autowired
    UserService userService;

    @Autowired
    TicketService ticketService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<FeatureFilm> listFilms = (List<FeatureFilm>) featureFilmService.getAllFeaturesFilm();
        List<User> listUsers = (List<User>)  userService.getAllUsers();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date1 = format.parse("25/10/2023 20:30");

        Ticket ticket1 = new Ticket(
                listFilms.get(0),
                listUsers.get(0),
                date1,
                30.00
        );

        ticketService.addTicket(ticket1);

        Date date2 = format.parse("27/10/2023 19:00");

        Ticket ticket2 = new Ticket(
                listFilms.get(1),
                listUsers.get(0),
                date2,
                25.00
        );

        ticketService.addTicket(ticket2);

        for (Ticket t : ticketService.getAllTickets()) {
            System.out.println("Ticket Inclusão realizada: " + t.getUser() + "sessão: " + t.getsessionDate() + "preço: " + t.getPrice());
        }
    }

}

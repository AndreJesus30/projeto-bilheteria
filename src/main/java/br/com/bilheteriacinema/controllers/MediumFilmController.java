package br.com.bilheteriacinema.controllers;
import br.com.bilheteriacinema.models.MediumFilm;
import br.com.bilheteriacinema.models.Ticket;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.MediumFilmService;
import br.com.bilheteriacinema.services.TicketService;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
public class MediumFilmController {


    @Autowired
    TicketService ticketService;

    @Autowired
    MediumFilmService mediumFilmService;

    List<Ticket> fakeScheduleMediumFilm = new ArrayList<Ticket>();


    @GetMapping("/medium-film/register")
    public String registerMediumFilm() {
        return "medium_film/register";
    }

    @PostMapping("/medium-film/add")
    public String addMediumFilm(MediumFilm mediumFilm) {

        mediumFilmService.addMediumFilm(mediumFilm);

        return "redirect:/medium-film/list";
    }

    @GetMapping("/medium-film/list")
    public String getList(Model model) {

        model.addAttribute("mediumList", mediumFilmService.getAllMediumFilm());

        return "medium_film/list";
    }

    @GetMapping("/medium-film/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        mediumFilmService.deleteById(id);

        return  "redirect:/medium-film/list";
    }

    @GetMapping("/medium-film/{id}/schedule")
    public String scheduleFeatureFilm(Model model, @PathVariable Integer id) throws ParseException {

       fakeScheduleMediumFilm = mediumFilmService.generateFakeSchedule(id);

        model.addAttribute("fakeScheduleMediumFilm", fakeScheduleMediumFilm);

        return "medium_film/schedule";
    }

    @GetMapping("/medium-film/{id}/buy")
    public String buyMediumFilm(@PathVariable Integer id, @SessionAttribute("currentUser") User currentUser, HttpSession session) throws ParseException {

        Ticket linefakeShechule = fakeScheduleMediumFilm.get(id-1);

        Ticket newTicket = new Ticket(
            linefakeShechule.getFilm(), 
            currentUser,
            linefakeShechule.getsessionDate(), 
            linefakeShechule.getPrice()
            );        

        ticketService.addTicket(newTicket);
        
        return "redirect:/tickets/list";
    }

}

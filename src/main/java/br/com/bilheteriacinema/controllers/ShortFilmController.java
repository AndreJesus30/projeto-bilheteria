package br.com.bilheteriacinema.controllers;

import br.com.bilheteriacinema.models.ShortFilm;
import br.com.bilheteriacinema.models.Ticket;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.ShortFilmService;
import br.com.bilheteriacinema.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
public class ShortFilmController {

    @Autowired
    TicketService ticketService;

    @Autowired
    ShortFilmService shortFilmService;

    List<Ticket> fakeScheduleShortFilm = new ArrayList<Ticket>();

    @GetMapping("/short-film/register")
    public String registerShortFilm() {
        return "short_film/register";
    }

    @PostMapping("/short-film/add")
    public String addShortFilm(ShortFilm shortFilm) {

        shortFilmService.addShortFilm(shortFilm);

        return "redirect:/short-film/list";
    }

    @GetMapping("/short-film/list")
    public String getList(Model model) {

        model.addAttribute("shortList", shortFilmService.getAllShortFilm());

        return "short_film/list";
    }

    @GetMapping("/short-film/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        shortFilmService.deleteById(id);

        return  "redirect:/short-film/list";
    }

        @GetMapping("/short-film/{id}/schedule")
    public String scheduleFeatureFilm(Model model, @PathVariable Integer id) throws ParseException {

       fakeScheduleShortFilm = shortFilmService.generateFakeSchedule(id);

        model.addAttribute("fakeScheduleShortFilm", fakeScheduleShortFilm);

        return "short_film/schedule";
    }

    @GetMapping("/short-film/{id}/buy")
    public String buyShortFilm(@PathVariable Integer id, @SessionAttribute("currentUser") User currentUser, HttpSession session) throws ParseException {

        Ticket linefakeShechule = fakeScheduleShortFilm.get(id-1);

        Ticket newTicket = new Ticket(
            linefakeShechule.getFilm(), 
            currentUser,
            linefakeShechule.getsessionDate(), 
            linefakeShechule.getPrice()
            );        

        ticketService.addTicket(newTicket);
        
        return "redirect:/tickets/list";
    }

     @GetMapping("/short-film/{id}/edit")
        public String editShortFilm(Model model, @PathVariable Integer id) {

        ShortFilm shortFilm = shortFilmService.getByIdShortFilm(id).orElse(null);

        if(shortFilm != null) {
            model.addAttribute("shortFilm", shortFilm);
            return "short_film/edit_short_film";

        }

        return "redirect:/short-film/list";
    }

    @PostMapping("/short-film/edited_short")
        public String editedShortFilm(ShortFilm shortFilm) {

        shortFilmService.editShortFilm(shortFilm);

        return "redirect:/short-film/list";
    }

}

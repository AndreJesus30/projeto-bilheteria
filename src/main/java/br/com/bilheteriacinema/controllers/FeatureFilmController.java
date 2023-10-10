package br.com.bilheteriacinema.controllers;

import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.models.Ticket;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.FeatureFilmService;
import br.com.bilheteriacinema.services.TicketService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;



@SessionAttributes("currentUser")
@Controller
public class FeatureFilmController {

    @Autowired
    TicketService ticketService;

    @Autowired
    FeatureFilmService featureFilmService;

    List<Ticket> fakeScheduleFeatureFilm = new ArrayList<Ticket>();

    @GetMapping("/feature-film/register")
    public String registerFeatureFilm() {
        return "feature_film/register";
    }

    @PostMapping("/feature-film/add")
    public String addFeatureFilm(FeatureFilm featureFilm) {

        featureFilmService.addFeatureFilm(featureFilm);

        return "redirect:/feature-film/list";
    }

    @GetMapping("/feature-film/list")
    public String getList(Model model) {

        model.addAttribute("featureList", featureFilmService.getAllFeaturesFilm());

        return "feature_film/list";
    }

    @GetMapping("/feature-film/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        featureFilmService.deleteById(id);

        return  "redirect:/feature-film/list";
    }

    @GetMapping("/feature-film/{id}/schedule")
    public String scheduleFeatureFilm(Model model, @PathVariable Integer id) throws ParseException {

       fakeScheduleFeatureFilm = featureFilmService.generateFakeSchedule(id);

        model.addAttribute("fakeScheduleFeatureFilm", fakeScheduleFeatureFilm);

        return "feature_film/schedule";
    }

    @GetMapping("/feature-film/{id}/buy")
    public String buyFeatureFilm(@PathVariable Integer id, @SessionAttribute("currentUser") User currentUser, HttpSession session) throws ParseException {

        Ticket linefakeShechule = fakeScheduleFeatureFilm.get(id-1);

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

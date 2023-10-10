package br.com.bilheteriacinema.controllers;

import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets/list")
    public String getList(Model model,  @SessionAttribute("currentUser") User currentUser) {

       if(currentUser.getEmail().equalsIgnoreCase("admin@admin.com")) {
           model.addAttribute("ticketsList", ticketService.getAllTickets());
       } else {
         model.addAttribute("ticketsList", ticketService.getTicketsById(currentUser.getId()));
       }


        return "ticket/list";
    }

    @GetMapping("/ticket/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        ticketService.deleteById(id);

        return  "redirect:/tickets/list";
    }

}

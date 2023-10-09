package br.com.bilheteriacinema.controllers;

import br.com.bilheteriacinema.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets/list")
    public String getList(Model model) {

        model.addAttribute("ticketsList", ticketService.getAllTickets());

        return "ticket/list";
    }

    @GetMapping("/ticket/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        ticketService.deleteById(id);

        return  "redirect:/tickets/list";
    }

}

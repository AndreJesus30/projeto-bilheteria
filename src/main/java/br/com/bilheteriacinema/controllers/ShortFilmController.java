package br.com.bilheteriacinema.controllers;

import br.com.bilheteriacinema.models.ShortFilm;
import br.com.bilheteriacinema.models.ShortFilm;
import br.com.bilheteriacinema.services.ShortFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ShortFilmController {

    @Autowired
    ShortFilmService shortFilmService;

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

}

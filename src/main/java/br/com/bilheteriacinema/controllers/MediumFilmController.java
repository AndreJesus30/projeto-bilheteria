package br.com.bilheteriacinema.controllers;
import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.models.MediumFilm;
import br.com.bilheteriacinema.services.MediumFilmService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MediumFilmController {

//    public Map<Integer, MediumFilm> mapMediumFilm = new HashMap<Integer, MediumFilm>();
//
//    public void add(Integer code, MediumFilm mediumFilm) {
//        mapMediumFilm.put(code, mediumFilm);
//    }

    @Autowired
    MediumFilmService mediumFilmService;

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
//
//    @GetMapping("/login")
//    public String viewLogin() {
//        return "login";
//    }
//
//    @GetMapping("/logout")
//    public String viewLogout(HttpSession session, SessionStatus status) {
//
//        status.setComplete();
//        session.removeAttribute("user");
//
//        return "redirect:/";
//    }


}

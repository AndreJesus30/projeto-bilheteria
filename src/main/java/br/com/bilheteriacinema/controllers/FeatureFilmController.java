package br.com.bilheteriacinema.controllers;

import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.services.FeatureFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FeatureFilmController {

    @Autowired
    FeatureFilmService featureFilmeService;

    @GetMapping("/feature-film/register")
    public String registerFeatureFilm() {
        return "feature_film/register";
    }

    @PostMapping("/feature-film/add")
    public String addFeatureFilm(FeatureFilm featureFilm) {

        featureFilmeService.addFeatureFilm(featureFilm);

        return "redirect:/feature-film/list";
    }

    @GetMapping("/feature-film/list")
    public String getList(Model model) {

        model.addAttribute("featureList", featureFilmeService.getAllFeaturesFilm());

        return "feature_film/list";
    }

    @GetMapping("/feature-film/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        featureFilmeService.deleteById(id);

        return  "redirect:/feature-film/list";
    }



}

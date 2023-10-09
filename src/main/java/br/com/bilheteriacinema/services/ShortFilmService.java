package br.com.bilheteriacinema.services;

import br.com.bilheteriacinema.models.ShortFilm;
import br.com.bilheteriacinema.repositories.ShortFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShortFilmService {

    @Autowired
    ShortFilmRepository shortFilmRepository;

    public Collection<ShortFilm> getAllShortFilm() {
        System.out.println("Passou no getAllFeaturesFilm");
        return (Collection<ShortFilm>) shortFilmRepository.findAll();
    }

    public void addShortFilm(ShortFilm shortFilm) {
        System.out.println("Passou no addFeatureFilm");
        shortFilmRepository.save(shortFilm);
    }

    public void deleteById(Integer id) {
        System.out.println("Passou no deleteById" + id);
        shortFilmRepository.deleteById(id);
    }

}

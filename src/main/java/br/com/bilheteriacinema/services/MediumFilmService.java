package br.com.bilheteriacinema.services;

import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.models.MediumFilm;
import br.com.bilheteriacinema.repositories.FeatureFilmRepository;
import br.com.bilheteriacinema.repositories.MediumFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MediumFilmService {

    @Autowired
    MediumFilmRepository mediumFilmRepository;

    public Collection<MediumFilm> getAllMediumFilm() {
        System.out.println("Passou no getAllFeaturesFilm");
        return (Collection<MediumFilm>) mediumFilmRepository.findAll();
    }

    public void addMediumFilm(MediumFilm mediumFilm) {
        System.out.println("Passou no addFeatureFilm");
        mediumFilmRepository.save(mediumFilm);
    }

    public void deleteById(Integer id) {
        System.out.println("Passou no deleteById" + id);
        mediumFilmRepository.deleteById(id);
    }

}

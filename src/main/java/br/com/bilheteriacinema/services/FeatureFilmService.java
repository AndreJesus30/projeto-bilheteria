package br.com.bilheteriacinema.services;
import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.repositories.FeatureFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class FeatureFilmService {

    @Autowired
    FeatureFilmRepository featureFilmRepository;

    public Collection<FeatureFilm> getAllFeaturesFilm() {
        System.out.println("Passou no getAllFeaturesFilm");
        return (Collection<FeatureFilm>) featureFilmRepository.findAll();
    }

    public void addFeatureFilm(FeatureFilm featureFilm) {
        System.out.println("Passou no addFeatureFilm");
        featureFilmRepository.save(featureFilm);
    }

    public void deleteById(Integer id) {
        System.out.println("Passou no deleteById" + id);
        featureFilmRepository.deleteById(id);
    }

}

package br.com.bilheteriacinema.repositories;

import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.models.MediumFilm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumFilmRepository extends CrudRepository<MediumFilm, Integer> {
}

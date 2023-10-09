package br.com.bilheteriacinema.repositories;

import br.com.bilheteriacinema.models.FeatureFilm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureFilmRepository extends CrudRepository<FeatureFilm, Integer> {
}

package br.com.bilheteriacinema.repositories;

import br.com.bilheteriacinema.models.ShortFilm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortFilmRepository extends CrudRepository<ShortFilm, Integer> {
}

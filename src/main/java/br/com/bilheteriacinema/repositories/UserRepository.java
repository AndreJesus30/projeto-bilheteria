package br.com.bilheteriacinema.repositories;
import br.com.bilheteriacinema.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByEmail (String email);

}

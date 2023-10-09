package br.com.bilheteriacinema.services;

import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Collection<User> getAllUsers() {
        System.out.println("Passou no getAllFeaturesFilm");
        return (Collection<User>) userRepository.findAll();
    }

    public void addUser(User user) {
        System.out.println("Passou no addFeatureFilm");
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        System.out.println("Passou no deleteById User" + id);
        userRepository.deleteById(id);
    }

}

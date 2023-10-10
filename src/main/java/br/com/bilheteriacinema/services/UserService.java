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
        return (Collection<User>) userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public User userIsValid(String email, String password) {

        User currentUser = userRepository.findUserByEmail(email);

        if(currentUser != null) {

            if(password.equalsIgnoreCase(currentUser.getPassword())) {
                return currentUser;
            }
        }

      return null;

    }

}

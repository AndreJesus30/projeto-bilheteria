package br.com.bilheteriacinema;

import br.com.bilheteriacinema.models.ShortFilm;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.ShortFilmService;
import br.com.bilheteriacinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Order(3)
@Component
public class UserLoader implements ApplicationRunner  {

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        mapUser = new HashMap<Integer, ShortFilm>();

        FileReader file = new FileReader("dummyFiles/user.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] fields = null;

        while (line != null) {
            fields = line.split(";");

            User user = new User(
                fields[0],
                fields[1],
                fields[2]
            );


//            mapShortFilm.put(shortFilm.getCode(), shortFilm);
//            featureFilmService.incluir(featureFilm);

//            shortFilmController.add(shortFilm.getCode(), shortFilm);

            userService.addUser(user);
            line = reader.readLine();
        }

        Collection<User> users = userService.getAllUsers();

        for (User u : users) {
            System.out.println("Short Film Inclusão realizada: " +  u.getName() +  u.getEmail());
        }

        reader.close();
    }


}

package br.com.bilheteriacinema;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

@Order(3)
@Component
public class UserLoader implements ApplicationRunner  {

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

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

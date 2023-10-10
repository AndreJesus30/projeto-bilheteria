package br.com.bilheteriacinema.controllers;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("currentUser")
@Controller
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/valid")
    public String userIsValid(Model model, @RequestParam String email, @RequestParam String password) {

        System.out.println("Credenciais: " + email + " - " + password);
        
        User user = userService.userIsValid(email, password);

        if(user != null) {
            model.addAttribute("currentUser", user);
            return "home";
        }

        return "redirect:/login";
    }


    @GetMapping("/user/register")
    public String registerNewUser() {

        return "user/register";

    }

    @PostMapping("/user/add")
    public String addNewUser(User user) {
        
        userService.addUser(user);

        return "redirect:/";
    }


    @GetMapping("/users/list")
    public String getList(Model model) {

        model.addAttribute("usersList", userService.getAllUsers());

        return "user/list";
    }

    @GetMapping("/user/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        userService.deleteUserById(id);

        return  "redirect:/users/list";
    }

}

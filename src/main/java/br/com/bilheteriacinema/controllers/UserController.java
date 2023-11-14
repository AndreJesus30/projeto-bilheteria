package br.com.bilheteriacinema.controllers;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
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
    public String getList(Model model, @SessionAttribute("currentUser") User currentUser) {

        if(currentUser.getEmail().equalsIgnoreCase("admin@admin.com")) {
             model.addAttribute("usersList", userService.getAllUsers());
            return "user/list";
        } else {
          model.addAttribute("onlyUser", userService.getUserByEmail(currentUser.getEmail()));
            return "user/only_user";
        }

    }

    @GetMapping("/user/{id}/delete")
    public String deleteById(@PathVariable Integer id) {

        userService.deleteUserById(id);

        return  "redirect:/users/list";
    }

    @GetMapping("/user/{id}/edit")
    public String goEditById(Model model, @PathVariable Integer id) {
        System.out.println("Chamou o edit user controller");

        User user = userService.getUserById(id).orElse(null);

        if(user != null) {
            model.addAttribute("userEdited", user);
            model.addAttribute("userId", id);
            return "user/edit_user";

        }

        return  "redirect:/users/list";

    }

    @PostMapping("/user/edited_user")
    public String editUser(User userEdited) {
         System.out.println("Chamou o edited user controller");

        // Integer parseId = Integer.parseInt(id);

        System.out.println(userEdited.getName());
        System.out.println(userEdited.getEmail());

        userService.editUser(userEdited);

        return  "redirect:/users/list";

    }

}

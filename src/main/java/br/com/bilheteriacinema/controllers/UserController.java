package br.com.bilheteriacinema.controllers;

import br.com.bilheteriacinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
//
//    public Map<Integer, User> mapUser = new HashMap<Integer, User>();
//
//    public void add(Integer code, User user) {
//        mapUser.put(code, user);
//    }


    @Autowired
    UserService userService;

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

package br.com.bilheteriacinema.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;


@Controller
public class AppController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }


   @GetMapping("/login")
   public String viewLogin(HttpSession session) {
       return "login";
   }


   @GetMapping("/logout")
   public String viewLogout(HttpSession session, SessionStatus status) {

       status.setComplete();
       session.removeAttribute("currentUser");

       return "redirect:/";
   }

}

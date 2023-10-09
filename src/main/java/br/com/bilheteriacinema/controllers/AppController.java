package br.com.bilheteriacinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
public class AppController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }
//
//    @GetMapping("/login")
//    public String viewLogin() {
//        return "login";
//    }
//
//    @GetMapping("/logout")
//    public String viewLogout(HttpSession session, SessionStatus status) {
//
//        status.setComplete();
//        session.removeAttribute("user");
//
//        return "redirect:/";
//    }

}

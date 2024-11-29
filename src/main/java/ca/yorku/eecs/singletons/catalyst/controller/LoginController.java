package ca.yorku.eecs.singletons.catalyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This corresponds to login.html in the templates directory
    }
}

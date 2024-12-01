package ca.yorku.eecs.singletons.catalyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}

package ca.yorku.eecs.singletons.catalyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/patients")
    public String patients() {
        return "patients";
    }

    @GetMapping("/optometrists")
    public String optometrists() {
        return "optometrists";
    }

    @GetMapping("/assessments")
    public String assessments() {
        return "assessments";
    }
}

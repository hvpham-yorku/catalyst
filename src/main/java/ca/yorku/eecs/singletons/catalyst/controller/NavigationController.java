package ca.yorku.eecs.singletons.catalyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    /* Locates any element with href with '/' and returns a string "index"
       to spring for rendering (finding and opening) the index.html
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /* Locates any element with href with '/patients' and returns a string "patients"
       to spring for rendering (finding and opening) the patients.html
    */
    @GetMapping("/patients")
    public String patients() {
        return "patients";
    }

    /* Locates any element with href with '/assessments' and returns a string "assessments"
       to spring for rendering (finding and opening) the assessments.html
    */
    @GetMapping("/assessments")
    public String assessments() {
        return "assessments";
    }
}

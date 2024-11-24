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

}

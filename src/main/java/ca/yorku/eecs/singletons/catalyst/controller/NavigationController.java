package ca.yorku.eecs.singletons.catalyst.controller;

import ca.yorku.eecs.singletons.catalyst.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class NavigationController {
    @GetMapping("/")
    public String index(Model model) {
        var email = SecurityUtil.getSessionUser();
        model.addAttribute("isAuthenticated", email != null);
        if (email != null) model.addAttribute("email", email);
        return "index";
    }
}

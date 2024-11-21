package ca.yorku.eecs.singletons.catalyst.controller;

import ca.yorku.eecs.singletons.catalyst.model.Optometrist;
import ca.yorku.eecs.singletons.catalyst.service.OptometristService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/optometrists")
@RequiredArgsConstructor
public class OptometristController {
    private final OptometristService optometristService;

    @GetMapping
    public String optometrists(Model model) {
        model.addAttribute("optometrists", optometristService.findAll());
        model.addAttribute("optometrist", new Optometrist());
        return "optometrists";
    }

    @PostMapping
    public String createOptometrist(@Valid @ModelAttribute("optometrist")Optometrist optometrist, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("optometrist", optometrist);
            return "optometrists";
        }
        optometristService.save(optometrist);
        return "redirect:/optometrists";
    }
}

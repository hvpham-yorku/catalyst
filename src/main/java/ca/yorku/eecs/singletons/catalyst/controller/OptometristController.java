package ca.yorku.eecs.singletons.catalyst.controller;

import ca.yorku.eecs.singletons.catalyst.model.Optometrist;
import ca.yorku.eecs.singletons.catalyst.service.OptometristService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/details")
    public String optometristDetails() {
        return "optometrist-details";
    }

    @GetMapping("/{id}")
    public String getOptometristDetails(@PathVariable Integer id, Model model) {
        Optometrist optometrist = optometristService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid optometrist ID: " + id));
        model.addAttribute("optometrist", optometrist);
        return "optometrist-details"; // Thymeleaf template name
    }

    @PostMapping("/{id}")
    public String updateOptometrist(@PathVariable Integer id, @ModelAttribute Optometrist optometrist) {
        optometristService.save(optometrist);
        return "redirect:/optometrists";
    }

    @GetMapping("/{id}/delete")
    public String deleteOptometrist(@PathVariable Integer id) {
        optometristService.deleteById(id);
        return "redirect:/optometrists";
    }
}

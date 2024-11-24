package ca.yorku.eecs.singletons.catalyst.controller;

import ca.yorku.eecs.singletons.catalyst.service.OptometristService;
import ca.yorku.eecs.singletons.catalyst.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final PatientService patientService;
    private final OptometristService optometristService;

    @GetMapping
    public String assessments(Model model) {
        model.addAttribute("optometrists", optometristService.findAll());
        model.addAttribute("patients", patientService.findAll());
        return "assessments";
    }

    @GetMapping("/assessment-details")
    public String assessmentDetail(Model model) {
        model.addAttribute("optometrists", optometristService.findAll());
        model.addAttribute("patients", patientService.findAll());
        return "assessment-details"; // Not setup yet, hence the warning
    }


}


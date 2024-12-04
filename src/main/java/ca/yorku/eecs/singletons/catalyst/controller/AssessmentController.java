package ca.yorku.eecs.singletons.catalyst.controller;

import ca.yorku.eecs.singletons.catalyst.model.Optometrist;
import ca.yorku.eecs.singletons.catalyst.model.Patient;
import ca.yorku.eecs.singletons.catalyst.model.VisualAssessment;
import ca.yorku.eecs.singletons.catalyst.security.SecurityUtil;
import ca.yorku.eecs.singletons.catalyst.service.AssessmentService;
import ca.yorku.eecs.singletons.catalyst.service.OptometristService;
import ca.yorku.eecs.singletons.catalyst.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final AssessmentService assessmentService;
    private final PatientService patientService;
    private final OptometristService optometristService;

    @GetMapping
    public String assessments(Model model) {
        model.addAttribute("assessments", assessmentService.findAll());
        model.addAttribute("assessment", new VisualAssessment());
        model.addAttribute("optometrists", optometristService.findAll());
        model.addAttribute("optometrist", new Optometrist());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("patient", new Patient());

        var email = SecurityUtil.getSessionUser();
        model.addAttribute("isAuthenticated", email != null);
        if (email != null) model.addAttribute("email", email);

        return "assessments";
    }

    @PostMapping
    public String createAssessment(@Valid @ModelAttribute("assessment") VisualAssessment assessment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("assessment", assessment);
            return "assessments";
        }
        assessmentService.save(assessment);
        return "redirect:/assessments";
    }

    @GetMapping("/details")
    public String assessmentDetails() {
        return "assessment-details";
    }

    @GetMapping("/{id}")
    public String getAssessmentDetails(@PathVariable Integer id, Model model) {
        VisualAssessment assessment = assessmentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid assessment ID: " + id));
        model.addAttribute("assessment", assessment);
        model.addAttribute("optometrists", optometristService.findAll());
        model.addAttribute("patients", patientService.findAll());

        var email = SecurityUtil.getSessionUser();
        model.addAttribute("isAuthenticated", email != null);
        if (email != null) model.addAttribute("email", email);

        return "assessment-details";
    }

    @PostMapping("/{id}")
    public String updateAssessment(@PathVariable Integer id,
                                   @Valid @ModelAttribute("assessment") VisualAssessment assessment,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            model.addAttribute("optometrists", optometristService.findAll());
            model.addAttribute("patients", patientService.findAll());
            model.addAttribute("validationErrors", result.getAllErrors());
            return "assessment-details";
        }

        assessmentService.save(assessment);
        return "redirect:/assessments";
    }


    @GetMapping("/{id}/delete")
    public String deleteAssessment(@PathVariable Integer id) {
        assessmentService.deleteById(id);
        return "redirect:/assessments";
    }
}

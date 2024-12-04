package ca.yorku.eecs.singletons.catalyst.controller;

import ca.yorku.eecs.singletons.catalyst.model.Patient;
import ca.yorku.eecs.singletons.catalyst.security.SecurityUtil;
import ca.yorku.eecs.singletons.catalyst.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public String patients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("patient", new Patient());

        var email = SecurityUtil.getSessionUser();
        model.addAttribute("isAuthenticated", email != null);
        if (email != null) model.addAttribute("email", email);

        return "patients";
    }

    @PostMapping
    public String createPatient(@ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("patient", patient);
            return "patients";
        }
        patientService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/details")
    public String patientDetails() {
        return "patient-details";
    }

    @GetMapping("/{id}")
    public String getPatientDetails(@PathVariable Integer id, Model model) {
        Patient patient = patientService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID: " + id));
        model.addAttribute("patient", patient);

        var email = SecurityUtil.getSessionUser();
        model.addAttribute("isAuthenticated", email != null);
        if (email != null) model.addAttribute("email", email);

        return "patient-details";
    }

    @PostMapping("/{id}")
    public String updatePatient(@PathVariable Integer id, @ModelAttribute Patient patient) {
        patientService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}/delete")
    public String deletePatient(@PathVariable Integer id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }
}

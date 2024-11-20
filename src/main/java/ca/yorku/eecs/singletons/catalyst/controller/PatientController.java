package ca.yorku.eecs.singletons.catalyst.controller;

import ca.yorku.eecs.singletons.catalyst.dao.PatientRepository;
import ca.yorku.eecs.singletons.catalyst.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Patient> getPatientByEmail(@PathVariable String email) {
        return patientRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return patientRepository.findByEmail(patient.getEmail())
                .map(p -> ResponseEntity.status(HttpStatus.CONFLICT).body(p))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).body(patientRepository.save(patient)));
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        return patientRepository.findByEmail(patient.getEmail())
                .map(p -> {
                    patient.setId(p.getId());
                    return ResponseEntity.ok(patientRepository.save(patient));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletePatient(@PathVariable String email) {
        return patientRepository.findByEmail(email)
                .map(patient -> {
                    patientRepository.delete(patient);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

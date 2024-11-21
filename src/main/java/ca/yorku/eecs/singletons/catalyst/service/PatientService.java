package ca.yorku.eecs.singletons.catalyst.service;

import ca.yorku.eecs.singletons.catalyst.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> findAll();

    Optional<Patient> findById(Integer id);

    Patient save(Patient patient);

    void deleteById(Integer id);}

package ca.yorku.eecs.singletons.catalyst.repository;

import ca.yorku.eecs.singletons.catalyst.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}

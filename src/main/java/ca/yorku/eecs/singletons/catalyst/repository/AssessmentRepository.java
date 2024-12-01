package ca.yorku.eecs.singletons.catalyst.repository;

import ca.yorku.eecs.singletons.catalyst.model.VisualAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<VisualAssessment, Integer> {
}

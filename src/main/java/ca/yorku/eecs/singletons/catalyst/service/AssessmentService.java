package ca.yorku.eecs.singletons.catalyst.service;

import ca.yorku.eecs.singletons.catalyst.model.VisualAssessment;

import java.util.List;
import java.util.Optional;

public interface AssessmentService {
    List<VisualAssessment> findAll();

    Optional<VisualAssessment> findById(Integer id);

    VisualAssessment save(VisualAssessment assessment);

    void deleteById(Integer id);
}

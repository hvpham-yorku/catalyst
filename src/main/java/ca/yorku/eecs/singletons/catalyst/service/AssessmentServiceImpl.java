package ca.yorku.eecs.singletons.catalyst.service;

import ca.yorku.eecs.singletons.catalyst.model.VisualAssessment;
import ca.yorku.eecs.singletons.catalyst.repository.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;

    @Override
    public List<VisualAssessment> findAll() {
        return assessmentRepository.findAll();
    }

    @Override
    public Optional<VisualAssessment> findById(Integer id) {
        return assessmentRepository.findById(id);
    }

    @Override
    public VisualAssessment save(VisualAssessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public void deleteById(Integer id) {
        assessmentRepository.deleteById(id);
    }
}

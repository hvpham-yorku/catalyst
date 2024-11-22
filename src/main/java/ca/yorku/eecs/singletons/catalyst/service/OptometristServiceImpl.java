package ca.yorku.eecs.singletons.catalyst.service;

import ca.yorku.eecs.singletons.catalyst.model.Optometrist;
import ca.yorku.eecs.singletons.catalyst.repository.OptometristRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OptometristServiceImpl implements OptometristService {
    private final OptometristRepository optometristRepository;

    @Override
    public List<Optometrist> findAll() {
        return optometristRepository.findAll();
    }

    @Override
    public Optional<Optometrist> findById(Integer id) {
        return optometristRepository.findById(id);
    }

    @Override
    public Optometrist save(Optometrist optometrist) {
        return optometristRepository.save(optometrist);
    }

    @Override
    public void deleteById(Integer id) {
        optometristRepository.deleteById(id);
    }
}

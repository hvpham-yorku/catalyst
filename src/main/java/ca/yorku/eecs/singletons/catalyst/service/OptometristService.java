package ca.yorku.eecs.singletons.catalyst.service;

import ca.yorku.eecs.singletons.catalyst.model.Optometrist;

import java.util.List;
import java.util.Optional;

public interface OptometristService {
    List<Optometrist> findAll();

    Optional<Optometrist> findById(Integer id);

    Optometrist save(Optometrist optometrist);

    void deleteById(Integer id);
}

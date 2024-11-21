package ca.yorku.eecs.singletons.catalyst.service;

import ca.yorku.eecs.singletons.catalyst.model.Optometrist;

import java.util.List;

public interface OptometristService {
    List<Optometrist> findAll();

    Optometrist save(Optometrist optometrist);
}

package ca.yorku.eecs.singletons.catalyst.repository;

import ca.yorku.eecs.singletons.catalyst.model.Optometrist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptometristRepository extends JpaRepository<Optometrist, Integer> {
}

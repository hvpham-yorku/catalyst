package ca.yorku.eecs.singletons.catalyst.repository;

import ca.yorku.eecs.singletons.catalyst.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}

package ca.yorku.eecs.singletons.catalyst.service;

import ca.yorku.eecs.singletons.catalyst.model.UserEntity;

import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findByEmail(String email);
}

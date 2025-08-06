package com.codewithmosh.store.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUsersById(Long id);

    boolean existsByEmail(String email);

    Optional<User> findUsersByEmail(String email);
}

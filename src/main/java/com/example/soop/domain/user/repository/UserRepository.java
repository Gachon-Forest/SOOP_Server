package com.example.soop.domain.user.repository;

import com.example.soop.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserID(String userID);

    boolean existsByUserID(String userID);
}

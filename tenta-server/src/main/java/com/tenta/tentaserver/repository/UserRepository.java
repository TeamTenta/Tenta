package com.tenta.tentaserver.repository;

import com.tenta.tentaserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    List<User> findAllByIdIn(List<Long> ids);
    Optional<User> findByUsername(String username);
}

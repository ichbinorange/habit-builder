package com.capstone.habitbuilder.enjoyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnjoyerRepository extends JpaRepository<Enjoyer, Long> {
    Optional<Enjoyer> findEnjoyerByEmail(String email);
    Boolean existsByEmail(String email);
}
